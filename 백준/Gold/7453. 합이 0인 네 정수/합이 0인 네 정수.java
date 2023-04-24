import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int A[], B[], C[], D[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int S1 [] = new int[n * n];
        int S2 [] = new int[n * n];
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                S1[count] = A[i] + B[j];
                S2[count++] = C[i] + D[j];
            }
        }

        Arrays.sort(S1);
        Arrays.sort(S2);

        long cnt = 0;

        int lp = 0;
        int rp = S2.length - 1;

        while (lp < n * n && 0 <= rp) {
            int sum = S1[lp] + S2[rp];
            int lpSame = 1;
            int rpSame = 1;

            if (sum == 0) {
                while (lp <= n * n - 2 && S1[lp] == S1[lp + 1]) {
                    lpSame++;
                    lp++;
                }
                while (0 < rp && S2[rp] == S2[rp - 1]) {
                    rpSame++;
                    rp--;
                }
                cnt += (long) lpSame * rpSame;
            }

            if (sum < 0) {
                lp++;
            } else
                rp--;
        }

        System.out.println(cnt);
    }
}