package ejercicio6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

public class Ejercicio6 {
	public void eje6Inicia() {

		Connection conexion = null;

		Database db = new Database();
		conexion = db.openConnection(conexion);
		// db.openConnection();

		db.dropDatabase("ejerc6", conexion);
		db.createDatabase("ejerc6", conexion);

		String atributos1 = "codigo int PRIMARY KEY AUTO_INCREMENT,\r\n" + "    nombre char(100)";
		db.createTable("ejerc6", "Piezas", atributos1, conexion);

		String atributos2 = "id char(4) PRIMARY KEY,\r\n" + "    nombre char(100)";
		db.createTable("ejerc6", "Proveedores", atributos2, conexion);

		String atributos3 = "codigo_pieza int,\r\n" + "	id_proveedor char(4),\r\n" + "	precio int,\r\n"
				+ "	PRIMARY KEY(codigo_pieza, id_proveedor),\r\n"
				+ "	FOREIGN KEY (codigo_pieza) REFERENCES Piezas (codigo),\r\n"
				+ "	FOREIGN KEY (id_proveedor) REFERENCES Proveedores (id)\r\n"
				+ "	ON DELETE CASCADE ON UPDATE CASCADE";
		db.createTable("ejerc6", "Suministra", atributos3, conexion);

		db.insertData("ejerc6", "Piezas", "1, 'Pieza1'", conexion);
		db.insertData("ejerc6", "Piezas", "2, 'Pieza2'", conexion);
		db.insertData("ejerc6", "Piezas", "3, 'Pieza3'", conexion);
		db.insertData("ejerc6", "Piezas", "4, 'Pieza4'", conexion);
		db.insertData("ejerc6", "Piezas", "5, 'Pieza5'", conexion);

		db.insertData("ejerc6", "Proveedores", "1111, 'Juan'", conexion);
		db.insertData("ejerc6", "Proveedores", "2222, 'Sandra'", conexion);
		db.insertData("ejerc6", "Proveedores", "3333, 'Elena'", conexion);
		db.insertData("ejerc6", "Proveedores", "4444, 'Marc'", conexion);
		db.insertData("ejerc6", "Proveedores", "5555, 'Sara'", conexion);

		db.insertData("ejerc6", "Suministra", "1, 1111, 23", conexion);
		db.insertData("ejerc6", "Suministra", "2, 2222, 34", conexion);
		db.insertData("ejerc6", "Suministra", "3, 3333, 45", conexion);
		db.insertData("ejerc6", "Suministra", "4, 4444, 56", conexion);
		db.insertData("ejerc6", "Suministra", "5, 5555, 67", conexion);

		ResultSet resultSet = db.getValues("ejerc6", "Suministra", conexion);
		try {
			while (resultSet.next()) {
				System.out.println("Pieza: " + resultSet.getInt("codigo_pieza"));
				System.out.println("Proveedor: " + resultSet.getString("id_proveedor"));
//				System.out.println("capacidad: " + resultSet.getInt("capacidad"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.closeConnection(conexion);
	}
}
