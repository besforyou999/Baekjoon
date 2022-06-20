import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ( T-- > 0 ) {
            int N = Integer.parseInt(br.readLine());
            int [] Li = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < N ; i++) Li[i] = Integer.parseInt(st.nextToken());     // O(N)

            Arrays.sort(Li);        // O(N * logN)

            int [] temp = new int[N];
            int lp = 0 , rp = N - 1;
            for (int i = 0 ; i < N ; i++) {     // O(N)
                if (i % 2 == 0) {
                    temp[lp++] = Li[i];
                } else if (i % 2 == 1) {
                    temp[rp--] = Li[i];
                }
            }

            int max = -1;
            for (int i = 0 ; i < N - 1 ; i++) {  // O(N)
                int abs = Math.abs(temp[i] - temp[i+1]);
                if (max < abs) max = abs;
            }
            int abs = Math.abs(temp[N-1] - temp[0]);
            if (max < abs) max = abs;

            bw.write(max + "\n");
            bw.flush();
        }
    }
}

