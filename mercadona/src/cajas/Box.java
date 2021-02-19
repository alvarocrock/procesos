package cajas;

import java.util.ArrayList;
import java.util.Scanner;

import common.employee;
import common.product;
import common.sale;
import controllers.comunication_controller_box;

public class Box {
	private static comunication_controller_box box;
	private static employee _employee;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		box = new comunication_controller_box();
		
		box.ini();

		login();
		
		menu();
		box.Close();
		
	}
	
	/**
	 * metodo de login, solo saldra del bucle si el servidor devuelve un item no null
	 */
	public static void login() {
		_employee=null;
		while (_employee==null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("introduce tu usuario");
			String mensaje= sc.nextLine();
			box.EnviarTexto("login:"+mensaje);
			_employee=box.login();
			if (_employee==null) {
				System.out.println("login incorrecto inteentalo de nuevo");
			} else {
				System.out.println("enhorabuena login correcto");
			}
		} 
		
	}
	
	/**
	 * menu que se mostrará con la diferentes opciones
	 */
	public static void menu() {
		boolean fin=false;
		String opcion=null;
		System.out.println("Welcome employee "+_employee.getId());
		while (fin==false) {
			System.out.println("Choose an option");
			System.out.println("1. Charge purchase");
			System.out.println("2. Get box of the day");
			System.out.println("3. exit");
			Scanner sc = new Scanner(System.in);
			String st=sc.nextLine();
			if (st.equals("1")) {
				box.EnviarTexto("option1");
				chargePurchase();	
			} else if (st.equals("2")) {
				box.EnviarTexto("option2;"+_employee.getId());
				getsales();
			} else if (st.equals("3")) {
				box.EnviarTexto("End");
				//indicamos que hemos acabado
				fin=true;
				//cerramos conexiones
				box.Close();
			} else {
				System.out.println("Try it again");
			}
			
		}
	}
	
	/**
	 * comportamineto para obtener ventas
	 */
	public static void getsales() {
		System.out.println("Sales");
		System.out.println("");
		ArrayList<sale> sales = box.getSales();
		for (sale s: sales){
			System.out.print(s.toString());
		}
		System.out.println("");
	}
	
	
	/**
	 * comportamiento para cobrar compras
	 */
	public static void chargePurchase() {
		System.out.println("Products");
		System.out.println("");
		//obtener productos del servidor
		ArrayList<product> products=box.getProducts();
		for (product p: products) {
			System.out.println(p.getId()+" product "+p.getProducto()+" price "+p.getPrice()+"€");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a product");
		int opcion= sc.nextInt();
		System.out.println("How many?");
		int amount= sc.nextInt();
		product pr=searchProductById(opcion, products);
		box.EnviarTexto("cobro;"+pr.getId()+";"+amount+";"+_employee.getId());
		System.out.println("");
		
	}
	
	/**
	 * comportamiento para buscar un producto en una array list dando una lista y un id
	 * @param id
	 * @param list
	 * @return
	 */
	public static product searchProductById(int id,ArrayList<product> list) {
		Boolean encontrado=false;
		product pr = null;
		for (product p : list) {
			if (encontrado ==false && p.getId()==id) {
				pr=p;
				encontrado= true;
			}
		}
		
		return pr;
	}

}
