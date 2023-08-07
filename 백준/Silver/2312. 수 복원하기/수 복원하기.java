import java.io.*;
import java.util.*;

public class Main {

    static int MAX = 100_000;
    static ArrayList<Boolean> primes;
    static ArrayList<Integer> primeNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makePrimes();

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0 ; i < primeNumbers.size() ; i++) {
                int prime = primeNumbers.get(i);
                int cnt = 0;

                while (N % prime == 0) {
                    cnt++;
                    N /= prime;
                }

                if (cnt != 0)
                    sb.append(prime).append(" ").append(cnt).append("\n");
                if (N == 0) break;
            }
        }

        System.out.print(sb);
    }

    public static void makePrimes() {
        primeNumbers = new ArrayList<>();
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

        for (int i = 2 ; i <= MAX ; i++)
            if (primes.get(i)) primeNumbers.add(i);
    }

}