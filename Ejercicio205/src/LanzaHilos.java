import java.util.Scanner;

public class LanzaHilos {

	public static void main(String args[]) {
		Scanner tcl =new Scanner(System.in);
		System.out.println("Cuantos hilos quieres: ");
		int index=tcl.nextInt();
		Hilo205[] arraydeHilos;
		arraydeHilos=new Hilo205[index];
		//dentro del bucle creo los elementos del array pasando el contador del bucle al constructor de Hilo205
		for(int i=0;i<index;i++) {
			arraydeHilos[i]=new Hilo205(i+1);
			arraydeHilos[i].start();
		}
	}
}
