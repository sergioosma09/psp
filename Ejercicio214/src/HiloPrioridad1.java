public class HiloPrioridad1 extends Thread {
//Creamos las variables internas al hilo
	private int c = 0;
	private boolean stopHilo = false;

//Definimos el construcotr de la clase Hiloprioridad1
	public HiloPrioridad1(String nombre) {
//Invocas al constructor de la clase superior
		super(nombre);
	}

//Creamos el metodo getContador que devolvera el valor de c
	public int getcontador() {
		return c;
	}

//Creamos el metodo paraHilo que parará el hilo
	public void paraHilo() {
		stopHilo = true;
	}

//El metodo que se ejecuta al activar el hilo
	public void run() {
		System.out.println("Inicio hilo " + this.getName());
//Imprime nombre y prioridad del hilo
		System.out.println("Prioridad hilo " + this.getName() + ": " + this.getPriority());
//Mientras no esté parado, esperará 2ms
		while (!stopHilo) {
			try {
				Thread.sleep(2);
			} catch (Exception e) {

			}
//Incrementa el contador
			c++;
		}
//Al salid del bucle indica que el hilo finaliza
		System.out.println("Fin hilo " + this.getName());
	}
}