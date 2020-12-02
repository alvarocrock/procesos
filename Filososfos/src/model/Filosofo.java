package model;

import Critico.Mesa;

public class Filosofo extends Thread{
	
	private	 String nombre;
	private Mesa mesa;
	private int izquierda;
	private int derecha;
	
	public Filosofo( String nombre,Mesa mesa,int izquierda,int derecha) {
		this.nombre=nombre;
		this.mesa=mesa;
		this.izquierda=izquierda;
		this.derecha=derecha;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void pensar() {
		int numero=(int)Math.random()+1*1500;
		try {
			Thread.sleep((long)numero);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El filososfo "+nombre+" piensa por "+numero+" tiempo");
	}
	
	public void comer() {
		mesa.sentarse(nombre, izquierda, derecha);
		
	}
	public void run() {
		while (true) {
			pensar();
			comer();
		}
		
	}

}
