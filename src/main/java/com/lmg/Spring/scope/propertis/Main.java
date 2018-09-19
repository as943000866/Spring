package com.lmg.Spring.scope.propertis;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-propertis.xml");
		
		DataSource dataSource = (DataSource) ctx.getBean("DataSource");
		System.out.println(dataSource.getConnection());
	}
}
