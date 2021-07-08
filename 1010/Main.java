import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int [][]dp = new int[30][30];
        for (int j = 0 ; j < 30 ; j++) {
            dp[j][j] = 1;
            dp[j][0] = 1;
        }
        for (int j = 2 ; j < 30; j++) {
            for (int k = 1 ; k < 30; k++) {
                dp[j][k] = dp[j-1][k-1] + dp[j-1][k];
            }
        }
        int N, M , T;
        T = sc.nextInt();
        for (int i = 0; i < T ; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            System.out.println(dp[M][N]);
        }
    }
}
