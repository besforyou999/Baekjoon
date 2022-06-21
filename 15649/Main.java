import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);

        bw.flush();
        bw.close();
    }

    public static void dfs(int N, int M, int depth) throws IOException {
        if (depth == M) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}

