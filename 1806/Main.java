import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int [] Ai = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            int val = Integer.parseInt(st.nextToken());
            Ai[i] = Ai[i-1] + val;
        }
        int ans = Integer.MAX_VALUE;
        int lp = 0, rp = 1;
        int sum = Ai[1];
        while (rp <= N) {
            if (sum < S) {
                rp += 1;
            } else if (sum >= S) {
                int len = rp - lp;
                ans = Math.min(ans, len);
                lp += 1;
            }
            if (rp > N || lp > N) break;
            sum = Ai[rp] - Ai[lp];
        }
        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }

        System.out.println(ans);
    }
}

