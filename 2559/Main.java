import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] temp = new int[N];

        st = new StringTokenizer(br.readLine());

        temp[0] = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < N ; i++) {
            temp[i] = temp[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        int val = temp[K - 1];
        max = Math.max(val, max);

        for (int i = 0 ; i < N - K ; i++) {
            val = temp[i + K] - temp[i];
            max = Math.max(val, max);
        }

        System.out.print(max);
    }
}

