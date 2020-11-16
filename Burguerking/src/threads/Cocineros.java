package threads;

import concurrencia.Bandeja;

public class Cocineros extends Thread{

	int id;
	Bandeja mibandeja;
	
	
	public Cocineros(int MIID,Bandeja b) {
		id=MIID;
		mibandeja=b;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) ((Math.random())*25));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mibandeja.cocinar(id);
		}
	}
	
}
