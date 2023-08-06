import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int sum [] = new int[N + 1];

        sum[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i < N + 1 ; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int ans = 2 * N, lp = 0, rp = 1;

        long buff = sum[1];

        while (rp <= N) {
            if (buff < S) {
                rp++;
            } else if (buff >= S) {
                int len = rp - lp;
                ans = Math.min(ans, len);
                lp++;
            }
            if (rp > N || lp > N) break;
            buff = sum[rp] - sum[lp];
        }

        if (ans == 2 * N)
            ans = 0;

        System.out.println(ans);
    }
}