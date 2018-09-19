package com.lmg.Spring.tx.xml.service;

import java.util.List;

public interface CashierService {
	public void checkout(List<String> isbts,String username);
}
