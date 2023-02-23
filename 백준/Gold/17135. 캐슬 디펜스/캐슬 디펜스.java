import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ANS = Integer.MIN_VALUE;
    static int enemy_cnt_src = 0;
    static int N, M, D;
    static int [][] src;

    static int [][] delta = {
            {0, -1},
            {-1, 0},
            {0, 1}
    };

    static ArrayList<int[]> archerPositions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        src = new int[N + 1][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                int val = Integer.parseInt(st.nextToken());
                src[i][j] = val;
                if (val == 1) enemy_cnt_src++;
            }
        }

        archerPositions = new ArrayList<>();

        rec(new boolean[M], 0, 0, 3);

        for (int [] pos : archerPositions) {
            int res = simulation(pos);
            ANS = Math.max(ANS, res);
        }

        System.out.print(ANS);
    }

    static void rec(boolean [] visit, int depth, int start, int r) {
        if (depth == r) {
            int idx = 0;
            int [] archerPos = new int[3];
            for (int i = 0 ; i < visit.length ; i++) {
                if (visit[i])
                    archerPos[idx++] = i;
            }

            archerPositions.add(archerPos);
            return;
        }

        for (int i = start ; i < visit.length ; i++) {
            visit[i] = true;
            rec(visit, depth + 1, i + 1, r);
            visit[i] = false;
        }
    }

    static int [][] copySrc() {
        int [][] tmp = new int[N + 1][M];
        for (int i = 0 ; i < N + 1; i++)
            for (int j = 0 ; j < M ; j++)
                tmp[i][j] = src[i][j];
        return tmp;
    }
    static int simulation(int [] archersPos) {
        int [][] mat = copySrc(); // 원본 두고 복사본으로 진행
        int enemyCnt = enemy_cnt_src; // 적 숫자 원본 복사하여 진행
        int killCnt = 0;
        
        for (int i = 0 ; i <= N ; i++) {
            int kills = archerAtk(mat, archersPos);
            enemyCnt -= kills;
            killCnt += kills;

            // 2. 적 이동
            int loss = moveEnemies(mat);
            enemyCnt -= loss;
        }
        return killCnt;
    }

    static int moveEnemies(int [][] mat) {
        int cnt = 0;

        for (int c = 0; c < M ; c++) {
            if (mat[N - 1][c] == 1) {
                cnt++;
                mat[N - 1][c] = 0;
            }
        }

        for (int r = N - 2; r >= 0 ; r--) {
            for (int c = 0; c < M; c++) {
                if (mat[r][c] == 1) {
                    mat[r + 1][c] = 1;
                    mat[r][c] = 0;
                }
            }
        }

        return cnt;
    }

    static int archerAtk(int [][] mat, int [] archerPos) {
        int cnt = 0;

        ArrayList<int[]> targets = new ArrayList<>();

        for (int pos : archerPos) {
            int [] tmp = getArcherTarget(pos, mat);
            if (tmp != null) {
               targets.add(tmp);
            }
        }

        for (int [] pos : targets) {
            int r = pos[0];
            int c = pos[1];
            if (mat[r][c] == 1) {
                cnt++;
                mat[r][c] = 0;
            }
        }

        return cnt;
    }

    static int[] getArcherTarget(int archerCol, int [][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, archerCol, 0});

        boolean [][] visit = new boolean[N + 1][M];
        visit[N][archerCol] = true;

        ArrayList<int[]> targets = new ArrayList<>();

        while(!queue.isEmpty()) {
            int [] coords = queue.poll();
            int r = coords[0];
            int c = coords[1];
            int d = coords[2];

            if (mat[r][c] == 1) {
                targets.add(new int[]{r, c, d});
                continue;
            }

            for (int i = 0 ; i < 3 ; i++) {
                int nr = r + delta[i][0];
                int nc = c + delta[i][1];
                if (isIn(nr, nc) && !visit[nr][nc] && d < D) {
                    visit[nr][nc] = true;
                    queue.add(new int[] {nr, nc, d + 1});
                }
            }
        }

        if (targets.size() == 0) return null;

        Collections.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int dist = targets.get(0)[2];

        for (int i = 0 ; i < targets.size() ; i++) {
            if (targets.get(i)[2] != dist) {
                targets.remove(i--);
            }
        }

        if (targets.size() == 1) return targets.get(0);

        Collections.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        return targets.get(0);
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N + 1 && c >= 0 && c < M);
    }
}