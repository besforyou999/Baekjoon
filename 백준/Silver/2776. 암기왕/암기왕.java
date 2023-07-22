import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int [] one = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0 ; n < N ; n++) {
                one[n] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(one);

            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int m = 0 ; m < M ; m++) {
                if (found(one, Integer.parseInt(st.nextToken())))
                    sb.append(1);
                else
                    sb.append(0);

                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean found(int [] one, int target) {
        int lp = 0, rp = one.length - 1;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;

            if (target < one[mid]) {
                rp = mid - 1;
            } else if (one[mid] < target) {
                lp = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }


}