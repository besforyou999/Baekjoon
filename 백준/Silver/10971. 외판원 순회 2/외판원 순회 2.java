import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int mat[][];
    static boolean [] visit;
    static int ANS = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                mat[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < N ; i++) {
            visit = new boolean[N];
            visit[i] = true;
            back(i, i, 0);
        }

        System.out.println(ANS);
    }

    static void back(int start, int idx, int cost) {
        if (allVisited()) {
            if (mat[idx][start] != 0) {
                ANS = Math.min(ANS, cost + mat[idx][start]);
            }
            return;
        }

        for (int i = 1 ; i < N ; i++) {
            if (!visit[i] && mat[idx][i] != 0) {
                visit[i] = true;
                back(start, i, cost + mat[idx][i]);
                visit[i] = false;
            }
        }
    }

    static boolean allVisited() {
        for (int i = 0 ; i < visit.length ; i++) {
            if (!visit[i]) return false;
        }
        return true;
    }

}