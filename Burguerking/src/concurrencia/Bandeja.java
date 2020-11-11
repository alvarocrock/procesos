package concurrencia;

public class Bandeja {

	int cant;
	int cant_total;
	
	public Bandeja() {
		cant=0;
		cant_total=0;
	}
	
	
	
	public synchronized void consumir(int id) {
		if (cant>0) {
		cant--;
		cant_total++;
		System.out.println("el cliente "+id+" ha consumido una hamburquesa y quedan "+cant+" en la bandeja se han consumido "+cant_total);
		} else {
		System.out.println("el cliente "+id+" ha pedido una hamburquesa se han consumido "+cant_total);
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public synchronized void cocinar(int id) {
		cant++;
		if (cant<2) {
		System.out.println("el cocinero "+id+" tiene lista una hamburquesa "+cant+" en la bandeja");
		} else {
		System.out.println("el cocinero "+id+" ha preparado otra y rebosa con "+cant+" hamburquedas");	
		}
		notify();
	}
	
}
