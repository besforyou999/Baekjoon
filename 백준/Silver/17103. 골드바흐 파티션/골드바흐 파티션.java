import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1_000_000;
    static ArrayList<Boolean> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makePrimes();

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            int val = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 2 ; j <= val / 2 ; j++) {
                if (primes.get(j) && primes.get(val - j)) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    public static void makePrimes() {
        primes = new ArrayList<Boolean>(MAX + 1);
        primes.add(false);
        primes.add(false);

        for (int i = 2 ; i <= MAX ; i++)
            primes.add(i, true);

        for (int i = 2 ; (i * i) <= MAX ; i++) {
            if (primes.get(i)) {
                for (int j = i * i; j <= MAX; j += i)
                    primes.set(j, false);
            }
        }
    }

}