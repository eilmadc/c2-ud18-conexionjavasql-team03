package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.Database;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		Connection conexion = db.openConnection();
		db.openConnection();
		
		
		
		
		
		db.closeConnection(conexion);
	}

}
