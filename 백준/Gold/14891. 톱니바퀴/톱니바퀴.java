import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Gear {
    int mat[];
    Gear() {
        mat = new int[8];
    }

    void spinClockwise() { // 시계방향 회전
        int tmp = mat[7];
        for (int i = 7 ; i >= 1 ; i--)
            mat[i] = mat[i-1];
        mat[0] = tmp;
    }

    void spinCounterClockwise() {
        int tmp = mat[0];
        for (int i = 0 ; i < 7 ; i++) {
            mat[i] = mat[i+1];
        }
        mat[7] = tmp;
    }
}

/*
dir == 1 : 시계방향
dir == -1 : 반시계방향
N극 : 0
S극 : 1
 */
public class Main {
    static Gear [] gears;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new Gear[5];

        for (int i = 0 ; i < 4 ; i++) {
            String line = br.readLine();
            Gear gear = new Gear();
            for (int j = 0 ; j < line.length() ; j++) gear.mat[j] = line.charAt(j) - '0';
            gears[i + 1] = gear;
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            simulation(num, dir);
        }

        System.out.println(getResult());
    }

    static int getResult() {
        int ans = 0;
        int score = 1;
        for (int i = 1 ; i <= 4 ; i++) {
            if (gears[i].mat[0] == 1)
                ans += score;
            score *= 2;
        }
        return ans;
    }

    static void printGear(Gear gear) {
        StringBuilder sb = new StringBuilder();
        sb.append(gear.mat[7]).append(" ").append(gear.mat[0]).append(" ").append(gear.mat[1]).append("\n");
        sb.append(gear.mat[6]).append(" ").append(" ").append(" ").append(gear.mat[2]).append("\n");
        sb.append(gear.mat[5]).append(" ").append(gear.mat[4]).append(" ").append(gear.mat[3]).append("\n");
        System.out.println(sb);
    }

    static void simulation(int number, int dir) {
        boolean [] spin = new boolean[5];
        int [] spinDirections = new int[5];

        spin[number] = true;
        spinDirections[number] = dir;

        int spinDirection = dir;
        int left = number;
        int right = number;

        while (right + 1 <= 4) {
            Gear gear = gears[right];
            Gear rightGear = gears[right + 1];
            if (gear.mat[2] != rightGear.mat[6]) {
                spin[right + 1] = true;
                spinDirections[right + 1] = spinDirection * -1;
                right += 1;
                spinDirection *= -1;
            } else
                break;
        }
        
        spinDirection = dir;

        while (1 <= left - 1) {
            Gear gear = gears[left];
            Gear leftGear = gears[left - 1];
            if (gear.mat[6] != leftGear.mat[2]) {
                spin[left - 1] = true;
                spinDirections[left - 1] = spinDirection * -1;
                left -= 1;
                spinDirection *= -1;
            } else
                break;
        }

        for (int i = 1 ; i <= 4 ; i++) {
            if (spin[i]) {
                int direction = spinDirections[i];
                Gear gear = gears[i];
                spinGear(gear, direction);
            }
        }
    }

    static void spinGear(Gear gear, int dir) {
        if (dir == 1) {
            gear.spinClockwise();
        } else {
            gear.spinCounterClockwise();
        }
    }

}