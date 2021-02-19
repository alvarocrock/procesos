package controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import common.employee;
import common.product;
import common.sale;

public class comunication_controller_box {

	String Host;
	int Puerto;// puerto remoto
	Socket Cliente;
	DataOutputStream flujoSalida;
	DataInputStream flujoEntrada;
	ObjectInputStream input;

	public comunication_controller_box() {
		Host = "localhost";
		Puerto = 6000;
	}
	
	/**
	 * comportamiento que inicia todas las varialbles
	 */
	public void ini() {
		System.out.println("Starting ");
		try {
			Cliente = new Socket(Host, Puerto);
			// CREO FLUJO DE SALIDA AL SERVIDOR
			flujoSalida = new DataOutputStream(Cliente.getOutputStream());
			// CREO FLUJO DE ENTRADA AL SERVIDOR
			flujoEntrada = new DataInputStream(Cliente.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * comportamiento que envia un texto al servidor
	 * @param texto
	 */
	public void EnviarTexto(String texto) {
		// ENVIO Al servidor
		try {
			flujoSalida.writeUTF(texto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * comportamiento que devuelde un employee valido si existe
	 * @return
	 */
	public employee login() {
		
		employee _emplEmployee=null;
		try {
			if (input==null) {
			input= new ObjectInputStream(Cliente.getInputStream());
			}
			
			_emplEmployee = (employee) input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return _emplEmployee;
	}
	
	/**
	 * comportamiento que recibe y devuelve una lista de ventas
	 * @return
	 */
	public ArrayList<sale> getSales(){
		ArrayList<sale> sales= new ArrayList<sale>();
		try{
			if (input==null) {
				input= new ObjectInputStream(Cliente.getInputStream());
			}
			sales= (ArrayList<sale>) input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sales;
	}
	
	/**
	 * comportaiento que recibe array list de productos y los devuelve
	 * @return
	 */
	public ArrayList<product> getProducts(){
		ArrayList<product> products= new ArrayList<product>();
		try{
			if (input==null) {
				input= new ObjectInputStream(Cliente.getInputStream());
			}
			products= (ArrayList<product>) input.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	/**
	 * comportamiento que recibe texto del servidor
	 */
	public void RecibirTexto() {

		try {
			System.out.println("System: " + flujoEntrada.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * comportamiento que cierra todo
	 */
	public void Close() {
		try {
			if (flujoEntrada != null) {
				flujoEntrada.close();
			}
			if (flujoSalida != null) {
				flujoSalida.close();
			}
			if (Cliente != null) {
				Cliente.close();
			}
			if (input!=null) {
				input.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
