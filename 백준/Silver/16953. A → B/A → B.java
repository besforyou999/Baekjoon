import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static long max_num = 1_000_000_001L;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        Queue<Long[]> queue = new LinkedList<>();
        queue.add(new Long[] {A, 1L});

        while (!queue.isEmpty()) {
            Long [] tmp = queue.poll();
            Long num = tmp[0];
            Long cnt = tmp[1];

            if (num.equals(B)) {
                System.out.println(cnt);
                return;
            }

            for (int i = 0 ; i < 2 ; i++) {
                Long next_num;
                
                if (i == 0) {
                    next_num = (num * 10) + 1;
                } else {
                    next_num = num * 2;
                }
                
                if (next_num < max_num && next_num <= B) {
                    queue.add(new Long[] {next_num, cnt + 1});
                }
            }
        }

        System.out.println(-1);
    }
}