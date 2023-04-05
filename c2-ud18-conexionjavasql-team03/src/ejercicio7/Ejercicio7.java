/*
 * C2-UD18-Team3(Roger, Arnau, Elena)
 */

package ejercicio7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import utils.ColorConsole;
import utils.Utils;

/*--Ejercicio 7  LOS CIENTIFICOS
 * Tablas: cientificos-proyecto-asignado_a
 * */
public class Ejercicio7 {
	public void eje7Inicia() {

		// --------- Variables ------------
		Utils utils = new utils.Utils();
		ColorConsole cc = new utils.ColorConsole();
		Connection conexion = null;
		Database db = new Database();

		utils.mostrarPrograma("UD18-Ejercicio 7: LOS CIENTIFICOS");

		// --Abrir conexion--
		conexion = db.openConnection(conexion);

		// --Comprobar si existe y eliminamos db.
		db.dropDatabase("ejercicio7", conexion);
		// --Crears base de datos
		db.createDatabase("ejercicio7", conexion);

		// --Cadena que contiene los atributos de la tablas
		String atributosCientificos = "DNI varchar(8) NOT NULL, NOMBREAPELLIDOS varchar(255) NOT NULL, PRIMARY KEY (DNI)";
		String atributosProyecto = "ID varchar(4) NOT NULL, NOMBRE varchar(255) NOT NULL, HORAS int,PRIMARY KEY (ID) ";	
		String atributosAsignado = "CIENTIFICO varchar(8) NULL,"
				+ "KEY (CIENTIFICO),"
				+ " PROYECTO varchar(4) NULL,"
				+ "KEY(PROYECTO),"
				+ "FOREIGN KEY (CIENTIFICO) REFERENCES cientificos(DNI) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (PROYECTO) REFERENCES proyecto(ID) ON DELETE CASCADE ON UPDATE CASCADE";
		
		// --datos
		String cientifico1 = ("'7777777A', 'Cientifico 1'");
		String cientifico2 = ("'2222222B', 'Cientifico 2'");
		String cientifico3 = ("'3333333C', 'Cientifico 3'");
		String cientifico4 = ("'4444444D', 'Cientifico 4'");
		String cientifico5 = ("'5555555E', 'Cientifico 5'");
		String proyecto1 = ("'P001','Proyecto 001', '3200'");
		String proyecto2 = ("'P002','Proyecto 002', '1500'");
		String proyecto3 = ("'P003','Proyecto 003', '2200'");
		String proyecto4 = ("'P004','Proyecto 004', '65200'");
		String proyecto5 = ("'P005','Proyecto 005', '1200'");
		String asignado1 = ("'7777777A','P001'");
		String asignado2 = ("'2222222B','P002'");
		String asignado3 = ("'3333333C','P003'");
		String asignado4 = ("'4444444D','P004'");
		String asignado5 = ("'5555555E','P005'");

		// --Creacion tablas: cientificos-proyecto-asignado_a, con sus atributos
		db.createTable("ejercicio7", "cientificos", atributosCientificos, conexion);
		db.createTable("ejercicio7", "proyecto", atributosProyecto, conexion);
	
		
		// --1.CREATE DATA:insercion de datos en las tablas: cientificos
		db.insertData("ejercicio7", "cientificos", cientifico1, conexion);
		db.insertData("ejercicio7", "cientificos", cientifico2, conexion);
		db.insertData("ejercicio7", "cientificos", cientifico3, conexion);
		db.insertData("ejercicio7", "cientificos", cientifico4, conexion);
		db.insertData("ejercicio7", "cientificos", cientifico5, conexion);
		// --1.CREATE DATA:insercion de datos en las tablas: proyecto
		db.insertData("ejercicio7", "proyecto", proyecto1, conexion);
		db.insertData("ejercicio7", "proyecto", proyecto2, conexion);
		db.insertData("ejercicio7", "proyecto", proyecto3, conexion);
		db.insertData("ejercicio7", "proyecto", proyecto4, conexion);
		db.insertData("ejercicio7", "proyecto", proyecto5, conexion);
		db.createTable("ejercicio7", "asignado_a", atributosAsignado, conexion);
		
		// --1.CREATE DATA:insercion de datos en las tablas: asignado
		db.insertData("ejercicio7", "asignado_a", asignado1, conexion);
		db.insertData("ejercicio7", "asignado_a", asignado2, conexion);
		db.insertData("ejercicio7", "asignado_a", asignado3, conexion);
		db.insertData("ejercicio7", "asignado_a", asignado4, conexion);
		db.insertData("ejercicio7", "asignado_a", asignado5, conexion);
		

		// --2. READ DATA: CREATE DATA:Recogemos el resultado
		ResultSet rsCientificos = db.getValues("ejercicio7", "cientificos", conexion);
		ResultSet rsProyecto = db.getValues("ejercicio7", "proyecto", conexion);
		ResultSet rsAsignado = db.getValues("ejercicio7", "asignado_a", conexion);

		// --Imprimir el resultado de las consultas de lectura de la db.
		try {

			utils.imprime("CIENTIFICOS");
			while (rsCientificos.next()) {
				System.out.println("\nCodigo: " + rsCientificos.getString("DNI"));
				System.out.println("Nombre: " + rsCientificos.getString("NOMBREAPELLIDOS"));
			}
			
			utils.imprime("PROYECTO");
			while (rsProyecto.next()) {
				System.out.println("\nCodigo: " + rsProyecto.getString("ID"));
				System.out.println("Nombre: " + rsProyecto.getString("NOMBRE"));
				System.out.println("Calificacion Edad: " + rsProyecto.getString("HORAS"));
			}

			utils.imprime("ASIGNADO_A");
			while (rsAsignado.next()) {
				System.out.println("\nCodigo: " + rsAsignado.getString("CIENTIFICO"));
				System.out.println("Nombre: " + rsAsignado.getString("PROYECTO"));
			}
			utils.imprimeLinea();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// --Cerrar conexion
		db.closeConnection(conexion);
	}
}