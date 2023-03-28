import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, MAX = 302;
    static int stairs[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[MAX];
        int dp[] = new int[MAX];
        for (int i = 1 ; i <= N ; i++) stairs[i] = Integer.parseInt(br.readLine());
        
        dp[1] = stairs[1];
        dp[2] = dp[1] + stairs[2];

        if (N <= 2) {
            System.out.println(dp[N]);
            return;
        }

        for (int i = 3 ; i <= N ; i++) {
            int one = dp[i-3] + stairs[i-1] + stairs[i];
            int two = dp[i-2] + stairs[i];
            dp[i] = Math.max(one, two);
        }

        System.out.println(dp[N]);
    }
}