package com.lmg.Spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmg.Spring.hibernate.service.BookShopService;
import com.lmg.Spring.hibernate.service.CashierService;


@Service
public class CashierServiceImpl implements CashierService{

	@Autowired
	private BookShopService bookShopService;
	
	@Override
	public void checkout(String username, List<String> isbns) {

		for (String isbn : isbns) {
			bookShopService.purchase(username, isbn);
		}
		
	}

}
