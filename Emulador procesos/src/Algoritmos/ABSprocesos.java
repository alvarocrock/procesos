package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;

import Elementos.Proceso;

public abstract class ABSprocesos {

	protected ArrayList<Proceso> procesos;
	protected ArrayList<String> listaMedias;
	
	
	protected void mostrarmedias() {
		
		System.out.println();
		System.out.println("Medias de los procesos:");
		System.out.println();
		Collections.sort(listaMedias);
		for (int cont=0;cont<listaMedias.size();cont++) {
			System.out.println(listaMedias.get(cont).toString());
		}
		
		
	}
}
