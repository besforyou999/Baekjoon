import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int r, c, color, cnt;
    Pos(int r, int c, int color, int cnt) {
        this.r = r;
        this.c = c;
        this.color = color;
        this.cnt = 0;
    }
}

public class Main {
    static int N, M, G, R;
    static int [][] mat;
    static ArrayList<Pos> positions;
    static int posSize, liquidNum;
    static int color[]; // 0 : G, R : 1
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static int ANS = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        positions = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        liquidNum = G + R;
        color = new int[liquidNum];

        mat = new int[N + 1][M + 1];

        for (int n = 1 ; n <= N ; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1 ; m <= M ; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
                if (mat[n][m] == 2) {
                    positions.add(new Pos(n, m, 0, 0));
                    mat[n][m] = 1;
                }
            }
        }

        posSize = positions.size();

        buildColor(new boolean[liquidNum], 0, liquidNum, R);

        System.out.println(ANS);
    }

    static void buildColor(boolean [] visit, int start, int n, int r) {
        if (r == 0) { // R,G 순서 정해짐
            buildBlockIdx(visit, new boolean[posSize], 0, posSize, visit.length);
            return;
        }

        for (int i = start ; i < n ; i++) {
            visit[i] = true;
            buildColor(visit, i + 1, n , r - 1);
            visit[i] = false;
        }
    }

    static void buildBlockIdx(boolean [] color, boolean [] use, int start, int n, int r) {
        if (r == 0) {
            ArrayList<Pos> posToUse = new ArrayList<>();
            for (int i = 0 ; i < n ; i++) {
                if (use[i]) {
                    Pos pos = positions.get(i);
                    posToUse.add(new Pos(pos.r, pos.c, 0, 0));
                }
            }

            for (int i = 0 ; i < color.length ; i++) {
                if (color[i]) {
                    posToUse.get(i).color = 1;
                }
            }

            simulation(copyMat(), posToUse);

            // simulation
            return;
        }

        for (int i = start ; i < n ; i++) {
            use[i] = true;
            buildBlockIdx(color, use, i + 1, n, r - 1);
            use[i] = false;
        }
    }

    static int [][] copyMat() {
        int [][] temp = new int[N + 1][M + 1];
        for (int n = 1 ; n <= N ; n++) {
            for (int m = 1; m <= M; m++) {
                temp[n][m] = mat[n][m];
            }
        }
        return temp;
    }

    static void simulation(int [][] board, ArrayList<Pos> posToUse) {
        boolean [][] visit = new boolean[N + 1][M + 1];
        Queue<Pos> queue = new LinkedList<>();

        for (Pos pos : posToUse) {
            visit[pos.r][pos.c] = true;
            queue.add(new Pos(pos.r, pos.c, pos.color, 0));
        }

        int flower = 0;
        int loop = 0;
        while (!queue.isEmpty()) {
            ArrayList<Pos> tmp = new ArrayList<>();
            int len = queue.size();
            for (int i = 0 ; i < len ; i++) {
                Pos pos = queue.poll();

                for (int d = 0 ; d < 4 ; d++) {
                    int nr = pos.r + dr[d];
                    int nc = pos.c + dc[d];

                    if (isIn(nr, nc) && board[nr][nc] > 0 && !visit[nr][nc]) {
                        tmp.add(new Pos(nr, nc, pos.color, 0));
                    }
                }
            }

            boolean [] bloom = new boolean[tmp.size()];

            for (int i = 0 ; i < tmp.size() - 1; i++) {
                Pos pos1 = tmp.get(i);
                for (int j = i + 1; j < tmp.size(); j++) {
                    Pos pos2 = tmp.get(j);
                    if (pos1.r == pos2.r && pos1.c == pos2.c && pos1.color != pos2.color && !visit[pos1.r][pos1.c]) {
                        flower += 1;
                        bloom[i] = true;
                        bloom[j] = true;
                        visit[pos1.r][pos1.c] = true;
                        //System.out.println(pos1.r + " " + pos1.c + " " + flower);
                    }
                }
            }

            for (int i = 0 ; i < tmp.size() ; i++) {
                if (!bloom[i]) {
                    Pos pos = tmp.get(i);
                    if (!visit[pos.r][pos.c]) {
                        visit[pos.r][pos.c] = true;
                        queue.add(new Pos(pos.r, pos.c, pos.color, 0));
                    }
                }
            }
            /*
            for (int n = 1 ; n <= N ; n++) {
                for (int m = 1 ; m <= M ; m++) {
                    if (visit[n][m]) {
                        System.out.print(1 + " ");
                    } else
                        System.out.print(1 + " ");
                }
                System.out.println();
            }
            System.out.println("=   =   =   =   =   =   =");
             */
        }

        ANS = Math.max(ANS, flower);
    }

    static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= M);
    }
}