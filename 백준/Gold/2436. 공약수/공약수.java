import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long multi = A * B;

        long max = Long.MAX_VALUE;

        long one = A, two = B;

        for (long i = A ; i <= B ; i += A) {
            if (multi % i == 0) {
                long j = multi / i;
                if (gcd(i, j) == A) {
                    if (i + j < max) {
                        max = i + j;
                        one = i;
                        two = j;
                    }
                }
            }
        }

        System.out.println(one + " " + two);
    }

    public static long gcd(long p, long q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}