/*
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {

    }
}
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            bw.write( (M+1)/2 + "\n");
            PriorityQueue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> min_heap = new PriorityQueue<>();
            int cnt = 0;

            for (int i = 0 ; i < M ; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int value = Integer.parseInt(st.nextToken());

                if (max_heap.size() == min_heap.size()) {
                    max_heap.offer(value);
                } else
                    min_heap.offer(value);

                if (!min_heap.isEmpty()) {
                    if (max_heap.peek() > min_heap.peek()) {
                        int a = max_heap.poll();
                        int b = min_heap.poll();
                        max_heap.offer(b);
                        min_heap.offer(a);
                    }
                }

                if ( i % 2 == 0) {
                    if (cnt == 9 || i == M - 1) {
                        bw.write(max_heap.peek() + "\n");
                        cnt = 0;
                    } else {
                        bw.write(max_heap.peek() + " ");
                    }
                    cnt++;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
