import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish>{
    int r;
    int c;
    int number;
    int direction;
    boolean isAlive;
    public Fish(int r, int c, int number, int direction, boolean isAlive) {
        this.r = r;
        this.c = c;
        this.number = number;
        this.direction = direction;
        this.isAlive = isAlive;
    }

    @Override
    public int compareTo(Fish o) {
        return this.number - o.number;
    }

    public void setPos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void spinDir() {
        this.direction++;
        if (this.direction == 9) {
            this.direction = 1;
        }
    }
}

class Shark extends Fish {
    int sum;
    public Shark(int r, int c, int number, int direction, int sum) {
        super(r, c, number, direction, true);
        this.sum = sum;
    }
}

public class Main {
    static int[][] bi = {
            {0, 0},
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1},
            {1, 0},
            {1, 1},
            {0, 1},
            {-1, 1}
    };

    static int MAX = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] mat = new int[4][4]; // -1: shark, 0 : empty, 1 >= : fish
        ArrayList<Fish> fishes = new ArrayList<>(16);
        Shark shark;

        for (int r = 0; r < 4; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 4; c++) {
                int number = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                Fish fish = new Fish(r, c, number, direction, true);
                fishes.add(fish);
                mat[r][c] = fish.number;
            }
        }

        Collections.sort(fishes);

        Fish start = fishes.get(mat[0][0] - 1);
        shark = new Shark(start.r, start.c, -1, start.direction, start.number);
        start.isAlive = false;
        mat[0][0] = -1;

        dfs(shark, mat, fishes);
        System.out.println(MAX);
    }


    static void dfs(Shark shark, int [][] mat, ArrayList<Fish> fishes) {
        if (shark.sum > MAX) MAX = shark.sum;

        moveFishes(fishes, mat);

        for (int i = 1 ; i < 4 ; i++) {
            int nr = shark.r + bi[shark.direction][0] * i;
            int nc = shark.c + bi[shark.direction][1] * i;
            if (!isIn(nr, nc) || mat[nr][nc] == 0) continue;

            int [][] tmpMat = copyMat(mat);
            ArrayList<Fish> copyArr = copyList(fishes);

            tmpMat[shark.r][shark.c] = 0;
            Fish victimFish = copyArr.get(tmpMat[nr][nc] - 1);
            Shark newShark = new Shark(victimFish.r, victimFish.c, -1, victimFish.direction, shark.sum + victimFish.number);
            victimFish.isAlive = false;
            tmpMat[nr][nc] = -1;

            dfs(newShark, tmpMat, copyArr);
        }
    }

    static void moveFishes(ArrayList<Fish> fishes, int [][] mat) {
        for(Fish fish : fishes) {
            if (!fish.isAlive) continue;
            moveFish(fish, mat, fishes);
        }
    }

    static int[][] copyMat(int mat[][]) {
        int tmp [][] = new int[4][4];
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                int val = mat[i][j];
                tmp[i][j] = val;
            }
        }
        return tmp;
    }

    static ArrayList<Fish> copyList(ArrayList<Fish> fishes) {
        ArrayList<Fish> tmp = new ArrayList<Fish>();
        for (Fish f : fishes) tmp.add(new Fish(f.r, f.c, f.number, f.direction, f.isAlive));
        return tmp;
    }

    static void moveFish(Fish fish, int [][] mat, ArrayList<Fish> fishes) {

        int r = fish.r;
        int c = fish.c;

        for (int i = 0 ; i < 8 ; i++) {
           int nr = r + bi[fish.direction][0];
           int nc = c + bi[fish.direction][1];

           if (isIn(nr, nc)) {
               if( mat[nr][nc] == 0) {
                   fish.setPos(nr, nc);
                   mat[r][c] = 0;
                   mat[nr][nc] = fish.number;
                   break;
               } else if (mat[nr][nc] >= 1) {
                   Fish tmp = fishes.get(mat[nr][nc] - 1);
                   mat[nr][nc] = fish.number;
                   mat[r][c] = tmp.number;
                   fish.setPos(nr, nc);
                   tmp.setPos(r, c);
                   break;
               } else if (mat[nr][nc] == -1) {
                   fish.spinDir();
               }
           } else {
               fish.spinDir();
           }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < 4 && c >= 0 && c < 4);
    }
}
