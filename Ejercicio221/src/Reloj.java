
public class Reloj {
	boolean tocaImprimirTac;

	public Reloj() {
		this.tocaImprimirTac = false;
	}

	public synchronized void tic() {
		try {
			while (tocaImprimirTac) {
				wait();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("TIC");
		tocaImprimirTac = true;
		notifyAll();
	}

	public synchronized void tac() {

		try {
			while (!tocaImprimirTac) {
				wait();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("TAC");
		tocaImprimirTac = false;
		notifyAll();
	}

}
