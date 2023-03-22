import java.io.IOException;
 
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        Double primeiroNumero, segundoNumero, terceiroNumero;
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextDouble();
        segundoNumero = input.nextDouble();
        terceiroNumero = input.nextDouble();
        
        System.out.printf("MEDIA = %.1f\n", (primeiroNumero*2+segundoNumero*3+terceiroNumero*5)/10);
 
    }
 
}