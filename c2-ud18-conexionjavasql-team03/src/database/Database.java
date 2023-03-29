package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class Database {

	public Connection openConnection() {
		Connection conexion = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.43:3306", "remote", "-Crocodile123");
			System.out.println("Conectado a la base de datos");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(123321);
			e.printStackTrace();
		}

		return conexion;
	}

	public void createDatabase(String nom, Connection conexion) {

		try {
			String Query = "CREATE DATABASE " + nom;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			// closeConnection(conexion);
			// openConnection();
			// openConnection("root", "", nom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error abriendo la conexion");
		}
	}

	public void closeConnection(Connection conexion) {
		// TODO Auto-generated method stub
		try {
			conexion.close();
			System.out.println("Cerrada la conexion");
		} catch (SQLException e) {
			System.out.println("Error cerrando la conexion");
		}
	}

	public void createTable(String db, String table, String atributos, Connection conexion) {
		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// CREATE TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("CREATE TABLE " + table + "(" + atributos + ");");
			System.out.println("Table creada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando la table");
		}
	}

	public void insertData(String db, String table, String atributos, Connection conexion) {
		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// CREATE TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("INSERT INTO " + table + " VALUE(" + atributos + ");");
			System.out.println("data insertada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error insertando data");
		}
	}

	public java.sql.ResultSet getValues(String db, String table, Connection conexion) {
		java.sql.ResultSet resultSet = null;
		try {
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			String querySelect = "SELECT *FROM " + table;
			Statement stsel = conexion.createStatement();

			stsel.executeUpdate(querySelect);
			resultSet = stsel.executeQuery(querySelect);

		} catch (SQLException e) {
			System.out.println("Values no coleccionadas correctamente");
		}
		return resultSet;
	}

	public void deleteDatabase(String db, String table, String ID, Connection conexion) {
		try {

			String query = "DELETE FROM " + table + " WHERE ID = \"" + ID + "\"";
			Statement delTable = conexion.createStatement();
			delTable.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("Values not deleted correctly");
		}
	}

	public void dropDatabase(String db, Connection conexion) {
		try {
			String queryDB = "DROP DATABASE IF EXISTS " + db;
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);
		} catch (SQLException ex) {
			System.out.println("Drop incomplete");
		}
	}
}
