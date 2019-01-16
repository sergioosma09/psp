
public class LanzaHilos221 {

	public static void main(String[] args) {
		Reloj rel = new Reloj();

		HiloTic hilotic = new HiloTic("HiloTic", rel, 6);
		HiloTac hilotac1 = new HiloTac("HiloTac", rel, 3);
		HiloTac hilotac2 = new HiloTac("HiloTac", rel, 4);
		
		hilotic.start();
		hilotac1.start();
		hilotac2.start();
	}
}
