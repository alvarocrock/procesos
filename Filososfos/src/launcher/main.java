package launcher;

import java.util.ArrayList;

import Critico.Mesa;
import model.Filosofo;
import model.Tenedor;

public class main {

	private final static int cantidad=5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Filosofo> filosofos=new ArrayList();
		
		
		Mesa mesa=new Mesa("redonda",5);
		
		//ya tengo array list de filosofos
		Filosofo uno= new Filosofo("Aristedor",mesa,0,4);
		Filosofo dos= new Filosofo("Platon",mesa,0,1);
		Filosofo tres= new Filosofo("Sir. Tenedor",mesa,1,2);
		Filosofo cuatro= new Filosofo("El vegano",mesa,2,3);
		Filosofo cinco= new Filosofo("Sin cuchillo",mesa,3,4);
		
		filosofos.add(uno);
		filosofos.add(dos);
		filosofos.add(tres);
		filosofos.add(cuatro);
		filosofos.add(cinco);
		
		//lanzamos el proceso
		for (int cont=0;cont<filosofos.size();cont++) {
			try {
				filosofos.get(cont).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			filosofos.get(cont).start();
			
		}
		
		
		
		
		
		
		
	}

}
