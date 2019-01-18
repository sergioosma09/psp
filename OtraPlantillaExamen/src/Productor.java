import java.util.Random;

public class Productor implements Runnable{
	
	//Aleatorio
	private  Random aleatorio;
	//Donde colocaremos el contenido producido
    private final Contenedor contenedor;
    private final int idproductor;
    //Tiempo entre producciones en ms
    private final int TIEMPOESPERA = 10000;
 
    /**
     * Constructor de la clase
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idproductor Identificador del productor
     */
    public Productor(Contenedor contenedor, int idproductor) 
    {
        this.contenedor = contenedor;
        this.idproductor = idproductor;
        aleatorio = new Random();
    }
 
    @Override
    /**
     * Implementación de la hebra
     */
    public synchronized void  run() 
    {
    	//Buble sin fin
        while(Boolean.TRUE)
        {
        	//cantidad aleatoria a colocar
            int poner = aleatorio.nextInt(120*MainRun.CANTIDADCONSUMIDORES);
            //Colocamos llamando al metodo del contenedor
            contenedor.put(poner);
            System.out.println("El productor " + idproductor + " pone: " + poner);
            try
            {
            	//pausa entre producciones
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor " + idproductor + ": Error en run -> " + e.getMessage());
            }
        }
    }

}