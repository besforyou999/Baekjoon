import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dp[] = new int[13];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5 ; i < 13 ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }
}