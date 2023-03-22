import java.io.IOException;
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        int x=0, a = 0, g = 0, d = 0;
        Scanner input = new Scanner(System.in);

        while (x != 4)
        {
            x= input.nextInt();
            if (x == 1)
                a++;
            if (x == 2)
                g++;
            if (x == 3)
                d++;
        }
            System.out.printf("MUITO OBRIGADO\n");
            System.out.printf("Alcool: %d\n", a);
            System.out.printf("Gasolina: %d\n", g);
            System.out.printf("Diesel: %d\n", d);
 
        }
 
}