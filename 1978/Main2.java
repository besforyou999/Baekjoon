import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp [] = new int[1001];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2 ; i < 1001 ; i++) {
            if (dp[i] == 0) {
                for (int j = i * i ; j < 1001 ; j += i) {
                    dp[j] = 1;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0 ; i < N ; i++) {
            int check = Integer.parseInt(st.nextToken());
            if (dp[check] == 0) ans += 1;
        }
        System.out.println(ans);
    }
}

