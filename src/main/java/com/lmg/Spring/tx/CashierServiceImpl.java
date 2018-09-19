package com.lmg.Spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierServiceImpl implements CashierService{
	@Autowired
	BookShopService bookShopService;

	
	@Transactional
	@Override
	public void checkout(List<String> isbts, String username) {
		
		for (String isbn : isbts) {
			bookShopService.purchase(Integer.parseInt(isbn), username);
		}
		
	}
	
	
}
