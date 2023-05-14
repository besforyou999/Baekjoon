import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] A, fdp, bdp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        fdp = new int[N + 1];
        bdp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i <= N ; i++) {
            fdp[i] = 1;
            for (int j = 1 ; j <= i ; j++) {
                if (A[i] > A[j] && fdp[i] < fdp[j] + 1) {
                    fdp[i] = fdp[j] + 1;
                }
            }
        }

        for (int i = N ; i >= 1 ; i--) {
            bdp[i] = 1;
            for (int j = N ; j >= i ; j--) {
                if (bdp[i] < bdp[j] + 1 && A[i] > A[j]) {
                    bdp[i] = bdp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1 ; i <= N ; i++) {
            int tmp = fdp[i] + bdp[i] - 1;
            max = Math.max(tmp, max);
        }
        System.out.println(max);
    }
}