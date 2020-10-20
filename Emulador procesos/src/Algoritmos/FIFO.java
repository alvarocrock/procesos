package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;

import Elementos.ABSproceso;
import Elementos.Proceso;

public class FIFO extends ABSprocesos{
	
	
	
	
	
	public FIFO(ArrayList<Proceso> misprocesos) {
		procesos= misprocesos;
		listaMedias= new ArrayList();
	}


	/**
	 * Proceso que ejecuta algoritmo fifo<br>
	 * 1� abre un bucle que no finaliza hasta que la lista esta vacia<br>
	 * 2� imprime por pantalla el n� de veces que se ejecuta los procesos en orden<br>
	 * 3� elimina los procesos que han acabado<br>
	 * 4� muestra un mensaje indiacando que el proceso ha terminado y no hay bucles infinitos<br>
	 */
	public void run() {
		int tiempo=1;
		while (!(procesos.isEmpty())) {
			for (int contglobal=0;contglobal<procesos.size();contglobal++){
				Proceso miproce = procesos.get(contglobal);
				
				if (miproce.getT_Entrada()+1<=tiempo) {
					//bucle que recorre la array desde el pirncipio hasta el final
					while (miproce.getDuracion()!=0) {
						miproce.setDuracion(miproce.getDuracion()-1);
						System.out.println("tiempo sitema:  "+ tiempo+"     "+miproce.ToString());
						
						if (miproce.getDuracion()==0) {
							 miproce.setT_final(tiempo);
							 
						}
						
						tiempo++;
					}
				}
			}
			//eliminar procesos que han finalizado
			if (!(procesos.isEmpty())) {
				String media;
				for (int cont=0;cont<procesos.size();cont++) {
					if (procesos.get(cont).getDuracion()==0) {
						media=procesos.get(cont).calcmedia();
						listaMedias.add(media);
						procesos.remove(cont);
					}
					
			}
		}
		}
	
		if (procesos.isEmpty()) {
			System.out.println("FIFO finalizado");
			mostrarmedias();
			
		}
	}
	
	
	
	
}

