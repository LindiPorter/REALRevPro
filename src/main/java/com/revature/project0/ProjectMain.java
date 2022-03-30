package com.revature.project0;

import io.javalin.Javalin;

public class ProjectMain {

	public static void main(String[] args) {
		Javalin app= Javalin.create().start();
		
		// Get all clients (return 200)
		app.get("/clients", ProjectHandler.getAllClients);
		
		// Create or Add a new client (return 201)
		app.post("/clients", ProjectHandler.addClient);

		// Get Client with id of 10 (return 404 if client does not exist)
		app.get("/clients/{id}", ProjectHandler.getClientsById);
		
		// Update Client with id of 12 (return 404 if client does not exist)
		app.put("clients/{id}", ProjectHandler.updateClients);
		
		// Delete Client with id of 15 (404 if does not exist, 205 if successful)
		app.delete("clients/{id}", ProjectHandler.deleteClients);
		
		// Create New Account for Client with id of 5 (return 201)
		app.post("clients/{id}/accounts", AccountsHandler.createAccountById);
		
		// Get all Accounts for Client with id of 7 (return 404 if does not exist)
		app.get("clients/{id}/accounts", AccountsHandler.getAccountsById);

	}

}
