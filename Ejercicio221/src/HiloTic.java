
public class HiloTic extends Thread {
	Reloj reloj;
	int n;

	public HiloTic(String nom, Reloj r, int n) {
		super(nom);
		this.reloj = r;
		this.n = n;
	}

	public void run() {
		int it=0;
		while(it<n) {
			reloj.tic();
		}
	}

}
