/*
 * C2-UD18-Team3(Roger, Arnau, Elena)
 */

package ejercicio5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import utils.ColorConsole;
import utils.Utils;

public class Ejercicio5 {
	public void eje5Inicia() {

		// --------- Variables ------------
		Utils utils = new utils.Utils();
		ColorConsole cc = new utils.ColorConsole();
		Connection conexion = null;
		Database db = new Database();

		utils.mostrarPrograma("UD18-Ejercicio 5: LOS DIRECTORES");

		// --Abrir conexion--
		conexion = db.openConnection(conexion);

		// --Comprobar si existe y eliminamos db.
		db.dropDatabase("ejercicio5", conexion);
		// --Crears base de datos
		db.createDatabase("ejercicio5", conexion);

		// --Cadena que contiene los atributos de la tablas
		String atributosDespachos = "numero int PRIMARY KEY AUTO_INCREMENT, capacidad int";
		String atributosDirectores = "dni varchar(8) PRIMARY KEY, nomapels varchar(255), dnijefe varchar(8), despacho int";

		// --datos
		String des1 = "1, 540";
		String des2 = "2, 127";
		String des3 = "3, 80";
		String des4 = "4, 25";
		String des5 = "5, 43";
		String dir1 = "85769384, 'Javier Martinez Soler', '', 5";
		String dir2 = "57438693, 'Emp Leado Delmes', '', 1 ";
		String dir3 = "17482954, 'Celia Herrera Flores', '', 3 ";
		String dir4 = "98047281, 'Yolanda Saez Montero', '57438693', 1 ";
		String dir5 = "90836455, 'Sergio Mora Martin', '85769384', 5 ";

		// --Creacion tablas: departamentos y empleados, con sus atributos
		db.createTable("ejercicio5", "despachos", atributosDespachos, conexion);
		db.createTable("ejercicio5", "directores", atributosDirectores, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: despachos
		db.insertData("ejercicio5", "despachos", des1, conexion);
		db.insertData("ejercicio5", "despachos", des2, conexion);
		db.insertData("ejercicio5", "despachos", des3, conexion);
		db.insertData("ejercicio5", "despachos", des4, conexion);
		db.insertData("ejercicio5", "despachos", des5, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: directores
		db.insertData("ejercicio5", "directores", dir1, conexion);
		db.insertData("ejercicio5", "directores", dir2, conexion);
		db.insertData("ejercicio5", "directores", dir3, conexion);
		db.insertData("ejercicio5", "directores", dir4, conexion);
		db.insertData("ejercicio5", "directores", dir5, conexion);

		// --2. READ DATA: CREATE DATA:Recogemos el resultado
		ResultSet rsDespachos = db.getValues("ejercicio5", "despachos", conexion);
		ResultSet rsDirectores = db.getValues("ejercicio5", "directores", conexion);

		// --Imprimir el resultado de las consultas de lectura de la db.
		try {
			utils.imprime("DESPACHOS");
			while (rsDespachos.next()) {
				System.out.println("Numero: " + rsDespachos.getInt("numero"));
				System.out.println("Capacidad: " + rsDespachos.getInt("capacidad"));
				System.out.println("----");
			}

			utils.imprime("DIRECTORES");
			while (rsDirectores.next()) {
				System.out.println("DNI: " + rsDirectores.getString("dni"));
				System.out.println("Nombre y Apellidos: " + rsDirectores.getString("nomapels"));
				System.out.println("DNI Jefe: " + rsDirectores.getString("dnijefe"));
				System.out.println("Despacho: " + rsDirectores.getInt("despacho"));
				System.out.println("----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// --Cerrar conexion
		db.closeConnection(conexion);
	}
}