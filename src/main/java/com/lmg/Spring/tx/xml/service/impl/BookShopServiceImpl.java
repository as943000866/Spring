package com.lmg.Spring.tx.xml.service.impl;

import com.lmg.Spring.tx.xml.BookShopDao;
import com.lmg.Spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	@Override	
	public void purchase(int isbn, String username) {
		//获取价格
		int balance = bookShopDao.findBookPriceByIsbn(isbn);
		
		//更新库存
		bookShopDao.updateBookStock(isbn);
		
		//更新价格
		bookShopDao.updateAccount(username, balance);
	}

}
