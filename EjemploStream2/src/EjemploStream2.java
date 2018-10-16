import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.omg.CORBA.portable.InputStream;

public class EjemploStream2 {

	public static void main (String args[]) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("passwd");
		pb.directory(new File("/home/sersai/psp/HolaMundo1/bin"));
		Process process = pb.start() ;
		
		InputStream is = (InputStream) process.getInputStream() ;
		InputStream err = (InputStream) process.getErrorStream() ;
		
		InputStreamReader isr = new InputStreamReader(err);
		BufferedReader br = new BufferedReader(isr);
		
		InputStreamReader isr2 = new InputStreamReader(is);
		BufferedReader br2 = new BufferedReader(isr2);
		
		int cont;
		while ((cont = br.read()) != -1)
			System.out.print((char) cont);
		String line;
		System.out.println("Salida del proceso " + Arrays.toString(args) + " :" ) ;
		while((line=br2.readLine())!= null ) {
		System.out.println(line);
		}
		}
}