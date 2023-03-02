import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class CCTV {
    int r, c, type, dir;
    CCTV(int r, int c, int t, int d) {
        this.r = r;
        this.c = c;
        this.type = t;
        this.dir = d;
    }
}

public class Main {
    static int N, M;
    static int [][] mat;

    static int [][] deltaOne = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    static int [][][] deltaTwo = {
            {{1, 0}, {-1, 0}},
            {{0, 1}, {0, -1}},
    };

    static int [][][] deltaThree = {
            {{-1, 0}, {0, 1}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, -1}, {-1, 0}}
    };

    static int [][][] deltaFour = {
            {{-1, 0}, {0, 1}, {0, -1}},
            {{0, 1}, {1, 0}, {-1, 0}},
            {{0, -1}, {1, 0}, {0, 1}},
            {{-1, 0}, {0, -1}, {1, 0}}
    };

    static int [][] deltaFive = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int MIN = Integer.MAX_VALUE;

    static ArrayList<CCTV> cameras = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                int val = Integer.parseInt(st.nextToken());
                mat[i][j] = val;
                if (val >= 1 && val <= 5) {
                    cameras.add(new CCTV(i, j, val, 0));
                }
            }
        }

        int [] actions = new int[cameras.size()];
        for (int i = 0 ; i < cameras.size() ; i++) {
            CCTV ct = cameras.get(i);
            int t = ct.type;
            if (t == 1 || t == 3 || t == 4) {
                actions[i] = 3;
            } else if (t == 2) {
                actions[i] = 1;
            }
        }

        back(0, actions);
        System.out.println(MIN);
    }

    static void back(int depth, int [] actions) {
        if (actions.length == depth) {

            int cnt = countZeros(actions);
            MIN = Math.min(MIN, cnt);
            return;
        }

        int action = actions[depth];

        for (int delta = 0 ; delta <= action ; delta++) {
            actions[depth] -= delta;
            back(depth + 1, actions);
            actions[depth] += delta;
        }
    }

    static void printMat(int [][] map) {
        System.out.println("=   =    =   =   =   =   =   =   =");
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=   =    =   =   =   =   =   =   =");
    }


    static int countZeros(int [] actions) {
        int [][] map = copyMat();

        for (int i = 0 ; i < actions.length ; i++) {
            CCTV camera = cameras.get(i);
            int spin = actions[i];
            int type = camera.type;
            camera.dir = spin;
            if (type == 1) {
                cameraTypeOne(camera, map);
            } else if (type == 2) {
                cameraTypeTwo(camera, map);
            } else if (type == 3) {
                cameraTypeThree(camera, map);
            } else if (type == 4) {
                cameraTypeFour(camera, map);
            } else if (type == 5) {
                cameraTypeFive(camera, map);
            }
        }

        int cnt = 0;
        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < M ; c++) {
                if (map[r][c] == 0) cnt++;
            }
        }

        //printMat(map);
        return cnt;
    }

    static void cameraTypeOne(CCTV camera, int [][] map) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {camera.r, camera.c, camera.dir});

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            int dir = coord[2];
            int nr = r + deltaOne[dir][0];
            int nc = c + deltaOne[dir][1];

            if (isIn(nr, nc) && map[nr][nc] != 6) {
                map[nr][nc] = 1;
                queue.add(new int[] {nr, nc, dir});
            }
        }
    }

    static void cameraTypeTwo(CCTV camera, int [][] map) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {camera.r, camera.c, camera.dir, 0});
        queue.add(new int[] {camera.r, camera.c, camera.dir, 1});

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            int dir = coord[2];
            int type = coord[3];
            int nr = r + deltaTwo[dir][type][0];
            int nc = c + deltaTwo[dir][type][1];

            if (isIn(nr, nc) && map[nr][nc] != 6) {
                map[nr][nc] = 2;
                queue.add(new int[] {nr, nc, dir, type});
            }
        }
    }

    static void cameraTypeThree(CCTV camera, int [][] map) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {camera.r, camera.c, camera.dir, 0});
        queue.add(new int[] {camera.r, camera.c, camera.dir, 1});

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            int dir = coord[2];
            int type = coord[3];
            int nr = r + deltaThree[dir][type][0];
            int nc = c + deltaThree[dir][type][1];

            if (isIn(nr, nc) && map[nr][nc] != 6) {
                map[nr][nc] = 3;
                queue.add(new int[] {nr, nc, dir, type});
            }
        }
    }

    static void cameraTypeFour(CCTV camera, int [][] map) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {camera.r, camera.c, camera.dir, 0});
        queue.add(new int[] {camera.r, camera.c, camera.dir, 1});
        queue.add(new int[] {camera.r, camera.c, camera.dir, 2});

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            int dir = coord[2];
            int type = coord[3];
            int nr = r + deltaFour[dir][type][0];
            int nc = c + deltaFour[dir][type][1];

            if (isIn(nr, nc) && map[nr][nc] != 6) {
                map[nr][nc] = 4;
                queue.add(new int[] {nr, nc, dir, type});
            }
        }
    }

    static void cameraTypeFive(CCTV camera, int [][] map) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {camera.r, camera.c, 0});
        queue.add(new int[] {camera.r, camera.c, 1});
        queue.add(new int[] {camera.r, camera.c, 2});
        queue.add(new int[] {camera.r, camera.c, 3});

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            int dir = coord[2];
            int nr = r + deltaFive[dir][0];
            int nc = c + deltaFive[dir][1];

            if (isIn(nr, nc) && map[nr][nc] != 6) {
                map[nr][nc] = 5;
                queue.add(new int[] {nr, nc, dir});
            }
        }
    }


    static boolean isIn(int r, int c) {
        return ( r >= 0 && r < N && c >= 0 && c < M);
    }

    static int [][] copyMat() {
        int [][] tmp = new int[N][M];
        for (int i = 0 ; i < N ; i++)
            for (int j = 0 ; j < M ; j++)
                tmp[i][j] = mat[i][j];
        return tmp;
    }
}