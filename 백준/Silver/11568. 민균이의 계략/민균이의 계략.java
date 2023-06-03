import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N + 1];
        int [] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1 ; n <= N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            dp[n] = 1;
        }

        for (int i = 1 ; i < N + 1 ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = -1;

        for (int a : dp) {
            max = Math.max(max, a);
        }

        System.out.println(max);
    }
}