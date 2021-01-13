package controllers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


/**
 * clase que obtiene y clasifica el html de la pagina web
 * @author alvar
 *
 */
public class ControllerHTML{
	
	private URLConnection conexion;
	private String url;
	
	public ControllerHTML(String url) {
		conexion=null;
		this.url=url;
	}
	
	
	/**
	 * comportamineto para obtener la conexion del html
	 */
	public void conectar() {
		try {
        	URL link = new URL(url);
            conexion = link.openConnection();
            conexion.setDoOutput(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * comportamineto para obtener una ArrayList con el html de la tabla
	 * @return
	 */
	public ArrayList<String> gettabla() {
		conectar();
		ArrayList<String> tabla=new ArrayList<String>();
		BufferedReader reader2 = null;
		try {
			reader2 = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea="";
			Boolean escribiendo=false;
			String prueba=reader2.readLine();
			while ((linea = reader2.readLine()) != null) {
				if (linea.contains("ctl00_Contenido_tblAcciones")) {
					escribiendo=true;
				}
				
				
				if (escribiendo==true) {
			    tabla.add(linea);
				}
				
				if (linea.contains("</table>")) {
					escribiendo=false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return tabla;
	}
	
	


}

