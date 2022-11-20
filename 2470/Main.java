import java.util.*;
import java.io.*;

class Main {
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int liq[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            liq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liq);

        int ans = Integer.MAX_VALUE;
        int lp = 0;
        int rp = N - 1;
        int left = 0, right = 0;

        while ( lp < rp ) {
            int min = liq[lp] + liq[rp];
            if (ans > Math.abs(min)) {
                ans = Math.abs(min);
                left = lp;
                right = rp;
            }

            if (min < 0) {
                lp += 1;
            } else if (min > 0) {
                rp -= 1;
            } else {
                System.out.print(liq[lp] + " " + liq[rp]);
                System.exit(0);
            }
        }

        System.out.print(liq[left] + " " + liq[right]);
    }
}

