package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static int k;
    public static String src[];
    public static Integer rec[];
    public static boolean visit[];

    public static Long MAX = Long.MIN_VALUE;
    public static String MAX_str = "";
    public static Long MIN = Long.MAX_VALUE;
    public static String MIN_str = "";

    // 2147483647
    
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        src = new String[k];
        rec = new Integer[k + 1];
        visit = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < k ; i++) {
            src[i] = st.nextToken();
        }

        dfs(0);
        
        System.out.println(MAX_str);
        System.out.println(MIN_str);
    }

    public static void dfs(int depth) {
        if (depth == k + 1) {
            if (determine()) {
                String str = makeStr();
                Long number = Long.parseLong(str);
                if (number > MAX) {
                    MAX = number;
                    MAX_str = str;
                }
                if (number < MIN) {
                    MIN = number;
                    MIN_str = str;
                }
            }
            return;
        }

        for (int i = 0 ; i < 10 ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                rec[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static String makeStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < rec.length ; i++)
            sb.append(rec[i]);
        return sb.toString();
    }

    public static boolean determine() {
        for (int i = 0 ; i < k ; i++) {
            Integer front = rec[i];
            Integer back = rec[i + 1];
            String symbol = src[i];

            if (symbol.equals("<")) {
                if (front > back) return false;
            } else if (symbol.equals(">")) {
                if (front < back) return false;
            }
        }
        return true;
    }
}
