import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println("<1>");
            System.exit(0);
        }

        LinkedList<Integer> link = new LinkedList<>();

        for (int i = 1 ; i <= N ; i++)
            link.add(i);

        StringBuilder sb = new StringBuilder("<");

        int idx = K - 1;
        int cnt = 0;
        int [] answer = new int[N];

        while (true) {
            answer[cnt++] = link.get(idx);
            link.remove(idx);
            if (link.isEmpty()) break;
            idx = (idx + K - 1) % link.size();
        }

        for (int i = 0 ; i < answer.length - 1; i++)
            sb.append(answer[i]).append(", ");

        sb.append(answer[N - 1]).append(">");
        System.out.println(sb);
    }
}