import java.io.IOException;
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        int i = 1, x;
        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        while (i <= x)
        {
            if (i % 2 != 0)
                System.out.printf("%d\n", i);
            i++;
        }
 
    }
 
}