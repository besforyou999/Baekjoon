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
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                queue.add(x);
            } else if (x == 0) {
                if (queue.size() == 0) {
                    bw.write(0 + "\n");
                } else {
                    int out = queue.poll();
                    bw.write(out + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}

