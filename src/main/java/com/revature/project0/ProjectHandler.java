package com.revature.project0;

import java.util.List;

import com.revature.project0.daos.ClientsDAO;
import com.revature.project0.daos.ClientsPosgresDAO;
import com.revature.project0.entities.ClientsEntities;

import io.javalin.http.Handler;

public class ProjectHandler {
	
	static ClientsDAO dao= new ClientsPosgresDAO ();

	public static Handler getAllClients = ctx -> {
		List<ClientsEntities> ctList = dao.getAllClients();
		// Connection from ConnectionUtils Class
		
		/*Connection conn = ConnectionUtils.createConnection();

		String selectAllClients = "SELECT * from clients";

		PreparedStatement pstmt = conn.prepareStatement(selectAllClients);
		ResultSet rs = pstmt.executeQuery();

		ArrayList<ClientsEntities> ctList = new ArrayList<ClientsEntities>();
		ClientsEntities ct;

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("full_name");
			ct = new ClientsEntities(id, name);
			ctList.add(ct);*/
			ctx.status(200);
	
		ctx.json(ctList);
		//rs.close();
		//pstmt.close();
		
	
	};

	public static Handler addClient = ctx-> {
		
		ClientsEntities c1 = ctx.bodyAsClass(ClientsEntities.class);
		ClientsEntities c = dao.addClient(c1);
		//Connection conn = ConnectionUtils.createConnection();
		
		/*PreparedStatement pstmt = conn.prepareStatement("Insert into Clients Values (?,?)");
		pstmt.setInt(1, c1.getId());
		pstmt.setString(2, c1.getName());
		pstmt.execute();
		
		pstmt.close();*/
		ctx.status(201);
		
	};

	
	public static Handler getClientsById = ctx -> {
		int cid= Integer.parseInt(ctx.pathParam("id"));
		List<ClientsEntities> ct1List = dao.getClientsById(cid);
		
		/*Connection conn = ConnectionUtils.createConnection();
		
		String selectClients = "SELECT * from Clients WHERE id=?";
		
		PreparedStatement pstmt= conn.prepareStatement(selectClients);
		pstmt.setInt(1, cid);
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<ClientsEntities> ct1List = new ArrayList<ClientsEntities>();
		ClientsEntities ct1;
		
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString ("full_name");
				ct1 = new ClientsEntities(id, name);
				ct1List.add(ct1);
			}*/
				
			if (ct1List.size()==0)
				ctx.status(404);
		
			ctx.json(ct1List);
			//rs.close();
			//pstmt.close();
		
	};
	
	public static Handler updateClients = ctx -> {
		int id= Integer.parseInt(ctx.pathParam("id"));
		ClientsEntities c1 = ctx.bodyAsClass(ClientsEntities.class);
		ClientsEntities c2 = dao.updateClients(c1, id);
		
		/*Connection conn = ConnectionUtils.createConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("UPDATE Clients set full_name=? wHERE id=?");
		pstmt.setString(1, c1.getName());
		pstmt.setInt(2, id);
		pstmt.execute();*/
		
		if (c2==null) {
			ctx.status(404);
		} else {
		ctx.status(200);
	}
		//pstmt.close();
	
		
	};
	
	public static Handler deleteClients = ctx -> {
		int cid= Integer.parseInt(ctx.pathParam("id"));
		if (dao.deleteClients(cid)) {
			ctx.status(205);
	
		} else {
			ctx.status(404);
		}
		/*Connection conn = ConnectionUtils.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("DELETE from Clients WHERE id=?");
		pstmt.setInt(1, cid);
		pstmt.execute();*/
		
		//ctx.status(205);
		
		//pstmt.close();
			
};

}

