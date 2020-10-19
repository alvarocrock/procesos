package Algoritmos;

import java.util.ArrayList;

import Elementos.Proceso;

public class FIFO {
	
	protected ArrayList<Proceso> procesos;
	
	
	public FIFO(ArrayList<Proceso> misprocesos) {
		procesos= misprocesos;
	}


	/**
	 * Proceso que ejecuta algoritmo fifo<br>
	 * 1º abre un bucle que no finaliza hasta que la lista esta vacia<br>
	 * 2º imprime por pantalla el nº de veces que se ejecuta los procesos en orden<br>
	 * 3º elimina los procesos que han acabado<br>
	 * 4º muestra un mensaje indiacando que el proceso ha terminado y no hay bucles infinitos<br>
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
						tiempo++;
					}
				}
			}
			//eliminar procesos que han finalizado
			if (!(procesos.isEmpty())) {
				for (int cont=0;cont<procesos.size();cont++) {
					if (procesos.get(cont).getDuracion()==0) {
						procesos.remove(cont);
					}
			}
		}
		}
		
		
		
		if (procesos.isEmpty()) {
			System.out.println("FIFO finalizado");
		}
	}
}

