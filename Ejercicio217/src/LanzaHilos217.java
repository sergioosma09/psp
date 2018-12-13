
public class LanzaHilos217 extends Thread{

	public static void main(String[] args) {
		Contador contador=new Contador(100);
		HiloSumador h1=new HiloSumador("Hilo 1 ", contador, 200);
		HiloRestador h3=new HiloRestador("Hilo 3 ", contador, 100);
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
