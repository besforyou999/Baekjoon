import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static final int DIV = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int DP [][] = new int[1001][1001];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 0 ; j <= i ; j++) {
                if (j == 0 || i == j) {
                    DP[i][j] = 1;
                } else {
                    DP[i][j] = (DP[i-1][j-1] + DP[i-1][j]) % DIV;
                }
            }
        }

        System.out.println(DP[N][K]);
    }
}