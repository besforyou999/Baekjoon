import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;
    static int [] numbers;
    static int [] symbols = {0, 0, 0, 0}; // 0: +, 1: -, 2: x, 3: %
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < 4 ; i++) {
            symbols[i] = Integer.parseInt(st.nextToken());
        }

        int r = numbers.length - 1;
        back(0, r, symbols, new int[r]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void back(int depth, int r, int [] symbols, int [] chosen) {
        if (depth == r) {
            int val = calculate(chosen);
            MAX = Math.max(MAX, val);
            MIN = Math.min(MIN, val);
            return;
        }

        for (int i = 0 ; i < symbols.length ; i++) {
            if (symbols[i] > 0) {
                symbols[i]--;
                chosen[depth] = i;
                back(depth + 1, r, symbols, chosen);
                symbols[i]++;
            }
        }
    }

    static int calculate(int [] chosen) {
        int []num = copyArr();
        for (int i  = 0 ; i < chosen.length ; i++) {
            int in = chosen[i];
            int num1 = num[i];
            int num2 = num[i + 1];
            if (in == 0) {
                num[i + 1] = (num1 + num2);
            } else if (in == 1) {
                num[i + 1] = (num1 - num2);
            } else if (in == 2) {
                num[i + 1] = (num1 * num2);
            } else {
                num[i + 1] = num1 / num2;
            }
        }

        return num[numbers.length - 1];
    }

    static int [] copyArr() {
        int tmp[] = new int[numbers.length];
        for (int i = 0 ; i < numbers.length ;i++) {
            tmp[i] = numbers[i];
        }
        return tmp;
    }
}