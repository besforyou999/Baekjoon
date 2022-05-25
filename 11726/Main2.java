import java.io.*;

public class Main {
    static int DIV = 10007;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            System.out.print(n);
            return;
        }

        int dp[] = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3 ; i <= n ; i++) dp[i] = ( ( dp[i-1] % DIV ) + ( dp[i-2] % DIV ) ) % DIV;

        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
    }
}
