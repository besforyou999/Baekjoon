import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {


        // 사용자로부터의 콘솔 입력
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();

        boolean [] notPrime = new boolean[N + 1];

        notPrime[0] = notPrime[1] = true;

        StringBuilder sb = new StringBuilder();

        for (int i = 2 ; i <= N ; i++) {
            if (!notPrime[i]) {
                if (i >= M)
                    sb.append(i).append("\n");
                for (int j = i + i; j <= N; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        System.out.print(sb);
    }
}