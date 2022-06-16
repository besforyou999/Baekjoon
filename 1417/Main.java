import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(0);
            return;
        }

        int me = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1 ; i < N ; i++) pq.offer(Integer.parseInt(br.readLine()));

        int cnt = 0;

        while (me <= pq.peek()) {
            int peek = pq.poll();
            cnt += 1;
            me += 1;
            pq.offer(peek - 1);
        }

        System.out.print(cnt);
    }
}
