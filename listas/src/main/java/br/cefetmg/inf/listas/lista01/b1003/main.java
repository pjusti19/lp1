import java.io.IOException;
 
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        int primeiroNumero, segundoNumero, terceiroNumero;
        
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextInt();
        segundoNumero = input.nextInt();
        
        terceiroNumero = primeiroNumero + segundoNumero;
        
        System.out.printf("SOMA = %d\n", terceiroNumero);
    }
 
}