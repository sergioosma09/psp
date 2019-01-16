
public class HiloTac extends Thread {
	Reloj reloj;
	int n;

	public HiloTac(String nom, Reloj r, int n) {
		super(nom);
		this.reloj = r;
		this.n = n;
	}

	public void run() {
		int it=0;
		
		while(it<n) {
			reloj.tac();
			it++;
		}
	}
}
