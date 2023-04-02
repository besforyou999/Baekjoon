import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord {
    int r, c;
    Coord(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N, M;
    static int mat[][];
    static int cheese = 0;

    static int dr [] = {-1, 1, 0 , 0};
    static int dc [] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
                if (mat[i][j] == 1) cheese++;
            }
        }

        int hour = 0;
        int remainCheese = cheese;
        while(cheese > 0) {
            remainCheese = cheese;
            simulation();
            hour++;
        }

        System.out.println(hour);
        System.out.println(remainCheese);

    }

    static void simulation() {

        ArrayList<Coord> meltCoord = new ArrayList<>();
        boolean visit[][] = new boolean[N][M];

        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < M ; c++) {
                if (mat[r][c] == 0 && !visit[r][c]) {
                    bfs(visit, meltCoord, r, c);
                }
            }
        }

        cheese -= meltCoord.size();

        for (Coord coord : meltCoord) {
            mat[coord.r][coord.c] = 0;
        }

    }

    static void bfs(boolean [][] visit, ArrayList<Coord> coords, int r, int c) {
        boolean innerAir = true;

        ArrayList<Coord> candidates = new ArrayList<>();

        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(r, c));

        visit[r][c] = true;

        while(!queue.isEmpty()) {
            Coord coord = queue.poll();
            int cr = coord.r;
            int cc = coord.c;

            for (int i = 0 ; i < 4 ; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(!isIn(nr,nc)) innerAir = false;

                if (isIn(nr, nc) && !visit[nr][nc]) {
                    if (mat[nr][nc] == 0) { // 다음 흰칸
                        visit[nr][nc] = true;
                        queue.add(new Coord(nr, nc));
                    }  else if (mat[nr][nc] == 1) { // 치즈 겉표면
                        visit[nr][nc] = true;
                        candidates.add(new Coord(nr, nc));
                    }
                }
            }
        }

        if (!innerAir) {
            for(Coord coord : candidates) {
                coords.add(coord);
            }
        }
    }


    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }
}