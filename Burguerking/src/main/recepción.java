package main;

import concurrencia.Bandeja;
import threads.Cocineros;
import threads.Comensales;



public class recepción {
	final static int N_cocineros=3; 
	final static int N_comensales=8; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bandeja b=new Bandeja();
		Cocineros [] esclavos= new Cocineros[N_cocineros];
		Comensales[] clientes= new Comensales[N_comensales];
		
		for (int cont=0;cont<N_comensales;cont++) {
			clientes[cont]= new Comensales(cont+1,b);
			clientes[cont].start();
		}
		
		
		for (int cont=0;cont<N_cocineros;cont++) {
			esclavos[cont]=new Cocineros(cont+1,b);
			esclavos[cont].start();
		}
		
	}

}
