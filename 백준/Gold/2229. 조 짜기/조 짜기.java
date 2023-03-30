import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] s = new int[n + 1];
        int [] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i <= n ; i++) {
            int max = 0, min = 10001;
            for (int j = i ; j >= 1 ; j--) {
                max = Math.max(max, s[j]);
                min = Math.min(min, s[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }

        System.out.println(dp[n]);
    }
}