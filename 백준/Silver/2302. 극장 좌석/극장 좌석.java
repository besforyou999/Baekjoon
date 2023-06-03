import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int [] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3 ; i < 41 ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int ans = 1;
        int beforeSeat = 0;
        for (int m = 0 ; m < M ; m++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= dp[temp - beforeSeat - 1];
            beforeSeat = temp;
        }

        ans *= dp[N - beforeSeat];

        System.out.println(ans);

    }
}