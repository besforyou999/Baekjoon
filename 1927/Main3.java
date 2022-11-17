import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.size() == 0) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            } else {
                pq.offer(x);
            }
        }

        System.out.print(sb);
    }
}

