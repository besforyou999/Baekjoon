import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair {
    int height;
    int sameH;
    Pair(int height, int sameHeightCnt) {
        this.height = height;
        this.sameH = sameHeightCnt;
    }
}

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();

        long cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine()); // 현재 보는 키
            Pair pair = new Pair(n , 1);

            while (!stack.isEmpty() && stack.peek().height <= n) {
                Pair pop = stack.pop();
                cnt += pop.sameH;
                if (pop.height == n)
                    pair.sameH += pop.sameH;
            }

            if (!stack.isEmpty())
                cnt++;

            stack.push(pair);
        }

        System.out.println(cnt);
    }
}