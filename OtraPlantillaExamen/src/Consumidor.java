import java.util.Random;

public class Consumidor implements Runnable{
	private final Contenedor contenedor;
    private final int idconsumidor;
    private  Random aleatorio;
    /**
     * Constructor de la clase
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idconsumidor Identificador del consumidor
     */
    public Consumidor(Contenedor contenedor, int idconsumidor) 
    {
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
        aleatorio = new Random();
    }
 
    @Override
    /**
     * Implementación de la hebra
     */
    public synchronized void run() 
    {
        while(Boolean.TRUE)
        {
        	int coger = aleatorio.nextInt(100);
            System.out.println("El consumidor " + idconsumidor + " consume: " + contenedor.get(coger));
            
            try {
				Thread.sleep(5000 + coger*100);
			} catch (Exception e) {
				e.printStackTrace();
			}
           
        }
    }
}
