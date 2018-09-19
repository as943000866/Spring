package com.lmg.Spring.hibernate;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmg.Spring.hibernate.service.BookShopService;
import com.lmg.Spring.hibernate.service.CashierService;

public class SpringHibernateTest {
	
	private ApplicationContext ctx = null;
	private BookShopService bookShopService;
	private CashierService cashierService;
	{
		ctx = new ClassPathXmlApplicationContext("ApplicationContext-hibernate.xml");
		bookShopService = ctx.getBean(BookShopService.class);
		cashierService = ctx.getBean(CashierService.class);
	}
	
	@Test
	public void testCashierService() {
		List<String> isbns = Arrays.asList("1001","1002");
		cashierService.checkout("AA", isbns );
	}
	
	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1001");
	}
	
	@Test
	public void testDataSource() throws SQLException{
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
