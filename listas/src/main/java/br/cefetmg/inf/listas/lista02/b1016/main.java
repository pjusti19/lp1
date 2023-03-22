import java.io.IOException;
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        int x;
        Scanner input = new Scanner(System.in);
        x = input.nextInt();

        System.out.printf("%d minutos\n", x*2);
 
    }
 
}