/*
 * C3 - UD18 - TEAM 3 (Arnaud, Roger, Elena)
 */

package main;

import ejercicio1.Ejercicio1;
import ejercicio2.Ejercicio2;
import ejercicio3.Ejercicio3;
import ejercicio4.Ejercicio4;
import ejercicio5.Ejercicio5;
import ejercicio6.Ejercicio6;
import ejercicio7.Ejercicio7;
import ejercicio8.Ejercicio8;
import ejercicio9.Ejercicio9;
import utils.ColorConsole;
import utils.Utils;

public class mainApp {

	// --------- Variables ------------
		public static Utils utils = new utils.Utils();
		public ColorConsole cc = new utils.ColorConsole();
	

	public static void main(String[] args) {

		/*
		 * Database db = new Database(); Connection conexion =
		 * db.openConnection();db.openConnection();
		 * 
		 * db.closeConnection(conexion);
		 */
	// Muestra el menu mediante pantalla y dialog
	utils.mostrarPrograma("UNIDAD 18 : CONEXION JAVA_SQL");

	imprimeMenuPrincipal();
	}

	// Imprimir Menu
	static public void imprimeMenuPrincipal() {

		String mensaje = " Opcion 1: EJERCICIO 1" + "\n Opcion 2: EJERCICIO 2" + "\n Opcion 3: EJERCICIO 3"
				+ "\n Opcion 4: EJERCICIO 4" + "\n Opcion 5: EJERCICIO 5" + "\n Opcion 6: EJERCICIO 6" + "\n Opcion 7: EJERCICIO 7"
				+ "\n Opcion 8: EJERCICIO 8" + "\n Opcion 9: EJERCICIO 9";

		int opcion;

		// Pide mensaje hasta que se introduzca una opcion correcta.(Entre 1 y 3)
		do {

			// Pide numero de opcion de MENU mediante dialog
			opcion = utils.pideInt(mensaje, "UD10");

		} while (opcion > 9);

		verificaOpcionPrincipal(opcion);

	}

	// Verifica Opcion del menu
	/**
	 * @param opcion
	 */
	static public void verificaOpcionPrincipal(int opcion) {

		String respuesta = "si";
		do {

			switch (opcion) {
			case 1:
				// Ejercicio1
				Ejercicio1 ejercicio1 = new Ejercicio1();
				ejercicio1.eje1Inicia();
				break;
			case 2:
				// Ejercicio2
				Ejercicio2 ejercicio2 = new Ejercicio2();
				ejercicio2.eje2Inicia();
				break;
			case 3:
				// Ejercicio3
				Ejercicio3 ejercicio3 = new Ejercicio3();
				ejercicio3.eje3Inicia();

				break;
			case 4:
				// Ejercicio4
				Ejercicio4 ejercicio4 = new Ejercicio4();
				ejercicio4.eje4Inicia();
				break;
			case 5:
				// Ejercicio4
				Ejercicio5 ejercicio5 = new Ejercicio5();
				ejercicio5.eje5Inicia();
				break;
			case 6:
				// Ejercicio1
				Ejercicio6 ejercicio6 = new Ejercicio6();
				ejercicio6.eje6Inicia();
				break;
			case 7:
				// Ejercicio1
				Ejercicio7 ejercicio7 = new Ejercicio7();
				ejercicio7.eje7Inicia();
				break;
			case 8:
				// Ejercicio1
				Ejercicio8 ejercicio8 = new Ejercicio8();
				ejercicio8.eje8Inicia();
				break;
			case 9:
				// Ejercicio1
				Ejercicio9 ejercicio9 = new Ejercicio9();
				ejercicio9.eje9Inicia();
				break;
			default:
				break;
			}

			if (respuesta.equals("si")) {
				imprimeMenuPrincipal();
			}

			respuesta = utils.pideString("¿Deseas continuar?(si,no);", "MENU PRINCIPAL UD18");
		} while (respuesta == "si");

	}
}


