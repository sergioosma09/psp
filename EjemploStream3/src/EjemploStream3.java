import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;



public class EjemploStream3 {

	public static void main (String args[]) throws IOException {
		//Escribimos qué proceso queremos lanzar
		ProcessBuilder pb = new ProcessBuilder("passwd");
        Process process = pb.start() ;
        //Empieza el proceso, no lo lanzamos en un try catch 
        //porque gestionamos la Excepción en el main
        
       
        
      
        
        //Con getInputStream() obtenemos la salida estándar del proceso ejecutada
        //Con getErrorStream() obtenemos la posible salida de error del proceso ejecutada
        //y se la asignamos a un objeto InputStream
        //El cual vamos a poder leer creando un StreamReader
        InputStream is = process.getInputStream() ;
        InputStream err = process.getErrorStream() ;
        InputStreamReader isr = new InputStreamReader(err);
        BufferedReader br = new BufferedReader(isr);
        InputStreamReader isr2 = new InputStreamReader(is);
        BufferedReader br2 = new BufferedReader(isr2);
        
        
        //Conectamos un OutputStream a la entrada estándar del hijo para poder escribir en ella                     
        OutputStream os = process.getOutputStream();
       
        
        
        os.write("Sergio\n".getBytes());
        os.write("Sergio\n".getBytes());//Escribimos 3 contraseñas en el OutputStream
        os.write("Sergio\n".getBytes());//Con \n salta la linea
        //El método write() necesita que se le pase un array de caracteres
        //Con getBytes() lo convertimos en array
        //Con flush se vacía el búffer de entrada
        os.flush();
        
        
      
        int cont;
        while ((cont = br.read()) != -1)
            System.out.print((char) cont);
       
        String line;
        
        
        //Escribimos en la salida del proceso principal
        System.out.println("Linea de error");
        //Leemos las lineas de la salida estándar de error con el bufferedReader y las imprimimos.
        while((line=br2.readLine())!= null ) {
        System.out.println(line);//Muestra la salida del error
        }
        }
}
