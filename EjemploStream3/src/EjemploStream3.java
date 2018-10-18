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
        
       
        
        InputStream is = process.getInputStream() ;
        InputStream err = process.getErrorStream() ;
        
        
        //Captura la salida del proceso
        InputStreamReader isr = new InputStreamReader(err);
        BufferedReader br = new BufferedReader(isr);
        InputStreamReader isr2 = new InputStreamReader(is);
        BufferedReader br2 = new BufferedReader(isr2);
        
        
        //Conectamos un OutputStream a la entrada estándar del hijo para poder escribir en ella
        OutputStream os = process.getOutputStream();
       
        
        
        os.write("Sergio\n".getBytes());
        os.write("Sergio\n".getBytes());//Contraseñas erroneas
        os.write("Sergio\n".getBytes());
        os.flush();
        
        
      
        int cont;
        while ((cont = br.read()) != -1)
            System.out.print((char) cont);
        String line;
       
        
        
        System.out.println("Salida del proceso " + Arrays.toString(args) + " :" ) ;
        while((line=br2.readLine())!= null ) {
        System.out.println(line);//Muestra la salida del error
        }
        }
}
