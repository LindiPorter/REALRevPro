package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.ConnectionUtils;
import com.revature.project0.entities.AccountEntities;

public class AccountPosgresDAO implements AccountsDAO {

	@Override
	public AccountEntities createAccountById(AccountEntities a1) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtils.createConnection();
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("Insert into Accounts Values (?,?,?,?)");
			pstmt.setInt(1, a1.getId());
			pstmt.setString(2, a1.getAccount());
			pstmt.setInt(3, a1.getBalance());
			pstmt.setInt(4, a1.getCid());
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<AccountEntities> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountEntities> getAccountsById(int cid) {
		List<AccountEntities> acList = new ArrayList<AccountEntities>();
		try(Connection conn = ConnectionUtils.createConnection()) {

		String selectAllAccounts = "SELECT * from Accounts WHERE client_id=?";
		PreparedStatement pstmt= conn.prepareStatement(selectAllAccounts);
		pstmt.setInt(1, cid);
		ResultSet rs = pstmt.executeQuery();
		
		AccountEntities ac;
			while (rs.next()) {
				int id = rs.getInt("client_id");
				String account = rs.getString("account_number");
				int balance= rs.getInt("account_balance");
				ac = new AccountEntities(account, balance, id, cid);
					acList.add(ac);
			}}	 catch (SQLException e) {
			e.printStackTrace();
		}
		return acList;
	}

	@Override
	public AccountEntities updateAccounts(AccountEntities account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccounts(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
