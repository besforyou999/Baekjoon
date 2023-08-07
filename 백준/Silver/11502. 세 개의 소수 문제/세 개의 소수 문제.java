import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> primes;

    public static void main(String[] args) throws IOException{
        int n = 1010;
        int [] arr = new int[n + 1];

        for (int i = 2 ; i <= n ; i++) arr[i] = i;

        for (int i = 2 ; i * i <= n ; i++) {
            if (arr[i] == 0) continue;
            for (int j = i + i ; j <= n ; j += i)
                arr[j] = 0;
        }

        primes = new ArrayList<>();

        for (int i = 0 ; i <= n ; i++)
            if (arr[i] != 0) primes.add(i);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0 ; t < T ; t++) {

            int K = Integer.parseInt(br.readLine());
            int [] result = search(K);

            if (result == null)
                sb.append(0).append("\n");
            else
                sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]).append("\n");
        }

        System.out.println(sb);
    }

    public static int [] search(int K) {
        for (int i = 0 ; i < primes.size() ; i++) {
            for (int j = i ; j < primes.size() ; j++) {
                for (int l = j ; l < primes.size() ; l++) {
                    int first = primes.get(i);
                    int second = primes.get(j);
                    int third = primes.get(l);
                    if (first + second + third == K) {
                        return new int[] {first, second, third};
                    } else if (first + second + third > K) {
                        break;
                    }
                }
            }
        }
        return null;
    }
}