/*
 * C2-UD18-Team3(Roger, Arnau, Elena)
 */

package ejercicio4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import utils.ColorConsole;
import utils.Utils;

/*--Ejercicio 4  PELICULAS Y SALAS
 * Tablas: salas-peliculas
 * */
public class Ejercicio4 {
	public void eje4Inicia() {

		// --------- Variables ------------
		Utils utils = new utils.Utils();
		ColorConsole cc = new utils.ColorConsole();
		Connection conexion = null;
		Database db = new Database();

		utils.mostrarPrograma("UD18-Ejercicio 4: PELICULAS Y SALAS");

		// --Abrir conexion--
		conexion = db.openConnection(conexion);

		// --Comprobar si existe y eliminamos db.
		db.dropDatabase("ejercicio4", conexion);
		// --Crears base de datos
		db.createDatabase("ejercicio4", conexion);

		// --Cadena que contiene los atributos de la tablas
		String atributosPeliculas = "CODIGO int NOT NULL, NOMBRE varchar(255) NOT NULL, CALIFICACIONEDAD varchar(255) DEFAULT NULL, PRIMARY KEY (CODIGO)";
		String atributosSalas = "CODIGO int NOT NULL, NOMBRE varchar(255) NOT NULL, PELICULA int DEFAULT NULL, PRIMARY KEY (CODIGO), KEY PELICULA (PELICULA), CONSTRAINT salas_ibfk_1 FOREIGN KEY (PELICULA) REFERENCES peliculas (CODIGO)";
		

		// --datos
		String sala1 = ("1,'Odeon',5");
		String sala2 = ("2,'Imperial',1");
		String sala3 = ("3,'Majestic',NULL");
		String sala4 = ("4,'Royale',3");
		String sala5 = ("5,'Paraiso',3");
		String pelicula1 = ("1,'Citizen Kane','PG'");
		String pelicula2 = ("2,'Singin in the Rain','G'");
		String pelicula3 = ("3,'The Wizard of Oz','G'");
		String pelicula4 = ("4,'The Quiet Man',NULL");
		String pelicula5 = ("5,'North by Northwest',NULL");

		// --Creacion tablas: fabricantes y articulos, con sus atributos
		db.createTable("ejercicio4", "peliculas", atributosPeliculas, conexion);
		db.createTable("ejercicio4", "salas", atributosSalas, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: articulos
		db.insertData("ejercicio4", "peliculas", pelicula1, conexion);
		db.insertData("ejercicio4", "peliculas", pelicula2, conexion);
		db.insertData("ejercicio4", "peliculas", pelicula3, conexion);
		db.insertData("ejercicio4", "peliculas", pelicula4, conexion);
		db.insertData("ejercicio4", "peliculas", pelicula5, conexion);
		// --1.CREATE DATA:insercion de datos en las tablas: fabricantes
		db.insertData("ejercicio4", "salas", sala1, conexion);
		db.insertData("ejercicio4", "salas", sala2, conexion);
		db.insertData("ejercicio4", "salas", sala3, conexion);
		db.insertData("ejercicio4", "salas", sala4, conexion);
		db.insertData("ejercicio4", "salas", sala5, conexion);
		
		// --2. READ DATA: CREATE DATA:Recogemos el resultado
		ResultSet rsPeliculas = db.getValues("ejercicio4", "peliculas", conexion);
		ResultSet rsSalas = db.getValues("ejercicio4", "salas", conexion);

		// --Imprimir el resultado de las consultas de lectura de la db.
		try {

			utils.imprime("PELICULAS");
			while (rsPeliculas.next()) {
				System.out.println("\nCodigo: " + rsPeliculas.getInt("CODIGO"));
				System.out.println("Nombre: " + rsPeliculas.getString("NOMBRE"));
				System.out.println("Calificacion Edad: " + rsPeliculas.getString("CALIFICACIONEDAD"));
			}

			utils.imprime("SALAS");
			while (rsSalas.next()) {
				System.out.println("\nCodigo: " + rsSalas.getInt("CODIGO"));
				System.out.println("Nombre: " + rsSalas.getString("NOMBRE"));
				System.out.println("Pelicula: " + rsSalas.getString("PELICULA"));
			}
			utils.imprimeLinea();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// --Cerrar conexion
		db.closeConnection(conexion);
	}
}