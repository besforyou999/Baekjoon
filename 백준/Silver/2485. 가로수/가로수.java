import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int [] arr;
    static int [] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        diff = new int[N - 1];

        for (int n = 0 ; n < N ; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        for (int n = 0 ; n < N - 1; n++) {
            diff[n] = arr[n + 1] - arr[n];
        }

        int div = gcd(diff[0], diff[1]);

        for (int i = 2 ; i < N - 1 ; i++) {
            div = gcd(div, diff[i]);
        }

        int sum = 0;

        for (int i = 0 ; i < N - 1 ; i++) {
            sum += (diff[i] / div) - 1;
        }

        System.out.println(sum);
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}