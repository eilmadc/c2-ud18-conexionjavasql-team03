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

		String atributos1 = "	codigo int PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "    lugar char(100),\r\n"
				+ "    capacidad int";
		db.createTable("ejerc3", "Almacenes", atributos1, conexion);
		String atributos2 = "num_referencia char(5) PRIMARY KEY,"
				+ "	contenido char(100),"
				+ "	valor int,"
				+ "	almacen int,"
				+ "	FOREIGN KEY (almacen) REFERENCES Almacenes (codigo)"
				+ "	ON DELETE CASCADE ON UPDATE CASCADE";
		db.createTable("ejerc3", "Cajas", atributos2, conexion);
		db.insertData("ejerc3", "Almacenes", "1, 'Tarragona', 6", conexion);
		db.insertData("ejerc3", "Almacenes", "2, 'Barcelona', 7", conexion);
		db.insertData("ejerc3", "Almacenes", "3, 'Girona', 5", conexion);
		db.insertData("ejerc3", "Almacenes", "4, 'Cambrils', 4", conexion);
		db.insertData("ejerc3", "Almacenes", "5, 'Lleida', 5", conexion);
		db.insertData("ejerc3", "Cajas", "1, 'Tomates', 5, 1", conexion);
		db.insertData("ejerc3", "Cajas", "2, 'Manzanas', 3, 2", conexion);
		db.insertData("ejerc3", "Cajas", "3, 'Limones', 4, 3", conexion);
		db.insertData("ejerc3", "Cajas", "4, 'Pasta', 12, 4", conexion);
		db.insertData("ejerc3", "Cajas", "5, 'Pesto', 34, 5", conexion);

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
