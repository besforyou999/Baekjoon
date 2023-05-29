import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        long [][] dp = new long[N][21];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        int plus, minus;

        for (int i = 1 ; i < N - 1 ; i++) {
            for (int j = 0 ; j <= 20 ; j++) {
                if (dp[i-1][j] != 0) {
                    plus = j + arr[i];
                    minus = j - arr[i];
                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i-1][j];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[N - 2][arr[N - 1]]);
    }
}