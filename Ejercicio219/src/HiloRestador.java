import java.util.concurrent.Semaphore;

public class HiloRestador extends Thread {
	private String nombre;
	private Contador contador;
	private static int num;
	private Semaphore sema;

	public HiloRestador(String nom, Contador cont, int n, Semaphore semaphore) {
		// TODO Auto-generated constructor stub
		super(nom);
		this.nombre = nom;
		this.contador = cont;
		this.num = n;
		this.sema = semaphore;
	}


	public void run() {
		try {
			sema.acquire();
			

		} catch (Exception e) {
			System.out.println("Error");
		}
		for (int index = 0; index < num; index++) {
			
			contador.decrementa();
			
		}
			System.out.println("Al finalizar " + getName() + "el contador vale " + contador.valor());
			sema.release();
	

}

	}


