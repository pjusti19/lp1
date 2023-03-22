import java.io.IOException;
 
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        int primeiroNumero, segundoNumero;
        double terceiroNumero;
        
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextInt();
        segundoNumero = input.nextInt();
        terceiroNumero = input.nextDouble();
        
        
        System.out.printf("NUMBER = %d\n", primeiroNumero);
        System.out.printf("SALARY = U$ %.2f\n", segundoNumero*terceiroNumero);
 
    }
 
}