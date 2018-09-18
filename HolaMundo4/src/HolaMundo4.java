import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HolaMundo4 {

	public static void main(String[] args) throws IOException {
		String nombre;
		Scanner tcl = new Scanner(System.in);
		System.out.println("Introduce un nombre: ");
		nombre=tcl.nextLine();
		tcl.close();
		
		System.out.println("Crear fichero ficheroHolaMundo.txt");
		String nomFichero="ficheroHolaMundo.txt";
		BufferedWriter br = new BufferedWriter(new FileWriter(nomFichero));
		
		for(int i=0;i<20;i++)
			System.out.println("Hola " + nombre);
	}

}
