import java.util.*;
import java.io.*;

class Main {
    public static Long max = Long.MAX_VALUE;
    public static long [] liq;
    public static int one = 0, two = 0, three = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        liq = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            liq[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liq);

        for (int i = 0 ; i < N - 2 ; i++) {
            solution(i);
        }

        System.out.print(liq[one] + " " + liq[two] + " " + liq[three]);
    }

    public static void solution(int idx) {
        int lp = idx + 1;
        int rp = liq.length - 1;

        while (lp < rp) {
            long sum = liq[idx] + liq[lp] + liq[rp];
            if (max > Math.abs(sum)) {
                max = Math.abs(sum);
                one = idx;
                two = lp;
                three = rp;
            }

            if (sum < 0) {
                lp += 1;
            } else if (sum > 0) {
                rp -= 1;
            } else {
                System.out.print(liq[idx] + " " + liq[lp] + " " + liq[rp]);
                System.exit(0);
            }
        }
    }
}

