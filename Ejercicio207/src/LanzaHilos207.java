class HiloEsperaNseg extends Thread {
	private int espera;
	
	public HiloEsperaNseg(int espera) {
		this.espera=espera*1000;
	}
	
	@Override
	public void run() {
		System.out.println("Soy el " + getName() + " empezando.");
		try {
			sleep(espera);
		} catch (InterruptedException e) {
			System.out.println(getName() + " interrumpido.");
			return;
		}
		System.out.println(getName() + " acabado.");
	}
}

public class LanzaHilos207 {
	public static void main(String args[]) {
		HiloEsperaNseg hilo1 = new HiloEsperaNseg(3);
		HiloEsperaNseg hilo2 = new HiloEsperaNseg(5);
		hilo1.setName("hilo 1");
		hilo2.setName("hilo 2");
		hilo1.start();
		hilo2.start();
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
		System.out.println("Soy el hilo principal y he acabado.");
	}
}