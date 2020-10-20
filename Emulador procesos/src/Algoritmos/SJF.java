package Algoritmos;

import java.util.ArrayList;

import Elementos.Proceso;

public class SJF extends ABSprocesos{
	
	ArrayList<Proceso> procesos_e;
	int tiempo;
	

	public SJF(ArrayList<Proceso> misprocesos) {
		procesos=misprocesos;
		listaMedias= new ArrayList();
		procesos_e=new ArrayList();
		tiempo=1;
	}
	
	public void run() {
		boolean fin=false;
		boolean cambio=false;
		Proceso maspequeño=null;
		while (fin==false) {
			//cargamos el primero mas corto
			addmaspequealista();
			cambio=false;
			for (int cont=0;cont<procesos_e.size();cont++) {
				while (cambio==false) {
					
				if (procesos_e.get(cont).getDuracion()!=0) {
				maspequeño=GetMasCorto();
				if (maspequeño!=null) {
					if (procesos_e.get(cont).getDuracion()<=maspequeño.getDuracion()) {
							procesos_e.get(cont).setDuracion(procesos_e.get(cont).getDuracion()-1);
							System.out.println("tiempo sitema:  "+ tiempo+"     "+procesos_e.get(cont).ToString());
							tiempo++;
						} else {
							procesos.add(procesos_e.get(cont));
							procesos_e.remove(procesos_e.get(cont));
							cambio=true;
							//addmaspequealista();
							
						}
					} else {
						procesos_e.get(cont).setDuracion(procesos_e.get(cont).getDuracion()-1);
						System.out.println("tiempo sitema:  "+ tiempo+"     "+procesos_e.get(cont).ToString());
						tiempo++;
					}
					
					if (!procesos_e.isEmpty()) {
						if (procesos_e.get(cont).getDuracion()==0) {
							cambio=true;
						}
					}
				
					EliminarFinalizado();
					
				}
				}
			
			
			
		if (procesos.isEmpty() && procesos_e.isEmpty()) {
			fin=true;
			System.out.println("SJF finalizado");
		}
			
		}
	}

		
	}
	
	private void addmaspequealista() {
		if(!procesos.isEmpty()) {
			AddLista();
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
					//si no se ha encontrado el mas pequeño
					if (proceso1.getDuracion()<proceso2.getDuracion()) {
						//proceso 1 es menor
						mascorto=proceso1;
					} else {
						//proceso 2 es menor
						mascorto=proceso2;
					}
				} else {
					//si se ha enconreado el mas pequeño
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
