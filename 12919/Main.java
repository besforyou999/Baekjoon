import java.io.*;
import java.util.*;

class Main {
    static String S, T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        int result = dfs(S, T);

        System.out.print(result);
    }

    public static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t))
                return 1;
            return 0;
        }

        int ans = 0;
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String newS = sb.reverse().toString();
            ans += dfs(s, newS);
        }

        if (t.charAt(t.length() -1) == 'A') {
            ans += dfs(s, t.substring(0, t.length() -1));
        }
        return ans > 0 ? 1 : 0;
    }
}

