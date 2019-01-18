import javax.swing.plaf.SliderUI;

public class LanzaHilos_ProductorConsumidor {
	public static void main(String[] args) throws InterruptedException {
		Almacen almacen=new Almacen();
		Productor p1=new Productor(almacen,1);
		Consumidor c1=new Consumidor(almacen,1);
		p1.start();
		c1.start();
		//El join hará que el hilo principal tenga que esperar a que los hilos hijos terminen para poder terminar.
		p1.join();
		c1.join();
		System.out.println("***Fin de LanzaHilos***");

	}
}

class Almacen {
	private int numeroEnAlmacen;
	private boolean numeroAlmacenado = false;
	public synchronized void produce(int valor) {
		try{
			if (numeroAlmacenado) {
			wait();
			}
			}catch (Exception e) {
				
			}
		numeroEnAlmacen = valor;
		numeroAlmacenado = true;
		notifyAll();
		
	}

	public synchronized int consume() throws InterruptedException{
		try{
			if (!numeroAlmacenado) {
			wait();
			}
			}catch (Exception e) {
				
			}
		numeroAlmacenado = false;
		notifyAll();
		return numeroEnAlmacen;
		

	}

	
}


class Productor extends Thread {
	private Almacen almacen;
	private int id;
	private int iteraciones=4;
	

	public Productor(Almacen a, int n) {
		id=1;
		setName("Productor " + id);
		almacen = a;
		id = n;
		
	}

	public void run() {
		for (int i = 0; i < iteraciones; i++) {
			almacen.produce(i);
			System.out.println(getName() + " produce el valor " + i);

			try {
				sleep(500);
			} catch (InterruptedException e) {
			}

		}
	}
}

class Consumidor extends Thread {
	private Almacen almacen;
	private int id;
	private int iteraciones=5;
	
	public Consumidor(Almacen a, int n) {
		almacen = a;
		this.id = n;
	}
	
	public void run() {
		int valor=0;
		
		for (int i = 0; i < iteraciones; i++) {
			try {
				valor=almacen.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumidor " + id + " en iteraci�n "+ i+" consume el valor " + valor);

		}
	}
}



