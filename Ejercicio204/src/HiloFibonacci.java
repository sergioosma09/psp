import java.util.Scanner;

public class HiloFibonacci extends Thread{
public int veces;
    
    public HiloFibonacci(String nombre, int veces) {
        this.setName(nombre);
        this.veces = veces;
    }

    public void run() {
        int n1 = 0;
        int n2 = 1;
        int aux;
        int cont = 0;
        System.out.println(n1);
        System.out.println(n2);
        while (cont <= veces) {
            aux = n1;
            n1 = n2;
            n2 = aux + n1;
            cont++;
            
            System.out.println(n2);
        }
    }
}
