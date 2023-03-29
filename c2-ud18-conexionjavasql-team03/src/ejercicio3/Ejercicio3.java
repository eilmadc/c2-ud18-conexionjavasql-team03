package ejercicio3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

public class Ejercicio3 {
	public void eje3Inicia() {
		Connection conexion = null;

		Database db = new Database();
		conexion = db.openConnection(conexion);
		// db.openConnection();

		db.dropDatabase("ejerc3", conexion);
		db.createDatabase("ejerc3", conexion);

		String atributos = "codigo int PRIMARY KEY AUTO_INCREMENT, lugar nvarchar(100), capacidad int";
		db.createTable("ejerc3", "Almacenes", atributos, conexion);
		db.insertData("ejerc3", "Almacenes", "3, 'Tarragona', 6", conexion);

		ResultSet resultSet = db.getValues("ejerc3", "Almacenes", conexion);
		try {
			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getInt("codigo"));
				System.out.println("lugar: " + resultSet.getString("lugar"));
				System.out.println("capacidad: " + resultSet.getInt("capacidad"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.deleteDatabase("ejerc3", "Almacenes", "codigo", Integer.toString(3), conexion);
		db.closeConnection(conexion);
	}
}
