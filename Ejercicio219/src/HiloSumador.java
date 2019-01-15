import java.util.concurrent.Semaphore;

public class HiloSumador extends Thread {
	private String nombre;
	private Contador contador;
	private static int num;
	private Semaphore sema;

	public HiloSumador(String nom, Contador cont, int n, Semaphore sem) {
		super(nom);
		this.nombre = nom;
		this.contador = cont;
		this.num = n;
		this.sema = sem;
	}

	public void run() {
		try {
			sema.acquire();
		} catch (Exception e) {
			System.out.println("Error");
		}
		for (int index = 0; index < num; index++) {
			
			

		
			contador.incrementa();
			
		}
			System.out.println("Al finalizar " + getName() + "el contador vale " + contador.valor());
			sema.release();
	

}
}

