package Critico;

import java.util.ArrayList;

import model.Filosofo;
import model.Tenedor;

public class Mesa extends Thread{
	
	private String nombre;
	private ArrayList<Tenedor> tenedores;
	
	private int nummax;
	
	public Mesa(String nombre,int nummax) {
		this.nombre=nombre;
		tenedores=new ArrayList();
		//llenamos la array de tenedores y platos
		for (int cont=0;cont<nummax;cont++) {
			Tenedor t= new Tenedor();
			tenedores.add(t);
			}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public synchronized void sentarse(String nombre,int izquierda,int derecha) {
		if (tenedores.get(izquierda).getEstado()==true && tenedores.get(derecha).getEstado()==true) {
			System.out.println("El filosofo "+nombre+" no puede coger ningun tenedor");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (tenedores.get(izquierda).getEstado()==false) {
			tenedores.get(izquierda).coger();
			int numero=(int)Math.random()+1*1500;
			try {
				Thread.sleep((long)numero);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("El filososfo "+nombre+" come por "+numero+" tiempo con el tenedor "+izquierda);
			notify();
		} else if (tenedores.get(derecha).getEstado()==false) {
			tenedores.get(derecha).soltar();
			int numero=(int)Math.random()+1*1500;
			try {
				Thread.sleep((long)numero);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("El filososfo "+nombre+" come por "+numero+" tiempo con el tenedor "+derecha);
			notify();
			
		}
	} 
	
	

}
