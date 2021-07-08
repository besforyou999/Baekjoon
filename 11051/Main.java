import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();

        int dp[][] = new int[1001][1001];

        for (int i = 1 ; i <= N ; i++) {
            for( int j = 0 ; j <= N ; j++) {
                if (i == j || j == 0) {
                    dp[i][j] = 1;
                }
                else
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
            }
        }
        System.out.print(dp[N][K]);
    }
}
