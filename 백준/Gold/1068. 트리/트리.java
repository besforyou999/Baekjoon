import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int number;
    ArrayList<Integer> children;
    Node (int n) {
        this.number = n;
        children = new ArrayList<>();
    }
}

public class Main {
    static int N, K;
    static Node [] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        for (int n = 0 ; n < N ; n++) {
            nodes[n] = new Node(n);
        }

        int rootNumber = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0 ; n < N ; n++) {
            int val = Integer.parseInt(st.nextToken());
            if (val != -1) {
                nodes[val].children.add(n);
            } else {
                rootNumber = n;
            }
        }

        K = Integer.parseInt(br.readLine());

        System.out.println(dfs(rootNumber));
    }

    public static int dfs(int number) {
        if (number == K) {
            return 0;
        }

        if (nodes[number].children.size() == 0) {
            return 1;
        }

        if (nodes[number].children.size() == 1 && nodes[number].children.get(0) == K) {
            return 1;
        }

        int cnt = 0;

        for (Integer child : nodes[number].children) {
            cnt += dfs(child);
        }

        return cnt;
    }
}