import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String [][] power = new String[N][2];

        for (int n = 0 ; n < N ; n++) {
            st = new StringTokenizer(br.readLine());
            power[n][0] = st.nextToken();
            power[n][1] = st.nextToken();
        }

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            int val = Integer.parseInt(br.readLine());

            int left = 0, right = N - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                mid = (left + right) / 2;
                int titleVal = Integer.parseInt(power[mid][1]);
                if (titleVal < val) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(power[left][0]).append("\n");
        }

        System.out.print(sb);
    }
}