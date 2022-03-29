package com.revature.project0.daos;


import java.util.List;

import com.revature.project0.entities.AccountEntities;

public interface AccountsDAO {

	// Create a Student
	AccountEntities createAccountById(AccountEntities account);

	// READ
	List<AccountEntities> getAllAccounts();

	List<AccountEntities> getAccountsById(int cid);
	

	// UPDATE
	AccountEntities updateAccounts(AccountEntities account);

	// DELETE
	boolean deleteAccounts(int id);
}

