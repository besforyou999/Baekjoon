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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            int val = Integer.parseInt(br.readLine());
            queue.add(val);
        }
        int ans = 0;

        while (queue.size() > 1) {
            int one = queue.poll();
            int two = queue.poll();
            int sum = one + two;
            ans += sum;
            queue.add(sum);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}

