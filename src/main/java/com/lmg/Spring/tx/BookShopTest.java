package com.lmg.Spring.tx;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookShopTest {
	
	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao =null;
	private BookShopService bookShopService = null;
	private CashierService cashierService = null;

	{
		ctx = new ClassPathXmlApplicationContext("beans-tx.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashierService = ctx.getBean(CashierService.class);
	}
	
	@Test
	public void CashierService(){
		
		List<String> isbts = new ArrayList<>();
		isbts.add(0, "1001");
		isbts.add(1, "1002");
		cashierService.checkout(isbts , "AA");
	}
	
	@Test
	public void bookShopService(){
		bookShopService.purchase(1001, "AA");
	}
	
	@Test
	public void findBookPriceByIsbn(){
		int price = bookShopDao.findBookPriceByIsbn(1001);
		System.out.println(price);
	}
	
	@Test
	public void updateBookStock(){
		bookShopDao.updateBookStock(1001);
	}
	
	@Test
	public void updateAccount(){
		bookShopDao.updateAccount("AA", 110);
	}
}
