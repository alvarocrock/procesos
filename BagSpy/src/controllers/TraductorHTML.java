package controllers;

import java.util.ArrayList;

import models.Dato;

public class TraductorHTML {
	
	public TraductorHTML() {
		
	}
	
	public ArrayList<Dato> getdatos(ArrayList<String> tabla){
		ArrayList<Dato> datos=new ArrayList<Dato>();
		String empresa="";
		String ultimo="";
		String diferencial="";
		String max="";
		String min="";
		String volumen="";
		String efectivo="";
		String fecha="";
		String hora="";
		
		for (String s: tabla) {
			if (s.contains("<td class=\"DifFlSb\" align=\"left\">")) {
				//obtener el nombre de la empresa de la linea
				String listemp[]= s.split("ISIN=");
				String listemp1[]= listemp[1].split(">");
				String listemp2[]= listemp1[1].split("<");
				empresa= listemp2[0];
				
				//obtener el ultimo
				String listgen[] =s.split("<td>");
				String listult[] =listgen[1].split("<");
				ultimo=listult[0];
				
				
				//obtener diferencial
				String listdif[]= s.split("<td class=\"DifClSb\">");
				String listdif2[]= listdif[1].split("<");
				diferencial=listdif2[0];
				
				//obtener maximo
				String listmax1[] = listgen[2].split("<");
				max=listmax1[0];
				
				//obtener el min
				String listmin[] = listgen[3].split("<");
				min=listmin[0];
				
				//obtener el volumen
				String listvol[] = listgen[4].split("<");
				volumen=listvol[0];
				
				//obtener efectivo
				String listefec[] = listgen[5].split("<");
				efectivo= listefec[0];
				
				//obtener fecha
				String listfecha[] = s.split("<td align=\"center\">");
				String listfecha2[]= listfecha[1].split("<");
				fecha=listfecha2[0];
				
				//obtener hora
				String listhora[] = s.split("<td class=\"Ult\" align=\"center\">");
				String listhora2[] = listhora[1].split("<");
				hora=listhora2[0];
				
				
				
				datos.add(new Dato(empresa, ultimo, diferencial, max, min, volumen, efectivo, fecha, hora));
				
			}
		}
		
		return datos;
	}

}
