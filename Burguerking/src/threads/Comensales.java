package threads;

import concurrencia.Bandeja;

public class Comensales extends Thread{

	int id;
	Bandeja mibandeja;
	
	
	public Comensales(int MIID,Bandeja b) {
		id=MIID;
		mibandeja=b;
	}
	
	
	
	public void run() {
		while (true) {
			mibandeja.consumir(id);
			try {
				Thread.sleep((long) ((Math.random()+1)*3));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
