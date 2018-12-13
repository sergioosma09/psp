public class EjemploHiloPrioridad1 {
	public static void main(String args[]) {
//Crea los hilos con el parámetro nombre
		HiloPrioridad1 h1 = new HiloPrioridad1("Hilo 1");
		HiloPrioridad1 h2 = new HiloPrioridad1("Hilo 2");
		HiloPrioridad1 h3 = new HiloPrioridad1("Hilo 3");
//Aigna las prioridades a los hilos
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);

//Inicia los hilos
		h1.start();
		h2.start();
		h3.start();

//El hilo principal espera el tiempo requerido
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
//Se detienen los hilos 
		h1.paraHilo();
		h2.paraHilo();
		h3.paraHilo();

//Mostramos el valor del contador de cada uno de los hilos
		System.out.println("h2 (Prioridad Máxima): " + h2.getcontador());
		System.out.println("h1 (Prioridad Normal): " + h1.getcontador());
		System.out.println("h3 (Prioridad Mínima): " + h3.getcontador());

	}
}