import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int [] arr, dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 1 ; n < N + 1 ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            dp[n] = 1;
        }

        for (int i = 1 ; i < N + 1 ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = -1;

        for (int n = 1 ; n < N + 1 ; n++) {
             max = Math.max(max, dp[n]);
        }

        System.out.println(N - max);
    }
}