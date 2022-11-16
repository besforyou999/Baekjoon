import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [] indegree = new int[N + 1];
        ArrayList<Integer> [] list = new ArrayList[N + 1];
        for (int i = 1 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            indegree[B]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1 ; i <= N ; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()) {
            bw.write(queue.peek() + " ");
            int current = queue.poll();
            for (int i = 0 ; i < list[current].size() ; i++) {
                int next = list[current].get(i);
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        bw.flush();
        bw.close();
    }
}

