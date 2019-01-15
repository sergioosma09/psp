
public class LanzaHilos {
	public static void main(String [] args) {
		//Se crean los hilos HiloConParametros
		HiloConParametros hilo1 = new HiloConParametros("Adri", 7 );
		HiloConParametros hilo2 = new HiloConParametros("Sergio",  5 );
		HiloConParametros hilo3 = new HiloConParametros("Voro", 3 );
		
		System.out.println("Lanzando los hilos...");
		//Lanzamos los hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		System.out.println("Hilos finalizados");
	}
}
