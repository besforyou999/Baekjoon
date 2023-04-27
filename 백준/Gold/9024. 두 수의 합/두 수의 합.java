import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0 ; t < T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int arr [] = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int lp = 0;
            int rp = n - 1;
            int cnt = 0;
            int minDist = 1000000000;
            while (lp < rp) {
                int sum = arr[lp] + arr[rp];
                int dist = K - sum;
                int diff = Math.abs(K - sum);

                // 근처 숫자 로직
                if (diff < minDist) {
                    cnt = 1;
                    minDist = diff;
                } else if (diff == minDist) {
                    cnt++;
                }

                if (dist > 0) { // sum이 더 작음
                    lp++;
                } else {
                    rp--;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}