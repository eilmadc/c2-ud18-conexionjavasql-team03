package ejercicio2;

import database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio2 {
	public void eje2Inicia() {
		Connection conexion = null;

		Database db = new Database();

		// Abre la conexion
		conexion = db.openConnection(conexion);

		// Elimina la base de datos
		db.dropDatabase("ejercicio2", conexion);

		// Crea la base de datos
		db.createDatabase("ejercicio2", conexion);

		String atributos = "";

		// Crea tabla departamentos
		atributos = "codigo int PRIMARY KEY AUTO_INCREMENT, nombre varchar(100), presupuesto int";
		db.createTable("ejercicio2", "departamentos", atributos, conexion);

		// Crea tabla empleados
		atributos = "dni varchar(8) PRIMARY KEY, nombre varchar(100), apellidos varchar(255), departamento int";
		db.createTable("ejercicio2", "empleados", atributos, conexion);

		// Añade departamentos
		atributos = "101, 'Recursos Humanos', 65000";
		db.insertData("ejercicio2", "departamentos", atributos, conexion);

		atributos = "102, 'Finanzas', 73000";
		db.insertData("ejercicio2", "departamentos", atributos, conexion);

		atributos = "103, 'Marketing', 142000";
		db.insertData("ejercicio2", "departamentos", atributos, conexion);

		atributos = "104, 'Logistica', 80000";
		db.insertData("ejercicio2", "departamentos", atributos, conexion);

		atributos = "105, 'IT', 125000";
		db.insertData("ejercicio2", "departamentos", atributos, conexion);

		// Añade empleados
		atributos = "85769384, 'Javier', 'Martinez Soler', 105 ";
		db.insertData("ejercicio2", "empleados", atributos, conexion);

		atributos = "57438693, 'Emp', 'Leado Delmes', 101 ";
		db.insertData("ejercicio2", "empleados", atributos, conexion);

		atributos = "17482954, 'Celia', 'Herrera Flores', 103 ";
		db.insertData("ejercicio2", "empleados", atributos, conexion);

		atributos = "98047281, 'Yolanda', 'Saez Montero', 104 ";
		db.insertData("ejercicio2", "empleados", atributos, conexion);

		atributos = "90836455, 'Sergio', 'Mora Martin', 105 ";
		db.insertData("ejercicio2", "empleados", atributos, conexion);

		// Muestra la informacion de las tablas departamentos y empleados
		ResultSet resultSet = db.getValues("ejercicio2", "departamentos", conexion);
		try {
			System.out.println("\n-- DEPARTAMENTOS --\n");
			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getInt("codigo"));
				System.out.println("Nombre: " + resultSet.getString("nombre"));
				System.out.println("Presupuesto: " + resultSet.getInt("presupuesto"));
				System.out.println("----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet resultSet2 = db.getValues("ejercicio2", "empleados", conexion);
		try {
			System.out.println("\n-- EMPLEADOS --\n");
			while (resultSet2.next()) {
				System.out.println("DNI: " + resultSet2.getString("dni"));
				System.out.println("Nombre: " + resultSet2.getString("nombre"));
				System.out.println("Apellidos: " + resultSet2.getString("apellidos"));
				System.out.println("Departamento: " + resultSet2.getInt("departamento"));
				System.out.println("----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Cierra la conexion
		db.closeConnection(conexion);
	}
}