
public class LanzaHilos {
	public static void main(String[]args) {
		HiloEspera h1=new HiloEspera();
		System.out.println("Soy LanzaHilos y voy a lanzar HiloEspera");
		h1.start();
	}
}
