
public class HiloSumador extends Thread {
	private String nombre;
	private Contador contador;
	private static int num;

	public HiloSumador(String nom, Contador cont, int n) {
		super(nom);
		this.nombre = nom;
		this.contador = cont;
		this.num = n;

	}

	public void run() {
		synchronized (contador) {

			for (int index = 0; index < num; index++) {
				contador.incrementa();

			}
			try {
				sleep(100);

			} catch (Exception e) {
				System.out.println("Error");
			}
			
		}
		System.out.println("Al finalizar " + getName() + "el contador vale " + contador.valor());
	}
}
