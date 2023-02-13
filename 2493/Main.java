import java.io.*;
import java.util.*;

class Tower {
    int number;
    int height;
    Tower(int n, int h) {
        this.number = n;
        this.height = h;
    }
}

public class Main {
    static int N;
    static Stack<Tower> stack = new Stack<>();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] answer = new int[N];

        for (int i = 0 ; i < N ; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                answer[i] = 0;
                stack.add(new Tower(i + 1, val));
            } else {
                Tower top = stack.peek();
                while (top.height < val) {
                    stack.pop();
                    if (stack.size() == 0) {
                        break;
                    }
                    top = stack.peek();
                }

                if (stack.size() == 0) {
                    answer[i] = 0;
                } else {
                    answer[i] = top.number;
                }

                stack.add(new Tower(i + 1, val));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}