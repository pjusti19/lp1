import java.io.IOException;
import java.util.Scanner;

public class main {
 
    public static void main(String[] args) throws IOException {
 
        int n, m, i, j, x = 0, y = 0;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
    int t[][]= new int[1000][1000];
    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)

            t[i][j] = input.nextInt();
    for (i = 1; i < n - 1; i++)
    {
        for (j = 1; j < m - 1; j++)
        {
            if (t[i][j] == 42)
                if (t[i - 1][j - 1] == 7 && t[i - 1][j] == 7 && t[i - 1][j + 1] == 7)
                    if (t[i][j - 1] == 7 && t[i][j + 1] == 7)
                        if (t[i + 1][j - 1] == 7 && t[i + 1][j] == 7 && t[i + 1][j + 1] == 7)
                        {
                            x = i + 1;
                            y = j + 1;
                        }
        }
    }

    System.out.printf("%d %d\n", x, y);
 
    }
 
}