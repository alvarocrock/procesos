package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class comandos {
	
	
	// estado
	
	
	//comportamientos
	
	
	
	
	//contructor
	public comandos() {
		
	}
	
	//resto
	public void lanzarcomando() {
		String route="/";
		ProcessBuilder ea = new ProcessBuilder("cmd.exe","/c","dir",route,"-l");
		Process p;
		try {
			p = ea.start();
			StringBuilder output = new StringBuilder();
			BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea=null;
			while ((linea = br.readLine()) != null)  {
				//linea= br.readLine();
				System.out.println(linea);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//BufferedReader bf= new BufferedReader();

		}
	
	public Boolean validar(String url) {
		Boolean resul=false;
		
		return resul;
		
	}

}
