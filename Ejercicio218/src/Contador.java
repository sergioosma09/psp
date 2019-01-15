
public class Contador {
	//Creamos las variables internas al hilo
		private static int n;

		public Contador(int n) {
			this.n=n;
		}
		public static void incrementa() {
			n+=1;
		}
		public static void decrementa() {
			n-=1;
		}
		public void mostrarValor() {
			System.out.println("El valor es de: " +  n);
		}
		public int valor() {
			return n;
		}
	
	
}
