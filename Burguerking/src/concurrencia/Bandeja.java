package concurrencia;

public class Bandeja {

	int cant;
	int cant_total;
	int cant_ped;
	
	public Bandeja() {
		cant=0;
		cant_total=0;
		cant_ped=0;
	}
	
	
	
	public synchronized void consumir(int id) {
		if (cant>0) {
		cant--;
		cant_total++;
		System.out.println("el cliente "+id+" ha consumido una hamburquesa y quedan "+cant+" en la bandeja se han consumido "+cant_total);
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		} else {
		cant_ped++;
		System.out.println("el cliente "+id+" ha pedido una hamburquesa hay "+cant_ped+" pedidos" );
		notify();
		}
			
	}
	
		public synchronized void cocinar(int id) {
			
			if (cant_ped!=0) {
			cant_ped--;
			cant++;
			System.out.println("el cocinero "+id+" tiene lista una hamburquesa "+cant+" en la bandeja quedan "+cant_ped+" pedido por relizar");
			notify();
			} else {
			System.out.println("No hay pedidos de hamburguesas y se pone a esparar el cocinero "+id);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	
	}
}
