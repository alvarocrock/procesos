package launcher;

import java.util.ArrayList;

import controllers.ControllerFichero;
import controllers.ControllerHTML;
import controllers.TraductorHTML;
import models.Dato;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {
		TraductorHTML tradu= new TraductorHTML();
		ControllerFichero file = new ControllerFichero();
		ControllerHTML html= new ControllerHTML("https://www.bolsamadrid.es/esp/aspx/Mercados/Precios.aspx?indice=ESI100000000");
		ArrayList<String> lista=html.gettabla();
		ArrayList<Dato> datos= tradu.getdatos(lista);
		file.guardar(datos);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
