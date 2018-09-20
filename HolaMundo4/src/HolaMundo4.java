import java.io.*;
import java.util.*;
public class HolaMundo4 {

	public static void main(String[] args) {
		String nombre;
		Scanner tcl = new Scanner(System.in);
		System.out.println("Introduce un nombre: ");
		nombre=tcl.nextLine();
		for(int i=0;i<20;i++) 
			System.out.println("Hola " + nombre);
		
		
		try {
		BufferedWriter br = new BufferedWriter(new FileWriter(new File("nomFichero.txt")));
		
		for(int i=0;i<20;i++) {
			br.write("Hola " + nombre);
			br.newLine();
			}
		br.close();
		
		}catch(Exception e) {
			System.out.println("Error");
		}

}
}
