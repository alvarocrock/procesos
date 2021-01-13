package controllers;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import models.Dato;

public class ControllerFichero {
	
	public ControllerFichero() {
		
	}
	
	public void guardar(ArrayList<Dato> datos) {
		//crearlistas();
		//persi.guardarseries(series);
		//persi.guardarcaps(caps);
		
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        java.util.Date fecha= new Date();
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(fecha);
	        String date=calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"_"+fecha.getHours()+"-"+fecha.getMinutes();
	        String file="registro/resultado_"+date+".txt";
	        try
	        {
	            fichero = new FileWriter(file);
	            pw = new PrintWriter(fichero);

	            //for (int i = 0; i < 10; i++)
	              //  pw.println("Linea " + i);
	            pw.println("datos a fecha "+date+"\n");
	            pw.println("nombre | ultimo | diferencial | maximo | minimo | volumen | efectivo | fecha | hora"+"\n"+"\n");
	            
	            for (Dato d: datos) {
	            	pw.println(d.toString());
	            	}

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	        
	        System.out.println("fichero "+file+" escrito" );
	}

}
