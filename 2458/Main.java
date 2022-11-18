import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean [][] check = new boolean[n+1][n+1];

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a][b] = true;
        }

        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (check[i][k] && check[k][j])
                        check[i][j] = true;
                }
            }
        }

        int [] cnt = new int[n + 1];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (check[i][j] || check[j][i])
                    cnt[i] += 1;
            }
        }

        int ans = 0;

        for (int i = 1 ; i <= n ; i++) {
            if (cnt[i] == n - 1) ans += 1;
        }
        System.out.print(ans);
    }
}


