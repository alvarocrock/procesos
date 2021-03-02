package Thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import common.employee;
import common.product;
import common.sale;
import controllers.conntrollerBBDD;
import controllers.controlllerXML;
import controllers.mail_controller;

public class ServerThread extends Thread {

	private Socket cliente;
	private DataInputStream flujoEntrada;
	private DataOutputStream flujoSalida;
	private InputStream entrada;
	private OutputStream salida;
	private ObjectOutputStream out;
	private conntrollerBBDD bbdd; 
	private mail_controller mail;
	private String email;
	private controlllerXML xml;
	private Boolean fin;

	public ServerThread(Socket cliente) {
		this.cliente = cliente;
		bbdd = new conntrollerBBDD();
		mail= new mail_controller();
		xml= new controlllerXML();
		email= xml.getcorreo();
		fin=false;
	}

	@Override
	public void run() {
		while (fin==false) {
			CreateInputSream();
			String valor = recieve();
			if (valor.contains("login:")) {
				login(valor);
			} else if (valor.contains("option1")) {
				sendproducts();
			} else if (valor.contains("option2")) {
				String[] list= valor.split(";");
				sendsales(Integer.valueOf(list[1]));
			} else if (valor.contains("End")) {
				fin=true;
				close();


			}
		}
		

	}

	/**
	 * commportamiento para enviar ventas
	 * @param id
	 */
	private void sendsales(int id) {
		if (out==null) {
			createObjetOutputStream();
			}
		enviarventas(id);
	}

	/**
	 * comportamiento para enviar un employeee valido
	 * @param text
	 */
	private void login(String text) {
		if (out==null) {
			createObjetOutputStream();
			}
		enviarUsuario(text);
		//close();
	}
	
	/**
	 * comportamientoss para enviar los productos
	 */
	private void sendproducts() {
		if (out==null) {
		createObjetOutputStream();
		}
		enviarProductos();
		modificarBBDD();
	}

	/**
	 * comportaamiento para modificar la bbdd y añadir un campo a ventas
	 */
	private void modificarBBDD() {
		String[] list= recieve().split(";");
		String id_pr= list[1];
		String amount= list[2];
		String id_emple= list[3];
		if (bbdd.getStock(Integer.parseInt(id_pr))-Integer.parseInt(amount)>=0) {
			//modificar bbdd
			bbdd.updateStock(bbdd.getStock(Integer.parseInt(id_pr))-Integer.parseInt(amount), id_pr);
			bbdd.insertSales(id_pr, id_emple);
		} else {
			//enviar correo
			mail.enviarConGMail(email,"there's no "+ id_pr+" left" , "Ask for more of the product "+id_pr);
		}
	}
	
	/**
	 * metodo que recibe el flujo de datos
	 * 
	 * @return
	 */
	private String recieve() {
		String flujo = "";
		try {
			flujo = flujoEntrada.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flujo;
	}

	/**
	 * metodo que crea objet output stream
	 */
	private void createObjetOutputStream() {
		try {
			out = new ObjectOutputStream(cliente.getOutputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * comportamiennto que envia una lista de ventas
	 * @param id
	 */
	private void enviarventas(int id) {
		try {
			ArrayList<sale> sales;
			sales = bbdd.getSales(id);
			out.writeObject(sales);
			System.out.println("ventas enviados");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * comportamiento que envia una lista de productos
	 */
	private void enviarProductos() {
		try {
			ArrayList<product> products;
			products = bbdd.getProducts();
			out.writeObject(products);
			System.out.println("productos enviados");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void enviarUsuario(String id) {

		try {
			String[] List = id.split(":");
			employee _employee = bbdd.searchEmployee(Integer.parseInt(List[1]));
			out.writeObject(_employee);
			System.out.println("usuario enviado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * metodo que crea el flujo de entrada
	 * 
	 */
	private void CreateInputSream() {
		entrada = null;
		try {
			entrada = cliente.getInputStream();
			flujoEntrada = new DataInputStream(entrada);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * metodo que crea el flujo de salida
	 */
	private void CreateOutputStream() {
		try {
			salida = cliente.getOutputStream();
			flujoSalida = new DataOutputStream(salida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * metodo de cierra las conexiones si estan abiertas
	 */
	private void close() {
		try {
			if (entrada != null) {
				entrada.close();
			}
			if (flujoEntrada != null) {
				flujoEntrada.close();
			}
			if (salida != null) {
				salida.close();
			}
			if (flujoSalida != null) {
				flujoSalida.close();
			}
			if (cliente != null) {
				cliente.close();
			}
			if (out != null) {
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
