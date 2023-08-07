import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Boolean> primes;
    static ArrayList<Integer> primeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        makePrimes();
        System.out.println(primeList.get(sc.nextInt() - 1));
    }

    public static void makePrimes() {
        int MAX = 800_000;
        primeList = new ArrayList<>();
        primes = new ArrayList<Boolean>();
        primes.add(false);
        primes.add(false);

        for (int i = 2; i <= MAX; i++)
            primes.add(i, true);

        for (int i = 2; (i * i) <= MAX; i++) {
            if (primes.get(i)) {
                for (int j = i * i; j <= MAX; j += i)
                    primes.set(j, false);
            }
        }

        for (int i = 2 ; i <= MAX ; i++) {
            if (primes.get(i)) primeList.add(i);
        }
    }
}