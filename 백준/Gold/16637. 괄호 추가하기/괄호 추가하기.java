import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int numbers[];
    static char symbols[];
    static ArrayList<int []> priorities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N / 2 + 1];
        symbols = new char[N / 2];

        String line = br.readLine();
        int idx1 = 0, idx2 = 0;

        for (int i = 0 ; i < line.length() ; i++) {
            if (i % 2 == 0)
                numbers[idx1++] = line.charAt(i) - '0';
            else
                symbols[idx2++] = line.charAt(i);
        }

        int ans = calculate(copyNumbers(), copySymbols(), 0);

        for (int i = 1 ; i < symbols.length ; i++) {
            priorities = new ArrayList<>();
            comb(new boolean[N / 2], 0, 0, i);
            for (int [] idxes : priorities) {
                int [] nums = copyNumbers();
                char [] syms = copySymbols();
                precalculate(idxes, nums, syms);
                int calc = calculate(nums, syms, i);
                ans = Math.max(ans, calc);
                /*
                System.out.println("numbers");
                for (int a : nums) {
                    System.out.print(a + " ");
                }
                System.out.println();
                System.out.println("Symbols");
                for (char c : syms) {
                    System.out.print(c + " ");
                }
                System.out.println();
                System.out.println("calc result : " + calculate(nums, syms, i));
                System.out.println();

                 */
            }
        }

        System.out.println(ans);
    }

    static void precalculate(int [] idxes, int []nums, char [] syms) {
        int r = idxes.length;
        for (int i : idxes) {
            char ch = syms[i];
            if (ch == '+') {
                nums[i + 1] = nums[i] + nums[i + 1];
            } else if (ch == '-') {
                nums[i + 1] = nums[i] - nums[i + 1];
            } else {
                nums[i + 1] = nums[i] * nums[i + 1];
            }
            nums[i] = -1000;
            syms[i] = 0;
        }
        int idx = 0;
        int [] cleanNums = new int[nums.length - r];
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != -1000) cleanNums[idx++] = nums[i];
        }

        for (int i = 0 ; i < cleanNums.length ; i++) {
            nums[i] = cleanNums[i];
        }

        for (int i = cleanNums.length ; i < nums.length ; i++) {
            nums[i] = -1000;
        }

        idx = 0;
        char [] cleanSyms = new char[syms.length - r];
        for (int i = 0 ; i < syms.length ; i++) {
            if (syms[i] != 0) cleanSyms[idx++] = syms[i];
        }

        for (int i = 0 ; i < cleanSyms.length ; i++) {
            syms[i] = cleanSyms[i];
        }

        for (int i = cleanSyms.length ; i < syms.length ; i++) {
            syms[i] = 'x';
        }

        return;
    }

    static void printPriorities() {
        for (int [] arr : priorities) {
            for (int a : arr)
                System.out.print(a + " ");
            System.out.println();
        }
    }

    static int[] copyNumbers() {
        int []tmp = new int[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++)
            tmp[i] = numbers[i];
        return tmp;
    }

    static char[] copySymbols() {
        char [] tmp = new char[symbols.length];
        for (int i = 0 ; i < symbols.length ; i++)
            tmp[i] = symbols[i];
        return tmp;
    }

    static int calculate(int [] numbers, char [] symbols, int r) {
        for (int i = 0 ; i < symbols.length - r; i++) {
            char symbol = symbols[i];
            int tmp = 0;
            if (symbol == '+')
                tmp = numbers[i] + numbers[i + 1];
            else if (symbol == '-')
                tmp = numbers[i] - numbers[i + 1];
            else
                tmp = numbers[i] * numbers[i + 1];
            numbers[i + 1] = tmp;
        }
        return numbers[numbers.length - 1 - r];
    }

    static void comb(boolean [] visit, int depth, int start, int r) {
        if (depth == r) {
            int tmp [] = new int[r];
            int idx = 0;
            for (int i = 0 ; i < visit.length ; i++)
                if (visit[i]) tmp[idx++] = i;

            if (isValidIdxes(tmp)) priorities.add(tmp);
            return;
        }

        for (int i = start ; i < visit.length; i++) {
            visit[i] = true;
            comb(visit, depth + 1, i + 1, r);
            visit[i] = false;
        }
    }

    static boolean isValidIdxes(int [] indexes) {
        for (int i = 0 ; i < indexes.length - 1 ; i++)
            if (indexes[i] + 1 == indexes[i + 1]) return false;
        return true;
    }
}