package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.Database;
import ejercicio3.Ejercicio3;
import ejercicio6.Ejercicio6;
import ejercicio9.Ejercicio9;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Database db = new Database();
		//Connection conexion = null;
		//conexion = db.openConnection(conexion);
		
//		Ejercicio3 e3 = new Ejercicio3();
//		e3.eje3Inicia();
//		Ejercicio6 e6 = new Ejercicio6();
//		e6.eje6Inicia();
		Ejercicio9 e9 = new Ejercicio9();
		e9.eje9Inicia();
		
		
		
		
		//db.closeConnection(conexion);
	}

}
