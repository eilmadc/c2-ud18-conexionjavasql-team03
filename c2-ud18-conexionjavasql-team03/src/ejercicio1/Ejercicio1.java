/*
 * C2-UD18-Team3(Roger, Arnau, Elena)
 */

package ejercicio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import utils.ColorConsole;
import utils.Utils;

/*--Ejercicio 1  LA TIENDA DE INFORMATICA
 * Tablas: fabricantes-articulos
 * */
public class Ejercicio1 {
	public void eje1Inicia() {

		// --------- Variables ------------
		Utils utils = new utils.Utils();
		ColorConsole cc = new utils.ColorConsole();
		Connection conexion = null;
		Database db = new Database();

		utils.mostrarPrograma("UD18-Ejercicio 1: LA TIENDA DE INFORMATICA");

		// --Abrir conexion--
		conexion = db.openConnection(conexion);

		// --Comprobar si existe y eliminamos db.
		db.dropDatabase("ejercicio1", conexion);
		// --Crears base de datos
		db.createDatabase("ejercicio1", conexion);

		// --Cadena que contiene los atributos de la tablas
		String atributosFabricante = "CODIGO int AUTO_INCREMENT PRIMARY KEY , NOMBRE nvarchar(100)";
		String atributosArticulos = "CODIGO int AUTO_INCREMENT  PRIMARY KEY , NOMBRE nvarchar(100), PRECIO nvarchar(100), FABRICANTE int NOT NULL,  KEY FABRICANTE (FABRICANTE), CONSTRAINT articulos_ibfk_1 FOREIGN KEY (FABRICANTE) REFERENCES fabricantes (CODIGO) ";

		// --datos
		String fabricante1 = ("1,'Sony'");
		String fabricante2 = ("2,'Creative Labs'");
		String fabricante3 = ("3,'Hewlett-Packard'");
		String fabricante4 = ("4,'Iomega'");
		String fabricante5 = ("5,'Fujitsu'");
		String articulo1 = ("1,'Hard drive',240,5");
		String articulo2 = ("2,'Memory',120,2");
		String articulo3 = ("3,'ZIP drive',150,4");
		String articulo4 = ("4,'Floppy disk',5,4");
		String articulo5 = ("5,'Monitor',240,1");

		// --Creacion tablas: fabricantes y articulos, con sus atributos
		db.createTable("ejercicio1", "fabricantes", atributosFabricante, conexion);
		db.createTable("ejercicio1", "articulos", atributosArticulos, conexion);
		// --1.CREATE DATA:insercion de datos en las tablas: fabricantes
		db.insertData("ejercicio1", "fabricantes", fabricante1, conexion);
		db.insertData("ejercicio1", "fabricantes", fabricante2, conexion);
		db.insertData("ejercicio1", "fabricantes", fabricante3, conexion);
		db.insertData("ejercicio1", "fabricantes", fabricante4, conexion);
		db.insertData("ejercicio1", "fabricantes", fabricante5, conexion);
		// --1.CREATE DATA:insercion de datos en las tablas: articulos
		db.insertData("ejercicio1", "articulos", articulo1, conexion);
		db.insertData("ejercicio1", "articulos", articulo2, conexion);
		db.insertData("ejercicio1", "articulos", articulo3, conexion);
		db.insertData("ejercicio1", "articulos", articulo4, conexion);
		db.insertData("ejercicio1", "articulos", articulo5, conexion);

		// --2. READ DATA: CREATE DATA:Recogemos el resultado
		ResultSet rsFabricantes = db.getValues("ejercicio1", "fabricantes", conexion);
		ResultSet rsArticulos = db.getValues("ejercicio1", "articulos", conexion);

		// --Imprimir el resultado de las consultas de lectura de la db.
		try {

			utils.imprime("FABRICANTES");
			while (rsFabricantes.next()) {
				System.out.println("Codigo: " + rsFabricantes.getInt("CODIGO"));
				System.out.println("Nombre: " + rsFabricantes.getString("NOMBRE"));
			}

			utils.imprime("ARTICULOS");
			while (rsArticulos.next()) {
				System.out.println("Codigo: " + rsArticulos.getInt("CODIGO"));
				System.out.println("Nombre: " + rsArticulos.getString("NOMBRE"));
				System.out.println("Precio: " + rsArticulos.getString("PRECIO"));
				System.out.println("Fabricante: " + rsArticulos.getString("FABRICANTE"));
			}
			utils.imprimeLinea();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// --Cerrar conexion
		db.closeConnection(conexion);
	}
}
