package com.lmg.Spring.tx.xml.service.impl;

import java.util.List;

import com.lmg.Spring.tx.xml.service.BookShopService;
import com.lmg.Spring.tx.xml.service.CashierService;

public class CashierServiceImpl implements CashierService{
	
	BookShopService bookShopService;
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void checkout(List<String> isbts, String username) {
		
		for (String isbn : isbts) {
			bookShopService.purchase(Integer.parseInt(isbn), username);
		}
		
	}
	
	
}
