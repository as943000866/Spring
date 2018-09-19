package com.lmg.Spring.tx.xml;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImple implements BookShopDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int findBookPriceByIsbn(int isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	@Override
	public void updateBookStock(int isbn) {
		// 库存检查
		String sql1 = "SELECT stock FROM book_stock WHERE isbn = ?";
		Integer stock = jdbcTemplate.queryForObject(sql1, Integer.class, isbn);
		if (stock == 0) {
			throw new StockException("库存不足");
		}

		String sql = "UPDATE book_stock SET stock = stock-1 WHERE isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateAccount(String username, int balance) {

		// 账户余额检查
		String sql1 = "SELECT balance FROM account WHERE username = ?";
		Integer balance1 = jdbcTemplate.queryForObject(sql1, Integer.class, username);
		if (balance1 < balance) {
			throw new AccountException("账户余额不足");
		}
		String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql, balance, username);

	}

}
