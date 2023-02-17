import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long [] Sums = new long[N + 1];
        long [] cnts = new long[M];
        st = new StringTokenizer(br.readLine());

        long ans = 0;

        for (int i = 1 ; i <= N ; i++) {
            Sums[i] = Sums[i-1] + Long.parseLong(st.nextToken());
            long mod = Sums[i] % M;
            if (mod == 0) ans += 1;
            cnts[(int)mod]++;
        }

        for (int i = 0 ; i < M ; i++) {
            if (cnts[i] > 0)
                ans += pickOut2Num(cnts[i]);
        }

        System.out.println(ans);
    }

    static long pickOut2Num(long n) {
        return n * (n - 1) / 2;
    }
}