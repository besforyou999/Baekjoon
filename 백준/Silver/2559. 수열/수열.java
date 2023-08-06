import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int n = 1 ; n <= N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int i = 1, sum = 0;
        while (i <= K) sum += arr[i++];
        int max = sum;

        while (i <= N) {
            sum += arr[i] - arr[i - K];
            if (max < sum) max = sum;
            i++;
        }

        System.out.println(max);
    }
}