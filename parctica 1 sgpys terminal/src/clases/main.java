package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String route="/";
		ProcessBuilder ea = new ProcessBuilder("cmd.exe","/c","dir",route,"-l");
		Process p = ea.start();
		//BufferedReader bf= new BufferedReader();
		StringBuilder output = new StringBuilder();
		BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
		String linea=null;
		while ((linea = br.readLine()) != null)  {
			//linea= br.readLine();
			System.out.println(linea);
		}
		

	}
	
	public Boolean validar(String url) {
		Boolean resul=false;
		
		return resul;
		
	}

}
