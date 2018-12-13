
public class Contador {
	//Creamos las variables internas al hilo
		private static int n;

		public Contador(int n) {
			this.n=n;
		}
		public synchronized void incrementa() {
			n+=1;
		}
		public synchronized void decrementa() {
			n-=1;
		}
		public synchronized void mostrarValor() {
			System.out.println("El valor es de: " +  n);
		}
		public synchronized int valor() {
			return n;
		}
	
	
}
