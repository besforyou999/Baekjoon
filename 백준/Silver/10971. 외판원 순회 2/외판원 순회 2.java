import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] mat;
    static boolean [] visited;
    static int ANS = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < N ; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, i, 0);
        }

        System.out.println(ANS);
    }

    static void dfs(int start, int at, int cost) {
        if (AllVisited()) {
            if (mat[at][start] != 0) {
                ANS = Math.min(ANS, cost + mat[at][start]);
            }
            return;
        }

        for (int i = 1 ; i < N ; i++) {
            if (!visited[i] && mat[at][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + mat[at][i]);
                visited[i] = false;
            }
        }

    }

    static boolean AllVisited() {
        for (int i = 0 ; i < N ; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
}