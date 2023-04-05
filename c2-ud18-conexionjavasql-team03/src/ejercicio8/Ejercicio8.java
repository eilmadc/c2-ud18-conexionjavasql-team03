/*
 * C2-UD18-Team3(Roger, Arnau, Elena)
 */

package ejercicio8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import utils.ColorConsole;
import utils.Utils;

public class Ejercicio8 {
	public void eje8Inicia() {

		// --------- Variables ------------
		Utils utils = new utils.Utils();
		ColorConsole cc = new utils.ColorConsole();
		Connection conexion = null;
		Database db = new Database();

		utils.mostrarPrograma("UD18-Ejercicio 5: LOS GRANDES ALMACENES");

		// --Abrir conexion--
		conexion = db.openConnection(conexion);

		// --Comprobar si existe y eliminamos db.
		db.dropDatabase("ejercicio8", conexion);
		// --Crears base de datos
		db.createDatabase("ejercicio8", conexion);

		// --Cadena que contiene los atributos de la tablas
		String atributosCajeros = "codigo int PRIMARY KEY AUTO_INCREMENT, nomapels nvarchar(255)";
		String atributosMaquinas = "codigo int PRIMARY KEY AUTO_INCREMENT, piso int";
		String atributosProductos = "codigo int PRIMARY KEY AUTO_INCREMENT, nombre nvarchar(100), precio int";
		String atributosVenta = "cajero int, maquina int, producto int, PRIMARY KEY(cajero, maquina, producto)";

		// --datos
		String c1 = "1, 'Javier Martinez Soler'";
		String c2 = "2, 'Emp Leado Delmes'";
		String c3 = "3, 'Celia Herrera Flores'";
		String c4 = "4, 'Yolanda Saez Montero'";
		String c5 = "5, 'Sergio Mora Martin'";
		String m1 = "1, 4";
		String m2 = "2, 1 ";
		String m3 = "3, 3 ";
		String m4 = "4, 1 ";
		String m5 = "5, 5 ";
		String p1 = "1, 'PS5', 540";
		String p2 = "2, 'Cafetera', 127";
		String p3 = "3, 'Freidora', 80";
		String p4 = "4, 'Cargador mobil', 25";
		String p5 = "5, 'Auriculares Bluetooth', 43";
		String v1 = "1, 5, 1";
		String v2 = "2, 4, 4";
		String v3 = "3, 1, 2";
		String v4 = "1, 5, 5";
		String v5 = "5, 2, 3";

		// --Creacion tablas: departamentos y empleados, con sus atributos
		db.createTable("ejercicio8", "cajeros", atributosCajeros, conexion);
		db.createTable("ejercicio8", "maquinas", atributosMaquinas, conexion);
		db.createTable("ejercicio8", "productos", atributosProductos, conexion);
		db.createTable("ejercicio8", "ventas", atributosVenta, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: cajeros
		db.insertData("ejercicio8", "cajeros", c1, conexion);
		db.insertData("ejercicio8", "cajeros", c2, conexion);
		db.insertData("ejercicio8", "cajeros", c3, conexion);
		db.insertData("ejercicio8", "cajeros", c4, conexion);
		db.insertData("ejercicio8", "cajeros", c5, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: maquinas
		db.insertData("ejercicio8", "maquinas", m1, conexion);
		db.insertData("ejercicio8", "maquinas", m2, conexion);
		db.insertData("ejercicio8", "maquinas", m3, conexion);
		db.insertData("ejercicio8", "maquinas", m4, conexion);
		db.insertData("ejercicio8", "maquinas", m5, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: productos
		db.insertData("ejercicio8", "productos", p1, conexion);
		db.insertData("ejercicio8", "productos", p2, conexion);
		db.insertData("ejercicio8", "productos", p3, conexion);
		db.insertData("ejercicio8", "productos", p4, conexion);
		db.insertData("ejercicio8", "productos", p5, conexion);
		
		// --1.CREATE DATA:insercion de datos en las tablas: ventas
		db.insertData("ejercicio8", "ventas", v1, conexion);
		db.insertData("ejercicio8", "ventas", v2, conexion);
		db.insertData("ejercicio8", "ventas", v3, conexion);
		db.insertData("ejercicio8", "ventas", v4, conexion);
		db.insertData("ejercicio8", "ventas", v5, conexion);

		// --2. READ DATA: CREATE DATA:Recogemos el resultado
		ResultSet rsCajeros = db.getValues("ejercicio8", "cajeros", conexion);
		ResultSet rsMaquinas = db.getValues("ejercicio8", "maquinas", conexion);
		ResultSet rsProductos = db.getValues("ejercicio8", "productos", conexion);
		ResultSet rsVentas = db.getValues("ejercicio8", "ventas", conexion);

		// --Imprimir el resultado de las consultas de lectura de la db.
		try {
			utils.imprime("CAJEROS");
			while (rsCajeros.next()) {
				System.out.println("Codigo: " + rsCajeros.getInt("codigo"));
				System.out.println("Nombre y Apellidos: " + rsCajeros.getString("nomapels"));
				System.out.println("----");
			}

			utils.imprime("MAQUINAS");
			while (rsMaquinas.next()) {
				System.out.println("Codigo: " + rsMaquinas.getInt("codigo"));
				System.out.println("Piso: " + rsMaquinas.getInt("piso"));
				System.out.println("----");
			}
			
			utils.imprime("PRODUCTOS");
			while (rsProductos.next()) {
				System.out.println("Codigo: " + rsProductos.getInt("codigo"));
				System.out.println("Nombre: " + rsProductos.getString("nombre"));
				System.out.println("Precio: " + rsProductos.getInt("precio"));
				System.out.println("----");
			}
			
			utils.imprime("VENTAS");
			while (rsVentas.next()) {
				System.out.println("Codigo Cajero: " + rsVentas.getInt("cajero"));
				System.out.println("Codigo Maquina Registradora: " + rsVentas.getInt("maquina"));
				System.out.println("Codigo Producto: " + rsVentas.getInt("producto"));
				System.out.println("----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// --Cerrar conexion
		db.closeConnection(conexion);
	}
}