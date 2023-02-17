import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] numbers = new int[9];
        for (int i = 0 ; i < 9 ; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        back(new boolean[9], new int[7], 0, 0, numbers);
    }

    static void back(boolean [] used, int[] num, int start, int depth, int [] hats) {
        if (depth == 7) {
            int sum = 0;
            for (int a : num) sum += a;
            if (sum == 100) {
                for (int a : num) {
                    System.out.println(a);
                }
                System.exit(0);
            }
            return;
        }

        for (int i = start ; i < hats.length ; i++) {
            if (!used[i]) {
                used[i] = true;
                num[depth] = hats[i];
                back(used, num, i + 1, depth + 1, hats);
                used[i] = false;
            }
        }
    }
}