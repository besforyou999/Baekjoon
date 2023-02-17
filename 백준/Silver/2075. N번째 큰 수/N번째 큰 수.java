import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
               pq.add(Integer.parseInt(st.nextToken()));
               if (pq.size() == N + 1) {
                   pq.poll();
               }
            }
        }

        Iterator<Integer> iter = pq.iterator();

        System.out.println(iter.next());
    }
}