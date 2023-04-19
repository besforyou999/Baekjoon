import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // N 심사대, M 명의 사람
    static int Ti[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Ti = new int[N];

        long lp = 0L, rp = 0, min = Long.MAX_VALUE, mid = 0;
        for (int i = 0 ; i < N ; i++) {
            Ti[i] = Integer.parseInt(br.readLine());
            min = Math.min(Ti[i], min);
        }

        rp = min * M;
        while (lp < rp) {
            mid = (lp + rp) / 2;
            long cnt = 0;
            for (int i = 0 ; i < N ; i++) {
                cnt += (mid / Ti[i]);
            }

            if (cnt >= M) { // 시간 과다
                rp = mid;
            } else { // 시간 부족
                lp = mid + 1;
            }
        }

        System.out.println(lp);
    }
}