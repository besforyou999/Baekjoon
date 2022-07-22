import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1 ; i <= N ; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            int top = queue.poll();
            int second = queue.poll();
            queue.add(second);
        }

        System.out.print(queue.peek());
    }
}
