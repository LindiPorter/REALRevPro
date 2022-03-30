package com.revature.project0;

import java.util.List;

import com.revature.project0.daos.AccountPosgresDAO;
import com.revature.project0.daos.AccountsDAO;
import com.revature.project0.entities.AccountEntities;
import io.javalin.http.Handler;

public class AccountsHandler {

	static AccountsDAO dao= new AccountPosgresDAO ();
	
	public static Handler getAccountsById = ctx -> {

		// Connection from ConnectionUtils Class
		int cid = Integer.parseInt(ctx.pathParam("id"));
		List<AccountEntities> acList = dao.getAccountsById(cid);
		
		/*Connection conn = ConnectionUtils.createConnection();

		String selectAllAccounts = "SELECT * from Accounts WHERE client_id=?";

		PreparedStatement pstmt = conn.prepareStatement(selectAllAccounts);
		pstmt.setInt(1, cid);
		

		ResultSet rs = pstmt.executeQuery();
		ArrayList<AccountEntities> acList = new ArrayList<AccountEntities>();
		AccountEntities ac;

		while (rs.next()) {
			int id = rs.getInt("client_id");
			String account = rs.getString("account_number");
			int balance= rs.getInt("account_balance");
			ac = new AccountEntities(account, balance, id, cid);
			acList.add(ac);
		}*/

		if (acList.size() == 0)
			ctx.status(404);

		ctx.json(acList);
		/*rs.close();
		pstmt.close();*/

	};

	public static Handler createAccountById = ctx -> {
		AccountEntities a1 = ctx.bodyAsClass(AccountEntities.class);
		AccountEntities a = dao.createAccountById(a1);
		/*Connection conn = ConnectionUtils.createConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("Insert into Accounts Values (?,?,?,?)");
		pstmt.setInt(1, a1.getId());
		pstmt.setString(2, a1.getAccount());
		pstmt.setInt(3, a1.getBalance());
		pstmt.setInt(4, a1.getCid());
		pstmt.execute();*/
		
		ctx.status(201);
		
		
	};
}