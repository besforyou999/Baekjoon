import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] Ai = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            int sum = 0;
            for (int j = i ; j < N ; j++) {
                sum += Ai[j];
                if (sum == M) {
                    cnt += 1;
                    break;
                } else if (sum > M) {
                    break;
                }
            }
        }
        System.out.print(cnt);
    }
}

