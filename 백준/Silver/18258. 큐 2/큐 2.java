import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int n = 0 ; n < N ; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd) {
                case "push": {
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop": {
                    if (deque.size() == 0) sb.append(-1).append("\n");
                    else sb.append(deque.pollFirst()).append("\n");
                    break;
                }
                case "size": {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case "empty": {
                    if (deque.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                }
                case "front": {
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peekFirst()).append("\n");
                    break;
                }
                case "back": {
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}