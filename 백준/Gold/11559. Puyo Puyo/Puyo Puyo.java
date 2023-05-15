import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static char [][] mat;

    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    static final int HEIGHT = 12, WEIGHT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mat = new char[HEIGHT][WEIGHT];

        for (int r = 0 ; r < 12 ; r++) {
            String line = br.readLine();
            for (int c = 0; c < 6 ; c++) {
                mat[r][c] = line.charAt(c);
            }
        }

        int loop = 0;

        for (int i = 0 ; i < 1000 ; i++) {

            // 1. 그래프 돌면서 제거할 블록 있는지 확인
            boolean [][] visit = new boolean[HEIGHT][WEIGHT];
            boolean [][] deleteBlock = new boolean[HEIGHT][WEIGHT];
            boolean exist = false;
            for (int r = 0 ; r < HEIGHT ; r++) {
                for (int c = 0 ; c < WEIGHT ; c++) {
                    if (!visit[r][c] && mat[r][c] != '.') {
                       boolean result = blockToDelete(r, c, visit, deleteBlock);
                       if (result)
                           exist = true;
                    }
                }
            }
            /*
            for (int r = 0 ; r < HEIGHT ; r++) {
                for (int c = 0 ; c < WEIGHT ; c++) {
                    if (visit[r][c]) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
            */
            if (!exist)
                break;

            loop += 1;

            // mat에서 4개 이상 뿌요 제거
            deleteBlockFromMat(deleteBlock);

            // 중력에 의해 밑으로
            gravity();
        }

        System.out.println(loop);
    }

    public static void printVisit(boolean [][] visit) {
        for (int r = 0 ; r < HEIGHT ; r++) {
            for (int c = 0 ; c < WEIGHT ; c++) {
                if (visit[r][c]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void gravity() {
        for (int col = 0 ; col < WEIGHT ; col++) {
            updateColumn(col);
        }
    }

    public static void updateColumn(int col) {

        Queue<Character> queue = new LinkedList<>();

        for (int row = HEIGHT - 1 ; row >= 0 ; row--) {
            if (mat[row][col] != '.') {
                queue.add(mat[row][col]);
                mat[row][col] = '.';
            }
        }

        int row = 11;
        while(!queue.isEmpty()) {
            Character ch = queue.poll();
            mat[row--][col] = ch;
        }
    }

    public static void deleteBlockFromMat(boolean [][] deleteBlock) {
        for (int r = 0 ; r < 12 ; r++)
            for (int c = 0; c < 6 ; c++)
                if (deleteBlock[r][c])
                    mat[r][c] = '.';
    }

    public static boolean blockToDelete(int r, int c, boolean [][] visit, boolean [][] deleteBlock) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visit[r][c] = true;

        boolean exist = false;

        char letter = mat[r][c];

        int cnt = 1;

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int R = coord[0];
            int C = coord[1];

            if (cnt >= 4) {
                exist = true;
            }

            if (cnt >= 4 && !deleteBlock[R][C]) {
                checkBlockToDelete(R, C, deleteBlock);
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nr = R + dr[i];
                int nc = C + dc[i];
                if (isIn(nr, nc) && mat[nr][nc] == letter && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                    cnt += 1;
                }
            }
        }

        //System.out.println(mat[r][c] + " " + exist);
        //printVisit(visit);

        return exist;
    }

    static void checkBlockToDelete(int r, int c, boolean [][] deleteBlock) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        deleteBlock[r][c] = true;
        char letter = mat[r][c];
        while(!queue.isEmpty()) {
            int[] coord = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = coord[0] + dr[i];
                int nc = coord[1] + dc[i];
                if (isIn(nr, nc) && mat[nr][nc] == letter && !deleteBlock[nr][nc]) {
                    deleteBlock[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (0 <= r && r < HEIGHT && 0 <= c && c < WEIGHT);
    }

}