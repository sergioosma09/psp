
class HiloEsperaNseg extends Thread {
	@Override
	public void run() {
		System.out.println("Soy el " + Thread.currentThread().getName() + " empezando.");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido.");
			return;
		}
		System.out.println(Thread.currentThread().getName() + " acabado.");
	}
}

public class LanzaHilos207 {
	public static void main(String args[]) {
		HiloEsperaNseg hilo1 = new HiloEsperaNseg();
		HiloEsperaNseg hilo2 = new HiloEsperaNseg();
		hilo1.setName("hilo 1");
		hilo2.setName("hilo 2");
		hilo1.start();
		hilo2.start();
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
		hilo1.interrupt();
	}
}