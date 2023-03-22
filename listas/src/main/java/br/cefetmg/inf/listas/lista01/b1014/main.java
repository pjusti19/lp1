import java.io.IOException;
 
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
       Double primeiroNumero, segundoNumero;
        
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextDouble();
        segundoNumero = input.nextDouble();
        
        
        System.out.printf("%.3f km/l\n", primeiroNumero/segundoNumero );
 
    }
 
}