import java.io.*;

public class Main {
    public static int N;
    public static StringBuilder sb;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dfs("", 0);
        System.out.println(sb);
    }

    public static void dfs(String s, int cnt) {
        if (cnt == N) {
            sb.append(s ).append("\n");
            return;
        }

        for (int i = 1 ; i <= 9 ; i++) {
            if (IsPrime(Integer.parseInt(s + i))) {
                dfs(s + i, cnt + 1);
            }
        }
    }

    public static boolean IsPrime(int num) {
        if (num == 1) return false;
        for (int i = 2 ; i * i <= num ; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


}
