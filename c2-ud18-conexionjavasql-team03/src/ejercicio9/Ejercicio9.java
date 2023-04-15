package ejercicio9;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

public class Ejercicio9 {
	public void eje9Inicia() {

		Connection conexion = null;

		Database db = new Database();
		conexion = db.openConnection(conexion);
		// db.openConnection();

		db.dropDatabase("ejerc9", conexion);
		db.createDatabase("ejerc9", conexion);

		String atributos1 = "codigo int PRIMARY KEY AUTO_INCREMENT,\r\n" + "    nombre char(100)";
		db.createTable("ejerc9", "Facultades", atributos1, conexion);

		String atributos2 = "dni char(8) PRIMARY KEY,\r\n" + "	nom_apels char(100),\r\n" + "	facultad int,\r\n"
				+ "	FOREIGN KEY (facultad) REFERENCES Facultades (codigo)\r\n"
				+ "	ON DELETE CASCADE ON UPDATE CASCADE";
		db.createTable("ejerc9", "Investigadores", atributos2, conexion);

		String atributos3 = "num_serie char(3) PRIMARY KEY,\r\n" + "	nombre varchar(100),\r\n"
				+ "	facultad int,\r\n" + "	FOREIGN KEY (facultad) REFERENCES Facultades (codigo)\r\n"
				+ "	ON DELETE CASCADE ON UPDATE CASCADE";
		db.createTable("ejerc9", "Equipos", atributos3, conexion);

		String atributos4 = "dni char(8),\r\n" + "	num_serie char(3),\r\n" + "	comienzo date,\r\n" + "	fin date,\r\n"
				+ "	PRIMARY KEY(dni, num_serie),\r\n" + "	FOREIGN KEY (dni) REFERENCES Investigadores (dni),\r\n"
				+ "	FOREIGN KEY (num_serie) REFERENCES Equipos (num_serie)\r\n"
				+ "	ON DELETE CASCADE ON UPDATE CASCADE";
		db.createTable("ejerc9", "Reservas", atributos4, conexion);

		db.insertData("ejerc9", "Facultades", "1, 'RecursosHumanos'", conexion);
		db.insertData("ejerc9", "Facultades", "2, 'Marketing'", conexion);
		db.insertData("ejerc9", "Facultades", "3, 'Sanidad'", conexion);
		db.insertData("ejerc9", "Facultades", "4, 'Seguridad'", conexion);
		db.insertData("ejerc9", "Facultades", "5, 'NombreFacu5'", conexion);

		db.insertData("ejerc9", "Investigadores", "1111, 'Juan',1", conexion);
		db.insertData("ejerc9", "Investigadores", "2222, 'Sandra',2", conexion);
		db.insertData("ejerc9", "Investigadores", "3333, 'Elena',3", conexion);
		db.insertData("ejerc9", "Investigadores", "4444, 'Marc',4", conexion);
		db.insertData("ejerc9", "Investigadores", "5555, 'Sara',5", conexion);

		db.insertData("ejerc9", "Equipos", "'aaa', 'Nombre1', 1", conexion);
		db.insertData("ejerc9", "Equipos", "'bbb', 'Nombre2', 2", conexion);
		db.insertData("ejerc9", "Equipos", "'ccc', 'Nombre3', 3", conexion);
		db.insertData("ejerc9", "Equipos", "'ddd', 'Nombre4', 4", conexion);
		db.insertData("ejerc9", "Equipos", "'eee', 'Nombre5', 5", conexion);

		db.insertData("ejerc9", "Reservas", "1111, 'aaa', '2018-10-20', '2019-10-20' ", conexion);
		db.insertData("ejerc9", "Reservas", "2222, 'bbb', '2018-10-21', '2019-10-21'", conexion);
		db.insertData("ejerc9", "Reservas", "3333, 'ccc', '2018-10-22', '2019-10-22'", conexion);
		db.insertData("ejerc9", "Reservas", "4444, 'ddd', '2018-10-23', '2019-10-23'", conexion);
		db.insertData("ejerc9", "Reservas", "5555, 'eee', '2018-10-24', '2019-10-24'", conexion);

		ResultSet resultSet = db.getValues("ejerc9", "Reservas", conexion);
		try {
			while (resultSet.next()) {
				System.out.println("Investigador: " + resultSet.getInt("dni"));
				System.out.println("Equipo: " + resultSet.getString("num_serie"));
				System.out.println("Data Inicio: " + resultSet.getString("comienzo").toString());
				System.out.println("Data Fin: " + resultSet.getString("fin").toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.closeConnection(conexion);
	}
}