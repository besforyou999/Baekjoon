import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int [] arr = new int[N];

            for (int n = 0 ; n < N ; n++)
                arr[n] = Integer.parseInt(st.nextToken());

            long sum = 0;

            for (int i = 0 ; i < N - 1 ; i++)
                for (int j = i + 1 ; j < N ; j++)
                    sum += gcd(arr[i], arr[j]);

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}