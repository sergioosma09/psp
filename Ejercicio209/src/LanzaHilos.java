
public class LanzaHilos {
	public static void main(String args[]) {
		
		HiloConParametros HiloEsperahilo1 = new HiloConParametros("Hilo1",3);
		HiloConParametros HiloEsperahilo2 = new HiloConParametros("Hilo2", 5);
		HiloConParametros HiloEsperahilo3 = new HiloConParametros("Hilo3", 5);
		
	
		HiloEsperahilo1.start();
		HiloEsperahilo2.start();
		HiloEsperahilo3.start();
		try {
			System.out.println("Soy el hilo principal y voy a esperar a que esperen los hilos");
			HiloEsperahilo1.join();//el hilo padre espera al hijo
			HiloEsperahilo2.join();
			HiloEsperahilo3.join();
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
		System.out.println("Soy el hilo principal y he terminado");
		//HiloEsperahilo1.interrupt();
	}
}
