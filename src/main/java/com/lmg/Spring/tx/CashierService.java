package com.lmg.Spring.tx;

import java.util.List;

public interface CashierService {
	public void checkout(List<String> isbts,String username);
}
