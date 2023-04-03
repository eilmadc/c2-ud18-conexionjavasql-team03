/*
 * C2-UD18-Team3(Roger, Arnau, Elena)
 */

package ejercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import utils.ColorConsole;
import utils.Utils;

public class Ejercicio2 {
	public void eje2Inicia() {

		// --------- Variables ------------
		Utils utils = new utils.Utils();
		ColorConsole cc = new utils.ColorConsole();
		Connection conexion = null;
		Database db = new Database();

		utils.mostrarPrograma("UD18-Ejercicio 2: EMPLEADOS");

		// --Abrir conexion--
		conexion = db.openConnection(conexion);

		// --Comprobar si existe y eliminamos db.
		db.dropDatabase("ejercicio2", conexion);
		// --Crears base de datos
		db.createDatabase("ejercicio2", conexion);

		// --Cadena que contiene los atributos de la tablas
		String atributosDepartamentos = "codigo int PRIMARY KEY AUTO_INCREMENT, nombre varchar(100), presupuesto int";
		String atributosEmpleados = "dni varchar(8) PRIMARY KEY, nombre varchar(100), apellidos varchar(255), departamento int";

		// --datos
		String dep1 = "101, 'Recursos Humanos', 65000";
		String dep2 = "102, 'Finanzas', 73000";
		String dep3 = "103, 'Marketing', 142000";
		String dep4 = "104, 'Logistica', 80000";
		String dep5 = "105, 'IT', 125000";
		String emp1 = "85769384, 'Javier', 'Martinez Soler', 105 ";
		String emp2 = "57438693, 'Emp', 'Leado Delmes', 101 ";
		String emp3 = "17482954, 'Celia', 'Herrera Flores', 103 ";
		String emp4 = "98047281, 'Yolanda', 'Saez Montero', 104 ";
		String emp5 = "90836455, 'Sergio', 'Mora Martin', 105 ";

		// --Creacion tablas: departamentos y empleados, con sus atributos
		db.createTable("ejercicio2", "departamentos", atributosDepartamentos, conexion);
		db.createTable("ejercicio2", "empleados", atributosEmpleados, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: departamentos
		db.insertData("ejercicio2", "departamentos", dep1, conexion);
		db.insertData("ejercicio2", "departamentos", dep2, conexion);
		db.insertData("ejercicio2", "departamentos", dep3, conexion);
		db.insertData("ejercicio2", "departamentos", dep4, conexion);
		db.insertData("ejercicio2", "departamentos", dep5, conexion);

		// --1.CREATE DATA:insercion de datos en las tablas: empleados
		db.insertData("ejercicio2", "empleados", emp1, conexion);
		db.insertData("ejercicio2", "empleados", emp2, conexion);
		db.insertData("ejercicio2", "empleados", emp3, conexion);
		db.insertData("ejercicio2", "empleados", emp4, conexion);
		db.insertData("ejercicio2", "empleados", emp5, conexion);

		// --2. READ DATA: CREATE DATA:Recogemos el resultado
		ResultSet rsDepartamentos = db.getValues("ejercicio2", "departamentos", conexion);
		ResultSet rsEmpleados = db.getValues("ejercicio2", "empleados", conexion);

		// --Imprimir el resultado de las consultas de lectura de la db.
		try {
			utils.imprime("DEPARTAMENTOS");
			while (rsDepartamentos.next()) {
				System.out.println("Codigo: " + rsDepartamentos.getInt("codigo"));
				System.out.println("Nombre: " + rsDepartamentos.getString("nombre"));
				System.out.println("Presupuesto: " + rsDepartamentos.getInt("presupuesto"));
				System.out.println("----");
			}

			utils.imprime("EMPLEADOS");
			while (rsEmpleados.next()) {
				System.out.println("DNI: " + rsEmpleados.getString("dni"));
				System.out.println("Nombre: " + rsEmpleados.getString("nombre"));
				System.out.println("Apellidos: " + rsEmpleados.getString("apellidos"));
				System.out.println("Departamento: " + rsEmpleados.getInt("departamento"));
				System.out.println("----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// --Cerrar conexion
		db.closeConnection(conexion);
	}
}