import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int r, c;
    Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int W, H;

    static int[][] map;
    static int[][] edges;

    static Pos startPos;
    static ArrayList<Pos> positions;

    static int ANS = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) break;

            ANS = 1_000_000_000;
            map = new int[H + 1][W + 1];
            startPos = new Pos(0, 0);
            positions = new ArrayList<>();

            for (int h = 1 ; h <= H ; h++) {
                String line = br.readLine();
                for (int w = 1 ; w <= W ; w++) {
                    char ch = line.charAt(w - 1);
                    if (ch == 'x') {
                        map[h][w] = -1;
                    } else if (ch =='o') {
                        startPos.r = h;
                        startPos.c = w;
                        positions.add(0, new Pos(h, w));
                    } else if (ch == '*') {
                        positions.add(new Pos(h, w));
                    }
                }
            }

            edges = new int[positions.size() + 1][positions.size() + 1];

            boolean unavailableRoute = false;

            for (int i = 1 ; i <= positions.size() ; i++) {
                Pos start = positions.get(i - 1);
                int [][] rec = copyMap();
                bfs(rec, start);
                for (int j = 1 ; j <= positions.size() ;j++) {
                    if (i == j) continue;
                    Pos compare = positions.get(j - 1);
                    edges[i][j] = rec[compare.r][compare.c] - 1;
                    if (edges[i][j] == -1) unavailableRoute = true;
                }
                if (unavailableRoute) break;
            }

            if (unavailableRoute) {
                System.out.println(-1);
                continue;
            }

//            for (int i = 0 ; i < edges.length ; i++) {
//                for (int j = 0 ; j < edges.length ; j++) {
//                    System.out.print(edges[i][j] + " ");
//                }
//                System.out.println();
//            }

            int len = positions.size() - 1;
            int [] arr = new int[len];
            for (int i = 0 ; i < len ; i++) {
                arr[i] = i + 2;
            }

            perm(arr, new int[len], new boolean[len], 0, len, len);

            System.out.println(ANS);
        }
    }

    static void perm(int [] arr, int[] output, boolean[] visit, int depth, int n, int r) {
        if (depth == r) {
//            for (int i = 0 ; i < output.length ; i++) {
//                System.out.print(output[i] + " ");
//            }
//            System.out.println();

            int sum = 0;

            int start = 1;
            int to = output[0];
            sum += edges[start][to];

            for (int l = 0 ; l < n - 1; l++) {
                start = output[l];
                to = output[l + 1];
                sum += edges[start][to];
            }

            //System.out.println(sum);

            ANS = Math.min(ANS, sum);

            return;
        }

        for (int i = 0 ; i < n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visit, depth + 1, n , r);
                visit[i] = false;
            }
        }


    }

    static int[][] copyMap(){
        int [][] tmp = new int[H + 1][W + 1];
        for (int h = 1 ; h <= H ; h++)
            for (int w = 1 ; w <= W ; w++)
                tmp[h][w] = map[h][w];
        return tmp;
    }

    static void bfs(int [][] rec, Pos start) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start.r, start.c, 1});
        rec[start.r][start.c] = 1;

        while (!queue.isEmpty()) {
            int [] coord = queue.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nr = coord[0] + dr[i];
                int nc = coord[1] + dc[i];

                if (isIn(nr, nc) && rec[nr][nc] == 0) {
                    rec[nr][nc] = coord[2] + 1;
                    queue.add(new int[] {nr, nc, coord[2] + 1});
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 1 && r <= H && c >= 1 && c <= W);
    }
}