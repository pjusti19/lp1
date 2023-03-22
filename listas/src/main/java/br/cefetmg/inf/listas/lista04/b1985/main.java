import java.io.IOException;
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        int i, p, q;
        double c, t = 0;
        Scanner input = new Scanner(System.in);
        p = input.nextInt();
    for (i = 1; i <= p; i++)
    {
        c = input.nextDouble();
        q = input.nextInt();
        if (c == 1001)
            c = 1.5;
        else if (c == 1002)
            c = 2.5;
        else if (c == 1003)
            c = 3.5;
        else if (c == 1004)
            c = 4.5;
        else if (c == 1005)
            c = 5.5;
        t = t + c * q;
    }
    System.out.printf("%.2f\n", (double)t);
    }
 
}