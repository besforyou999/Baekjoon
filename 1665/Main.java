import java.io.*;
import java.net.CookieHandler;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        maxQueue.add(Integer.parseInt(br.readLine()));
        System.out.println(maxQueue.peek());
        for (int i = 1 ; i < N ; i++) {
            int num = Integer.parseInt(br.readLine());
            int maxQueueSize = maxQueue.size();
            int minQueueSize = minQueue.size();

            if (maxQueueSize > minQueueSize)    minQueue.add(num);
            else                                maxQueue.add(num);

            int maxTop = maxQueue.peek();
            int minTop = minQueue.peek();
            if (maxTop > minTop) {
                maxQueue.poll();
                minQueue.poll();
                maxQueue.add(minTop);
                minQueue.add(maxTop);
            }
            bw.write(maxQueue.peek() + "\n");
        }
        bw.flush();
        bw.close();
    }

}
