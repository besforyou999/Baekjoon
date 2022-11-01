import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long one = Long.parseLong(st.nextToken());
        long two = Long.parseLong(st.nextToken());

        long A = Math.max(one, two);
        long B = Math.min(one, two);
        long result = GCD(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < result ; i++) {
            sb.append(1);
        }
        System.out.print(sb);
    }

    public static long GCD(long a, long b) {
        long tmp;
        while (b > 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}

