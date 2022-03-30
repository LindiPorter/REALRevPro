package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.ConnectionUtils;
import com.revature.project0.entities.ClientsEntities;

public class ClientsPosgresDAO implements ClientsDAO {

	@Override
	public ClientsEntities addClient(ClientsEntities c1) {

		Connection conn = ConnectionUtils.createConnection();

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("Insert into clients Values (?,?)");
			pstmt.setInt(1, c1.getId());
			pstmt.setString(2, c1.getName());
			pstmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ClientsEntities> getAllClients() {
		// TODO Auto-generated method stub
		/*Connection conn = ConnectionUtils.createConnection();

		PreparedStatement pstmt = conn.prepareStatement(selectAllClients);		
		ResultSet rs= pstmt.executeQuery();*/
		ArrayList<ClientsEntities> ctList = new ArrayList<ClientsEntities>();
		String selectAllClients = "SELECT * from clients";

		try {Connection conn = ConnectionUtils.createConnection();

			PreparedStatement pstmt = conn.prepareStatement(selectAllClients);		
			ResultSet rs= pstmt.executeQuery();

			ClientsEntities ct;
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("full_name");
				ct = new ClientsEntities(id, name);
				ctList.add(ct);

		} } catch (SQLException e) {
			e.printStackTrace();
		}
	
		return ctList;


	}

	@Override
	public List<ClientsEntities> getClientsById(int cid) {
		// int cid= Integer.parseInt(ctx.pathParam("id"));
		List<ClientsEntities> ct1List = new ArrayList<ClientsEntities>();
		
		try {Connection conn = ConnectionUtils.createConnection();
		String selectClients = "SELECT * from clients WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(selectClients);
			pstmt.setInt(1, cid);
			ResultSet rs = pstmt.executeQuery();
			
			ClientsEntities ct1;
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("full_name");
				ct1 = new ClientsEntities(id, name);
				ct1List.add(ct1);
		} } catch (SQLException e) {

			e.printStackTrace();
		}
	
		return ct1List;
	}

	@Override
	public ClientsEntities updateClients(ClientsEntities c1, int id) {
		// int id= Integer.parseInt(ctx.pathParam("id"));
		// ClientsEntities c1 = ctx.bodyAsClass(ClientsEntities.class);

		Connection conn = ConnectionUtils.createConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE clients set full_name=? WHERE id=?");
			pstmt.setString(1, c1.getName());
			pstmt.setInt(2, id);
			pstmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public boolean deleteClients(int cid) {
		// int cid= Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtils.createConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE from clients WHERE id=?");
			pstmt.setInt(1, cid);
			pstmt.execute();
			return true; 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return false;
	}

}
