public class MainRun {

//Declaramos el contenedor,el array de productores y el de consumidores
	private static Contenedor contenedor;
	private static Thread[] productores;
	private static Thread[] consumidores;
	//variable para controlar la cantidad generada
	//de consumidores y productores que se desee
	public static final int CANTIDADCONSUMIDORES = 4;
	public static final int CANTIDADPRODUCTORES = 2;

	public static void main(String[] args) {
		//Instanciamos el contenedor
		contenedor = new Contenedor();
		//Instanciamos todos los productores

		for (int i = 0; i < CANTIDADPRODUCTORES; i++) {
			// Creamos el Hilo de un productor con su ID
			// Y asignandoles a todos el mismo contenedor
			productores[i] = new Thread(new Productor(contenedor, i));
			//Ya que las funciones van con synchronized, asignamos prioridades
			productores[i].setPriority(1+i);
			//Iniciamos el método run() de cada productor
			productores[i].start();
			System.out.println("Productor " + i + " activado");
			//Damos una pausa entre cada generacion de productor
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Creamos una pausa de 1 segundo entre la inicializacion
		//de productores y consumidores
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * De la misma manera instanciamos los consumidores
		 * */
		consumidores = new Thread[CANTIDADCONSUMIDORES];

		for (int i = 0; i < CANTIDADCONSUMIDORES; i++) {
			consumidores[i] = new Thread(new Consumidor(contenedor, i));
			consumidores[i].setPriority(10);
			consumidores[i].start();
			System.out.println("Consumidor " + i + " activado");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}