package com.revature.project0.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.project0.daos.ClientsDAO;
import com.revature.project0.daos.ClientsPosgresDAO;
import com.revature.project0.entities.ClientsEntities;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestingCases {
	
	private static ClientsDAO dao= new ClientsPosgresDAO ();
	private static ClientsEntities client; 
	
	@BeforeAll
	static void DataReset () {
		dao.deleteClients(100);
	}
	
	@Test
	@Order(1)
	void addClient () {
		ClientsEntities c1 = new ClientsEntities (100, "Lindi");
		dao.addClient(c1);
		TestingCases.client=c1;
		Assertions.assertEquals(100, client.getId());
	}
	
	@Test
	@Order(2)
	void getClientById () {
		ClientsEntities c1 = new ClientsEntities (100, "Lindi");
		List<ClientsEntities> emptyList = new ArrayList<ClientsEntities> ();
		List<ClientsEntities> usedList = new ArrayList<ClientsEntities> ();
		usedList = dao.getClientsById(c1.getId());
		Assertions.assertNotEquals(emptyList, usedList);
	}
	
	@Test
	@Order(3)
	void getAllClients () {
		List<ClientsEntities> emptyList = new ArrayList<ClientsEntities> ();
		List<ClientsEntities> usedList = new ArrayList<ClientsEntities> ();
		usedList = dao.getAllClients();
		Assertions.assertNotEquals(emptyList, usedList);
	}
	
	@Test
	@Order(4)
	void updateClient () {
		ClientsEntities c1 = new ClientsEntities (100, "Jaunzel");
		dao.updateClients(c1, 100);
		TestingCases.client=c1;
		Assertions.assertEquals(c1, client);
	}
	
	@Test
	@Order(5)
	void deleteClient () {
		ClientsEntities c1 = new ClientsEntities (100, "Lindi");
		dao.deleteClients(c1.getId());
		Assertions.assertNotEquals(c1, client);
	}
	
	
}

