import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        n = cs.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        } else if (n == 2){
            System.out.println(2);
            return;
        }

        int dp [] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3 ; i <= n ; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}