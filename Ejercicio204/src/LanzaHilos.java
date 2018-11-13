import java.util.Scanner;

public class LanzaHilos {
	    public static void main(String[] args) {
	        Scanner tcl = new Scanner(System.in);

	        System.out.print("Cuántos números quieres: ");
	        int veces = tcl.nextInt();
	        tcl.close();

	        HiloFibonacci hilo1 = new HiloFibonacci("Fibonacci", veces);

	        hilo1.start();
	    }
	}
