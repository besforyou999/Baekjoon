import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int []arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 0 ; n < N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int minDiff = 2_000_000_100;
        int lp = 0 , rp = N - 1;
        int answer = arr[lp] + arr[rp];

        while (lp < rp) {
            int mix = arr[lp] + arr[rp];

            if (minDiff > Math.abs(mix)) {
                minDiff = Math.abs(mix);
                answer = mix;
            }

            if (mix < 0) {
                lp += 1;
            } else if (mix > 0) {
                rp -= 1;
            } else {
                System.out.println(0);
                return;
            }
        }

        System.out.println(answer);
    }
}