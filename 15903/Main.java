import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            q.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0 ; i < m ; i++) {
            long a = q.poll();
            long b = q.poll();
            long sum = a + b;
            q.add(sum);
            q.add(sum);
        }

        Long sum = 0l;
        for (Long i : q) sum += i;

        System.out.print(sum);
    }
}
