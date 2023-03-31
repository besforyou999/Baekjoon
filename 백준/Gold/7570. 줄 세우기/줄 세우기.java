import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] dp = new int[N + 1];
        int max = -1;

        for (int i = 1 ; i <= N ; i++) {
            int val = Integer.parseInt(st.nextToken());
            dp[val] = dp[val - 1] + 1;
            max = Math.max(max, dp[val]);
        }

        System.out.print(N - max);
    }
}