package com.revature.project0.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.project0.daos.AccountPosgresDAO;
import com.revature.project0.daos.AccountsDAO;
import com.revature.project0.entities.AccountEntities;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountTests {
	private static AccountsDAO dao = new AccountPosgresDAO ();
	private static AccountEntities account; 
	
	@BeforeAll
	static void DataReset () {
		dao.deleteAccounts(0);
	}
	
	@Test
	@Order(1)
	void createAccountById () {
		AccountEntities a1 = new AccountEntities ("C3", 4500, 3, 3);
		dao.createAccountById(a1);
		AccountTests.account=a1;
		Assertions.assertEquals("C3", account.getAccount());
	}
	
	@Test 
	@Order(2)
	void getAccountById () {
		AccountEntities a1 = new AccountEntities ("C3", 4500, 3, 3);
		List<AccountEntities> emptyList = new ArrayList<AccountEntities> ();
		List<AccountEntities> usedList = new ArrayList<AccountEntities> ();
		usedList = dao.getAccountsById(a1.getId());
		Assertions.assertNotEquals(emptyList, usedList);
		
}
}
