package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;

import Elementos.Proceso;
/**
 * work in progresss
 * @author alvar
 *
 */
public class RR {
	
	ArrayList<Proceso> procesos;
	ArrayList<Proceso> procesos_e;
	ArrayList<Proceso> procesos_d;
	
	int quantum;
	
	public RR(ArrayList<Proceso> lista, int miquantum) {
		procesos=lista;
		quantum=miquantum;
		procesos_e= new ArrayList();
		procesos_d= new ArrayList();
		
	}
	
	/**
	 * proceso que ejecuta algoritmo rr <br>
	 */
	public void run() {
		int tiempo=1;
		boolean primero=false;
		boolean fin=false;
		Proceso miproce=null;

		while (fin==false) {
			
			//añadir primer elemento a array procesos_e(ejecución)
			if (!(procesos.isEmpty())) {
				//procesos_e.clear();
				if (procesos.get(0).getT_Entrada()<=tiempo) {
					procesos_e.add(procesos.get(0));
					procesos.remove(0);
				}
			}
			
			
			if (miproce!=null) {
				//cosas nacis
				restaurar();
				procesos_d.clear();
			
			}	
			
			for (int cont=0;cont<procesos_e.size();cont++) {
				for (int contq=0;contq<quantum;contq++) {
					try {
						if (procesos_e.size()==0) {
							break;
						}
						if (procesos_e.get(cont).getDuracion()==0 ) {
						
						procesos_e.remove(cont);
						procesos_d.add(miproce);
						eliminarfinalizado();
					} else {
						procesos_e.get(cont).setDuracion(procesos_e.get(cont).getDuracion()-1);
						System.out.println("tiempo sitema:  "+ tiempo+"     "+procesos_e.get(cont).ToString());
						tiempo++;
						if (contq==1) {
							miproce=CrearProceso(cont);
							procesos_e.remove(cont);
							procesos_d.add(miproce);
							eliminarfinalizado();
						}
					}
					//procesos_d.add(miproce);
			            
			        } catch (ArrayIndexOutOfBoundsException e) {
			        	System.out.println("RR Q="+quantum+" finalizado");
			        }
					
			} //fin primer for
			
			
			//trabajar con listas
			
			}
			
			if (procesos_d.isEmpty() && procesos_e.isEmpty()) {
				
				fin=true;
				System.out.println("RR Q="+quantum+" finalizado");
				}
			
		}
			
				
			
	
		
		
		
	}
	
	
	
	public void HacerCopia() {
		for(int cont=0;cont<procesos_e.size();cont++) {
			procesos_d.add(procesos_e.get(cont));
		}
	}
	
	public void restaurar() {
		for(int cont=0;cont<procesos_d.size();cont++) {
			procesos_e.add(procesos_d.get(cont));
		}
	}
	
	/**
	 * cargar elemento en la array de hechos
	 */
	public Proceso CrearProceso(int cont) {
		
		//necestito quitar el primero de la lista procesos_e y ponerlo al final
		String nombre=procesos_e.get(cont).getNombre();
		int entrada=procesos_e.get(cont).getT_Entrada();
		int duracion=procesos_e.get(cont).getDuracion();
		Proceso miproce= new Proceso(nombre,entrada,duracion);
		
		return miproce;
		
		
			
		
	}
		
	public void eliminarfinalizado() {
		try {
			if (!(procesos_d.isEmpty())) {
				for (int cont=0;cont<procesos_d.size();cont++) {
					if (procesos_d.get(cont).getDuracion()==0) {
						procesos_d.remove(cont);
					}
				}
			}
        } catch (ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace();
            System.out.println("RR Q="+quantum+" finalizado");
        }

	}
}
