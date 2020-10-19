package Algoritmos;

import java.util.ArrayList;

import Elementos.Proceso;

public class SRT {
	
	ArrayList<Proceso> procesos;
	ArrayList<Proceso> procesos_e;
	int tiempo;
	

	public SRT(ArrayList<Proceso> misprocesos) {
		procesos=misprocesos;
		procesos_e=new ArrayList();
		tiempo=1;
	}
	
	
	public void run() {
		boolean fin=false;
		while (fin==false) {
			
			if (!procesos.isEmpty()) {
				AddLista();
			}
			
		for (int cont=0;cont<procesos_e.size();cont++) {
			while (procesos_e.get(cont).getDuracion()!=0) {
				procesos_e.get(cont).setDuracion(procesos_e.get(cont).getDuracion()-1);
				System.out.println("tiempo sitema:  "+ tiempo+"     "+procesos_e.get(cont).ToString());
				tiempo++;
			}
		}
		EliminarFinalizado();
		
		if (procesos.isEmpty() && procesos_e.isEmpty()) {
			fin=true;
			System.out.println("SRT finalizado");
		}
			
		}

		
	}
	
	private void AddLista() {
		Proceso menor;
		menor=GetMasCorto();
		procesos_e.add(menor);
		//System.out.println(menor.ToString());
		if (!procesos.isEmpty()) {
			for (int cont=0;cont<procesos.size();cont++) {
				if (procesos.get(cont).getNombre()==menor.getNombre()) {
					procesos.remove(cont);
				}
			}
		}
		
	}
	
	private void EliminarFinalizado() {
		for (int cont=0;cont<procesos_e.size();cont++) {
			if (procesos_e.get(cont).getDuracion()==0) {
				procesos_e.remove(cont);
			}
		}
	}
	
	
	public Proceso GetMasCorto() {
		int cont2;
		Proceso mascorto=null;
		Proceso proceso1=null;
		Proceso proceso2=null;
		for (int cont=0;cont<procesos.size();cont++) {
			cont2=cont+1;
			
			if (procesos.get(cont).getT_Entrada()+1<=tiempo) {
				proceso1=CrearProceso(cont);
			}
			if (cont2<procesos.size()) {
				if (procesos.get(cont2).getT_Entrada()+1<=tiempo) {
					proceso2=CrearProceso(cont2);
				}
			} else {
				
			}
			
			if (proceso1!=null && proceso2!=null) {
				if (mascorto==null) {
					//si no se ha encontrado el mas peque�o
					if (proceso1.getDuracion()<proceso2.getDuracion()) {
						//proceso 1 es menor
						mascorto=proceso1;
					} else {
						//proceso 2 es menor
						mascorto=proceso2;
					}
				} else {
					//si se ha enconreado el mas peque�o
					if (proceso1.getDuracion()<mascorto.getDuracion()) {
						//proceso 1 es menor
						mascorto=proceso1;
					} else {
						
					}
				}
			} else {
				mascorto=proceso1;
			}
		}
		return mascorto;
			
		
		
	}
	
public Proceso CrearProceso(int cont) {
		
		//necestito quitar el primero de la lista procesos_e y ponerlo al final
		String nombre=procesos.get(cont).getNombre();
		int entrada=procesos.get(cont).getT_Entrada();
		int duracion=procesos.get(cont).getDuracion();
		Proceso miproce= new Proceso(nombre,entrada,duracion);
		
		return miproce;
	
	}
}
