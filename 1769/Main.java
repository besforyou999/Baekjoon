import java.io.*;
import java.util.*;

class Main {
    public static int trans_cnt = 0;
    public static boolean tri = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        rec(input);

        String decision = "NO";

        if (tri) decision = "YES";

        System.out.println(trans_cnt);
        System.out.println(decision);
    }

    public static void rec(String num) {
        if (num.length() < 2) {
            int number = Integer.parseInt(num);
            if (number % 3 == 0)
                tri = true;
            return;
        }

        Integer sum = 0;
        for (int i = 0 ; i < num.length() ; i++) {
            sum += num.charAt(i) - '0';
        }

        trans_cnt += 1;
        rec(sum.toString());
    }
}
