import java.io.*;
import java.util.*;

public class Main {
    static Integer M, N, H;
    static Integer box[][][];
    static int ripe = 0, unripe = 0, empty = 0;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new Integer[H][N][M];
        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        ripe += 1;
                        queue.add(new Position(i, j, k));
                    }
                    else if (temp == 0) unripe += 1;
                    else if (temp == -1) empty += 1;

                    box[i][j][k] = temp;
                }
            }
        }

        int days = 0;
        while (!queue.isEmpty() && unripe != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Position p = queue.poll();
                int x = p.x;
                int y = p.y;
                int z = p.z;

                for (int j = 0; j < 6; j++) {
                    int X = x + dx[j];
                    int Y = y + dy[j];
                    int Z = z + dz[j];

                    if (X < 0 || Y < 0 || Z < 0 || X >= M || Y >= N || Z >= H) continue;
                    if (box[Z][Y][X] != 0) continue;

                    unripe -= 1;
                    box[Z][Y][X] = 1;
                    queue.add(new Position(Z, Y, X));
                }
            }
            days++;
        }

        System.out.print(unripe == 0 ? days : -1);
    }
}

class Position  {
    public int x, y, z;
    Position(int z, int y, int x) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
