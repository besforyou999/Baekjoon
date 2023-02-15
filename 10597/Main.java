import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String input;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        N = 0;

        if (input.length() <= 9) {
            N = input.length();
        } else {
            int len = input.length();
            len -= 9;
            len /= 2;
            N = 9 + len;
        }
        //System.out.println(N);

        boolean [] used = new boolean[N + 1];
        int [] numbers = new int[N + 1];

        back(used, 0, input.length(), numbers, 0);
    }

    static void back(boolean [] used, int idx, int len, int[] numbers, int depth) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0 ; i < N ; i++) {
                sb.append(numbers[i]).append(" ");
            }
            System.out.println(sb);
            System.exit(0);
        }

        // 1개 떼오기
        String one = input.substring(idx, idx + 1);
        int num1 = Integer.parseInt(one);
        if (num1 <= N) {
            if (!used[num1] && num1 != 0) {
                numbers[depth] = num1;
                used[num1] = true;
                back(used, idx + 1, len, numbers, depth + 1);
                used[num1] = false;
            }
        }

        if (idx < len - 1) {
            String two = input.substring(idx, idx + 2);
            int num2 = Integer.parseInt(two);
            if (num2 <= N && num2 <= 50) {
                if (!used[num2] && num2 != 0) {
                    numbers[depth] = num2;
                    used[num2] = true;
                    back(used, idx + 2, len, numbers, depth + 1);
                    used[num2] = false;
                }
            }
        }

    }
}


