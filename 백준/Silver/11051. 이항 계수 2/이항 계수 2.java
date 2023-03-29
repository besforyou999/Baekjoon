import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int DIV = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int DP [][] = new int[1001][1001];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 0 ; j <= i ; j++) {
                if (j == 0 || i == j) {
                    DP[i][j] = 1;
                } else {
                    DP[i][j] = (DP[i-1][j] + DP[i-1][j-1]) % DIV;
                }
            }
        }

        System.out.print(DP[N][K]);
    }
}