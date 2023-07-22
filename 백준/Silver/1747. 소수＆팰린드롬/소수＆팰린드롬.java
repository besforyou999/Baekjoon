import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static final int MAX = 2_000_000;
    static boolean[] notPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        notPrime = new boolean[MAX];

        notPrime[0] = notPrime[1] = true;

        for (int i = 2 ; i * i < MAX ; i++) {
            if (!notPrime[i]) {
                for (int j = i + i ; j < MAX ; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        for (int n = N ; n < MAX ; n++) {
            if (!notPrime[n] && isPalin(n)) {
                System.out.println(n);
                return;
            }
        }
    }

    public static boolean isPalin(Integer number) {
        String input = number.toString();
        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();

        return input.equals(reversed);
    }



}