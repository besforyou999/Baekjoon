import java.io.*;
import java.util.*;

class Doc {
    int importance;
    int number;
    public Doc(int i, int n) {
        this.importance = i;
        this.number = n;
    }
}

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Queue<Doc> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < N ; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new Doc(importance, i));
            }

            int cnt = 1;
            while (!queue.isEmpty()) {
                // 가장 큰 정수 찾기
                int max_importance = Integer.MIN_VALUE;
                for (Doc d : queue) {
                    if (d.importance > max_importance) max_importance = d.importance;
                }
                // 가장 큰 중요도 문서 head로
                while (queue.peek().importance != max_importance) {
                    Doc d = queue.poll();
                    queue.add(d);
                }

                // M이면 출력 & 반복문 탈출
                Doc most_important = queue.poll();
                if (most_important.number == M) {
                    sb.append(cnt).append('\n');
                    break;
                }
                cnt += 1;
            }
        }
        System.out.print(sb);
    }
}

