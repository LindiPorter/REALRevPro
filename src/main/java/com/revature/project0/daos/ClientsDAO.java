package com.revature.project0.daos;

import java.util.List;

import com.revature.project0.entities.ClientsEntities;

public interface ClientsDAO {

	// Create a Client
	ClientsEntities addClient(ClientsEntities c1);

	// Read Clients
	List<ClientsEntities> getAllClients();

	List<ClientsEntities> getClientsById(int id);

	// Update Clients
	ClientsEntities updateClients(ClientsEntities c1, int id);

	// Delete Clients
	boolean deleteClients(int id);
}
