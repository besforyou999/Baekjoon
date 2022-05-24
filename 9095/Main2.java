import java.io.*;

public class Main {
    static int MAX = 16;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int dp[] = new int[MAX];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5 ; i < MAX ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0 ; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
