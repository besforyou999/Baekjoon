import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int videos[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        videos = new int[N];

        st = new StringTokenizer(br.readLine());

        long l = 0;
        long r = 0;

        for (int i = 0 ; i < N ; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            r += videos[i];
            if (l < videos[i]) l = videos[i];
        }

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = 0, blueray_num = 0;

            for (int i = 0 ; i < N ; i++) {
                if (sum + videos[i] > mid) {
                    sum = 0;
                    blueray_num += 1;
                }
                sum += videos[i];
            }

            if (sum != 0) blueray_num += 1;

            if (blueray_num > M) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.print(l);
    }
}
