import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int SIZE = 1001;
        boolean isPrime[] = new boolean[SIZE + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2 ; i < SIZE ; i++) {
            if (isPrime[i]) {
                for (int j = i + i ; j < SIZE ; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < N ; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (isPrime[val]) count += 1;
        }
        System.out.print(count);
    }
}

