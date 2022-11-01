import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int Ax[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Ax = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) Ax[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0 ; i < N ; i++) {
            int sum = 0;
            for (int j = i; j < N ; j++) {
                sum += Ax[j];
                if (sum == M) {
                    answer += 1;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}

