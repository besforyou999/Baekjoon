import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class SpinOp {
    int r, c, s;
    public SpinOp(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

public class Main {
    static int MIN = 100000000;
    static int N, M, K;
    // 아래, 오른, 위, 왼
    static int [] dr = {1, 0, -1, 0};
    static int [] dc = {0, 1, 0, -1};

    static ArrayList<SpinOp> operations = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int [][]mat = new int[N + 1][M + 1];
        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= M ; j++)
                mat[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            operations.add(new SpinOp(r, c, s));
        }

        boolean []used = new boolean[operations.size()];

        back(used, 0, mat);

        System.out.println(MIN);
    }

    static void back(boolean [] used, int depth, int map[][]) {
        if (depth == K) {
            int minimum = 1000000;
            for (int i = 1 ; i <= N ; i++) {
                int sum = 0;
                for (int j = 1 ; j <= M ; j++) {
                    sum += map[i][j];
                }
                minimum = Math.min(minimum, sum);
            }
            MIN = Math.min(minimum, MIN);
            return;
        }

        for (int i = 0 ; i < used.length ; i++) {
            if (!used[i]) {
                used[i] = true;
                int [][] copyMap = copyMatrix(map);
                SpinOp spinOp = operations.get(i);
                spinOperation(spinOp.r, spinOp.c, spinOp.s, copyMap);
                back(used, depth + 1, copyMap);
                used[i] = false;
            }
        }

    }

    static int [][] copyMatrix(int [][]map) {
        int [][] tmp = new int[N + 1][M + 1];
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++)
                tmp[i][j] = map[i][j];
        }
        return tmp;
    }



    static void spinOperation(int r, int c, int s, int [][] mat) {
        for (int i = 1 ; i <= s ; i++) {
            spinClockWise(r - i, c - i, i * 2, mat);
        }
    }


    static void spinClockWise(int r, int c, int len, int mat[][]) {
        int tmp = mat[r][c];
        int idx = 0;

        int start_r = r;
        int start_c = c;

        while (idx < 4) {
            int nr = r + dr[idx];
            int nc = c + dc[idx];
            if (nr >= start_r && nr <= start_r + len && nc >= start_c && nc <= start_c + len) {
                mat[r][c] = mat[nr][nc];
                r = nr;
                c = nc;
            } else
                idx++;
        }
        mat[start_r][start_c + 1] = tmp;
    }
}


