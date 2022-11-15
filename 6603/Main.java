import java.io.*;
import java.util.*;

public class Main {
    public static int k;
    public static StringBuilder sb;
    public static int arr[];
    public static boolean visit[];
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            sb = new StringBuilder();
            arr = new int[k];
            visit = new boolean[k];

            for (int i = 0 ; i < k ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            System.out.println(sb);
        }
    }

    public static void dfs(int idx, int depth) {
        if (depth == 6) {
            for (int i = 0; i < k ; i++) {
                if (visit[i])
                    sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = idx ; i < k; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }
}
