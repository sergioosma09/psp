
public class LanazaHilos220 {

	public static void main(String[] args) {
		// Objeto compartido
		 Clase b = new Clase();

		 int n_alumnos = 10;
		 for (int i=0 ; i<n_alumnos; i++) { 
	
		 HiloAlumno alumno = new HiloAlumno(b);
		 alumno.setName("alumno-"+ i);
		 alumno.start();
		 }

		 HiloProfesor profesor = new HiloProfesor("Manolo Gómez", b);
		 profesor.start();
		 }
		} 

class Clase {
	boolean clase_comenzada;

	public Clase() {
		this.clase_comenzada = false;
	}

	// Hasta que el profesor no salude no empieza la clase,
	// por lo que los alumnos esperan con un wait
	public synchronized void saludarProfesor() {
		try {
			while (clase_comenzada == false) {
				wait();
			}
			System.out.println(Thread.currentThread().getName() + " Buenos dias, profesor.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Cuando el profesor saluda avisa a los alumnos con notifyAll de su llegada
	public synchronized void llegadaProfesor(String nombre) {
		System.out.println("Buenos dias a todos. Soy el profesor " + nombre);

		this.clase_comenzada = true;
		notifyAll();
	}
}

class HiloAlumno extends Thread {
	Clase saludo;

	public HiloAlumno(Clase bienvenida) {
		this.saludo = bienvenida;
	}

	public void run() {

		System.out.println("Alumno " + Thread.currentThread().getName() + " llega.");

		try {
			Thread.sleep(2000);
			saludo.saludarProfesor();
		} catch (InterruptedException e) {
			System.err.println("Thread alumno interrumpido!");
			System.exit(-1);
		}
	}
}

class HiloProfesor extends Thread {
	String nombre;
	Clase saludo;

	public HiloProfesor(String nombre, Clase bienvenida) {
		this.nombre = nombre;
		this.saludo = bienvenida;
	}

	public void run() {
		System.out.println(nombre + " llega.");

		try {
			Thread.sleep(1000);
			saludo.llegadaProfesor(nombre);
		} catch (InterruptedException e) {
			System.err.println("Thread profesor interrumpido!");
			System.exit(-1);
		}
	}
}