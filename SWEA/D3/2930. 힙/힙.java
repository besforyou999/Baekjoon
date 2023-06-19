import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static StringTokenizer st;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1 ; tc <= T ; tc++) {

            sb.append("#").append(tc).append(" ");

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd == 1) {
                    int val = Integer.parseInt(st.nextToken());
                    heap.add(val);
                } else if (cmd == 2) {
                    if (heap.size() == 0) {
                        sb.append(-1).append(" ");
                    } else {
                        sb.append(heap.poll()).append(" ");
                    }
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}