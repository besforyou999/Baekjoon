import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Token {
    String number;
    int count;
    Token(String num, int c) {
        this.number = num;
        this.count = c;
    }
}

public class Main {
    static int MAX = 10000;
    static boolean isPrime[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime = new boolean[MAX];

        Arrays.fill(isPrime, true);

        for (int i = 2 ; i * i < MAX ; i++) {
            if (isPrime[i]) {
                for (int j = i * i ; j < MAX ; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String one = st.nextToken();
            String two = st.nextToken();
            int result = bfs(one, two);
            if (result == -1) {
                sb.append("Impossible").append("\n");
            } else
                sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(String start, String target) {
        boolean [] visit = new boolean[MAX];
        visit[Integer.parseInt(start)] = true;
        Queue<Token> queue = new LinkedList<>();
        queue.add(new Token(start, 0));

        while (!queue.isEmpty()) {
            Token token = queue.poll();
            String str = token.number;
            int cnt = token.count;

            if (str.equals(target)) return cnt;

            for (int i = 0 ; i < 4 ; i++) {
                int num = str.charAt(i) - '0';
                for (int j = 0 ; j <= 9 ; j++) {
                    if (num == j) continue;
                    String changedStr = changeStrAt(i, str, j);
                    Integer changedNumber = Integer.parseInt(changedStr);
                    if (!visit[changedNumber] && isInRange(changedNumber) && isPrime[changedNumber]) {
                        visit[changedNumber] = true;
                        queue.add(new Token(changedStr, cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    static boolean isInRange(Integer number) {
        return (number >= 1000 && number < 10000);
    }

    static String changeStrAt(int index, String target, int to) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < target.length() ; i++) {
            if (i == index) {
                sb.append(to);
            } else
                sb.append(target.charAt(i));
        }
        return sb.toString();
    }
}