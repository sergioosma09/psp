
public class HiloRestador extends Thread{
	private String nombre;
	private Contador contador;
	private static int num;
	public HiloRestador(String nom,Contador cont,int n) {
		this.nombre=nom;
		setName(nombre);
		this.contador=cont;
		this.num=n;
		}
		
	public void run() {
		for(int index=0;index<num;index++) {
			contador.decrementa();
			
		}
		try {
			sleep(100);
			
		}catch(Exception e) {
			System.out.println("Error");
		}
		System.out.println("Al finalizar " + getName() + "el contador vale " + contador.valor());
	}
}