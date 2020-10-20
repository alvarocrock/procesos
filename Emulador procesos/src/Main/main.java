package Main;



import java.util.ArrayList;

import Algoritmos.FIFO;
import Algoritmos.RR;
import Algoritmos.SJF;
import Algoritmos.SRT;
import Elementos.Proceso;

public class main {

	public static void main(String[] args) {
		
		//EJECUTAR FIFO
		
		FIFO mififo= new FIFO(crearlista());
		//mififo.run();
		
		//ejercutar RR
		
		RR miRR=new RR(crearlista(),2);
		//miRR.run();
		
		SRT miSRT = new SRT(crearlista());
		//miSRT.run();
		
		SJF miSJF = new SJF(crearlista());
		miSJF.run();
	}
	
	public static ArrayList<Proceso> crearlista(){
		ArrayList<Proceso> lista=new ArrayList();
		Proceso A= new Proceso("A",0,5);
		Proceso B= new Proceso("B",1,2);
		Proceso C= new Proceso("C",2,3);
		Proceso D= new Proceso("D",3,2);
		Proceso E= new Proceso("E",10,1);
		
		lista.add(A);
		lista.add(B);
		lista.add(C);
		lista.add(D);
		lista.add(E);
		
		return lista;
	}

}
