import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int [] arr, diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        diff = new int[N - 1];

        st = new StringTokenizer(br.readLine());

        for (int n = 0 ; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        for (int n = 0 ; n < N - 1 ; n++) {
            diff[n] = arr[n + 1] - arr[n];
        }

        Arrays.sort(diff);

        int select = N - K;
        int sum = 0;

        for (int i = 0 ; i < select ; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}