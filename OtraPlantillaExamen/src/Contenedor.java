public class Contenedor {

	private final int capacidad = 6000;
	private int contenido = 0;
	private boolean contenedorlleno = Boolean.FALSE;

	//Método para extraer contenido del contenedor
	public synchronized int get(int value) {
		while (!(contenido <= capacidad)) {
		// Mientras el contenedor esta vacio
			try {
				//Pausamos el hilo de ejecucion ya que no se puede extraer
				wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en get -> " + e.getMessage());
			}
		}
		// Cuando se haya reanudado el hilo (ya hay contenido)
		// Extraemos la cantidad pedida
		
		//Si hay menos cantidad que la pedida
		if (contenido < value) {
			// Obtenemos lo que queda
			value = contenido;
			// Y vaciamos el contenedor
			contenido = 0;
		} else {
			// Extraemos la cantidad solicitada
			contenido -= value;
		}
		//Mostramos por pantalla el estado del contenedor
		System.out.println("///////////////////// CONSUMIDOR /////////////////////////");
		System.out.println("CANTIDAD EN CONTENEDOR: " + contenido);
		contenedorlleno = Boolean.FALSE;
		//Despertamos el hilo pausado
		notify();
		
		return value;
	}

	//Método para colocar mas contenido en el contenedor
	public synchronized void put(int value) {
		//Si el contenedor esta lleno
		while (contenedorlleno) {
			try {
			//Pausamos el hilo hasta que haya hueco para colocar
				wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en put -> " + e.getMessage());
			}
		}
		//Cuando se haya reanudado el hilo (Ya no está lleno el contenedor)
		// Añadimos el contenido pasado por parametro

		if (contenido + value >= capacidad) {
			contenido = capacidad;
			contenedorlleno = Boolean.TRUE;
		} else {
			contenido += value;
		}
		System.out.println("***************** PRODUCTOR ********************");
		System.out.println("CANTIDAD EN CONTENEDOR: " + contenido);
		//Despertamos el hilo pausado
		notify();
	}
}