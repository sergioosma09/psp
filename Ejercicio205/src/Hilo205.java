import java.util.Scanner;

public class Hilo205 extends Thread{
	private int norden;
	public Hilo205(int norden) {
		this.norden=norden;
	}
	public void run(){
		System.out.println("Soy el hilo " + norden + ".");
		System.out.println("Finaliza el hilo" + norden);
		}
}
