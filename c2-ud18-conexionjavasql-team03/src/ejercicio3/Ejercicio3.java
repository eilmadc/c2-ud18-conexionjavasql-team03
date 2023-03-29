package ejercicio3;

import java.sql.Connection;
import java.sql.SQLException;

import database.Database;

public class Ejercicio3 {
	public void eje3Inicia() {
		Connection conexion = null;
		
		Database db = new Database();
		conexion = db.openConnection(conexion);
		//db.openConnection();
		
		db.dropDatabase("ejerc3", conexion);
		db.createDatabase("ejerc3", conexion);
		
		//String atributos = "codigo int PRIMARY KEY IDENTITY, lugar nvarchar(100), capacidad int";
		//db.createTable("ejer3", "Almacenes", atributos, conexion);
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
