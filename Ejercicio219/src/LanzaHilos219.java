import java.util.concurrent.Semaphore;

public class LanzaHilos219 extends Thread{
	private static Semaphore semaphore = new Semaphore(1);
	public static void main(String[] args) {
		Contador contador=new Contador(100);
		HiloSumador h1=new HiloSumador("Hilo 1 ", contador, 100,semaphore);
		HiloRestador h3=new HiloRestador("Hilo 3 ", contador, 100,semaphore);
		contador.mostrarValor();
		h1.start();
		h3.start();
		try {
			h1.join();
			h3.join();
		}catch(InterruptedException e){
			
		}
		contador.mostrarValor();
		
		
	}

}
