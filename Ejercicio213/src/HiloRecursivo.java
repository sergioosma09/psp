public class HiloRecursivo extends Thread {

	public static int veces;

	public HiloRecursivo(int veces) {
		//Número de hilos que quedan por crear
		this.veces = veces;

	}

	public void run() {
		if (veces > 0) {
			this.setName("Hilo " + veces);
			System.out.println("Soy el " + getName() + ": y voy a llamar al hilo " + (veces - 1));
			HiloRecursivo hilo = new HiloRecursivo(veces - 1);
			hilo.start();
		} else if (veces == 0) {
			this.setName("Hilo " + veces);
			System.out.println("Soy el " + getName());
		}
	}
	public static void main(String[] args) {
	      HiloRecursivo hilo = new HiloRecursivo(10);
	      hilo.start();
	  }

}

//Constructor sin variables
//public class HiloRecursivo extends Thread{
//  
//  private static int veces; 
//  private static boolean flag = false;
//  private static int siguiente;
//  
//  public HiloRecursivo() {
//      if(!flag) {
//          this.veces = 10;
//          flag = true;
//      }else {
//          this.veces=siguiente;
//      }        
//  }
//  public void run() {
//      if(veces > 0) {
//          this.setName("Hilo " + veces);
//          this.siguiente = veces - 1;
//          System.out.println("Soy el " + getName() +": y voy a llamar al hilo " + siguiente);            
//          HiloRecursivo hilo = new HiloRecursivo();
//          hilo.start();
//      }else if(veces == 0) {
//          this.setName("Hilo " + veces);
//          System.out.println("Soy el " + getName());
//      }
//  }
//  
//}