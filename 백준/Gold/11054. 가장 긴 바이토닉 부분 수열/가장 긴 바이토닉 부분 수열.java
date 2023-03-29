import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int Ai[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Ai = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        int fdp [] = new int[N + 1];
        int bdp [] = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            fdp[i] = 1;
            for (int j = 1 ; j <= i ; j++) {
                if (fdp[i] < fdp[j] + 1 && Ai[j] < Ai[i]) {
                    fdp[i] = fdp[j] + 1;
                }
            }
        }

        for (int i = N ; i >= 1 ; i--) {
            bdp[i] = 1;
            for (int j = N ; j >= i ; j--) {
                if (bdp[i] < bdp[j] + 1 && Ai[j] < Ai[i]) {
                    bdp[i] = bdp[j] + 1;
                }
            }
        }

        int ans = 0;

        for (int i = 1 ; i <= N ; i++) {
            int tmp =  fdp[i] + bdp[i] - 1;
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}