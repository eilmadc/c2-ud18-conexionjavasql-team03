package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.Database;
import ejercicio3.Ejercicio3;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Database db = new Database();
		//Connection conexion = null;
		//conexion = db.openConnection(conexion);
		
		Ejercicio3 e = new Ejercicio3();
		e.eje3Inicia();
		
		
		
		
		//db.closeConnection(conexion);
	}

}
