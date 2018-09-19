package com.lmg.Spring.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lmg.Spring.tx.StockException;
import com.lmg.Spring.tx.AccountException;
import com.lmg.spirng.hibernate.dao.BookShopDao;

@Repository
public class BookShopDaoImpl implements BookShopDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		
		int price = (int) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		
		return price;
	}

	@Override
	public void updateBookStock(String isbn) {
		//查看库存是否足够
		String hql = "SELECT b.stock FROM Book b WHERE b.isbn = ?";
		
		int stock = (int) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		
		if(stock == 0){
			throw new StockException("库存不足");
		}
		
		String hql2 = "UPDATE Book b SET b.stock = b.stock - 1 WHERE isbn = ?";
		
		getSession().createQuery(hql2).setString(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
		//验证帐户余额是否足够
		String hql = "SElECT a.balance FROM Account a WHERE a.username = ?";
		
		int balance = (int) getSession().createQuery(hql).setString(0, username).uniqueResult();
		
		if(balance < price){
			throw new AccountException("余额不足");
		}
		
		String hql2 = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.username = ?";
		
		getSession().createQuery(hql2).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
