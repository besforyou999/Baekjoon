import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        if (N <= K) {
            System.out.println(0);
            return;
        }

        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 0 ; n < N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        Integer [] diff = new Integer[N - 1];

        for (int n = 0 ; n < N - 1 ; n++) {
            diff[n] = arr[n + 1] - arr[n];
        }

        Arrays.sort(diff, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2) * -1;
            }
        });

        int sum = 0;

        for (int i = K - 1 ; i < N - 1 ; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}