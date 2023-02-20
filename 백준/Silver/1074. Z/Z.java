import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.print(div(N, r, c));
    }

    public static int div(int n, int r, int c) {
        if (n == 0)
            return 0;

        return 2 * (r % 2) + (c % 2) + 4 * div(n - 1, (int)r / 2, (int)c / 2);
    }
}