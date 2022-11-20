import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int ingrd [] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            ingrd[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingrd);

        int lp = 0, rp = N - 1;
        int ans = 0;
        while (lp < rp) {
            int sum = ingrd[lp] + ingrd[rp];
            if (sum > M) {
                rp -= 1;
            } else if (sum < M) {
                lp += 1;
            } else {
                ans += 1;
                rp -= 1;
            }
        }
        System.out.print(ans);
    }
}

