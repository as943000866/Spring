package com.lmg.Spring.tx.xml;

public interface BookShopDao {
	
	/**
	 * 根据书号获取书的价格
	 * @param isbn
	 * @return
	 */
	public int findBookPriceByIsbn(int isbn);
	/**
	 * 根据书号更新书的库存,每次书的库存减一
	 * @param isbn
	 */
	public void updateBookStock(int isbn);
	/**
	 * 根据用户名更新账号余额,新的账户余额为当前账户余额减书的单价
	 * @param username
	 * @param balance
	 */
	public void updateAccount(String username,int balance);
}
