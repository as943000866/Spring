package com.lmg.Spring.tx.xml.service;

public interface BookShopService {
	/**
	 * 书店购买方法   根据书号 isbn 和用户名  username 更新用户账户和书的库存
	 * @param isbtn
	 * @param username
	 */
	public void purchase(int isbn,String username);
	
}
