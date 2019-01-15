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

public class LanzaHilos211 {
	public static void main(String args[]) {
		HiloEsperaNseg hilo1 = new HiloEsperaNseg(3);
		HiloEsperaNseg hilo2 = new HiloEsperaNseg(5);
		HiloEsperaNseg hilo3 = new HiloEsperaNseg(20);
		//Convierto el hilo3 en daemon
		hilo3.setDaemon(true);
		hilo1.setName("hilo 1");
		hilo2.setName("hilo 2");
		hilo3.setName("Hilo 3");
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
		System.out.println("Soy el hilo principal y he acabado.");
	}
}