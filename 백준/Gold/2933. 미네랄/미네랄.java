import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char [][] cave;

    static int dr [] = {-1, 1, 0, 0};
    static int dc [] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cave = new char[R + 1][C + 1];

        for (int r = 1 ; r <= R ; r++) {
            String line = br.readLine();
            for (int c = 1 ; c <= C ; c++) {
                cave[r][c] = line.charAt(c - 1);
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int dir = 1; // 1 : left, -1 : right
        for (int n = 0 ; n < N ; n++) {
            int height = Integer.parseInt(st.nextToken());
            if (dir == 1) {
                shootArrowFromLeft(height);
            } else
                shootArrowFromRight(height);

            dropClusterIfExist();

            dir *= -1;
        }

        printMat();

    }

    static void shootArrowFromLeft(int height) {
        int row = R - height + 1;
        for (int col = 1 ; col <= C ; col++) {
            if (cave[row][col] == 'x') {
                cave[row][col] = '.';
                return;
            }
        }
    }

    static void shootArrowFromRight(int height) {
        int row = R - height + 1;
        for (int col = C ; col >= 1 ; col--) {
            if (cave[row][col] == 'x') {
                cave[row][col] = '.';
                return;
            }
        }
    }

    static void printMat() {
        StringBuilder sb = new StringBuilder();
        for (int r = 1 ; r <= R ; r++) {
            for (int c = 1 ; c <= C ; c++) {
                sb.append(cave[r][c]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dropClusterIfExist() {
        boolean [][] connectedToGround = new boolean[R + 1][C + 1];
        for (int c = 1 ; c <= C ; c++) {
            if (cave[R][c] == 'x' && !connectedToGround[R][c]) {
                bfs(connectedToGround, R, c);
            }
        }
        ArrayDeque<int[]> cluster = new ArrayDeque<>();
        ArrayDeque<int[]> clusterBottom = new ArrayDeque<>();

        for (int r = 1 ; r <= R ; r++) {
            for (int c = 1 ; c <= C ; c++) {
                if (cave[r][c] == 'x' && !connectedToGround[r][c]) {
                    cluster.add(new int[] {r, c});
                    if (isIn(r + 1, c) && cave[r+1][c] == '.') {
                        clusterBottom.add(new int[] {r, c});
                    }
                }
            }
        }

        if (cluster.isEmpty()) return; // 공중에 떠있는 클러스터가 없으면 그대로 종료

        // 떨어질 높이 계산. 클러스터 바닥과 x 또는 지면과의 최단 거리가 떨어질 높이

        int fallHeight = 10000;

        for (int [] coord : clusterBottom) {
            int r = coord[0];
            int c = coord[1];
            int height = 0;
            for (int row = r + 1 ; row <= R ; row++) {
                if (cave[row][c] == 'x' && connectedToGround[row][c]) {
                    fallHeight = Math.min(fallHeight, height);
                    break;
                } else if (cave[row][c] == '.' && row == R) {
                    fallHeight = Math.min(fallHeight, height + 1);
                    break;
                }
                height++;
            }
        }

        for (int [] coord : cluster) {
            int r = coord[0];
            int c = coord[1];
            cave[r][c] = '.';
        }

        for (int [] coord : cluster) {
            int r = coord[0] + fallHeight;
            int c = coord[1];
            cave[r][c] = 'x';
        }

    }

    static void bfs(boolean [][] connectedToGround, int r, int c) {
        connectedToGround[r][c] = true;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {r, c});

        while(!deque.isEmpty()) {
            int [] coord = deque.poll();
            for (int i = 0 ; i < 4 ; i++) {
                int nr = coord[0] + dr[i];
                int nc = coord[1] + dc[i];
                if (isIn(nr, nc) && cave[nr][nc] == 'x' && !connectedToGround[nr][nc]) {
                    connectedToGround[nr][nc] = true;
                    deque.add(new int[] {nr, nc});
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 1 && r <= R && c >= 1 && c <= C);
    }

}