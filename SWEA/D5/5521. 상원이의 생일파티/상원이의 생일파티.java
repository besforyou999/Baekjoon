import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static StringTokenizer st;
    static int N, M;
    static Node [] nodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1 ; tc <= T ; tc++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            nodes = new Node[N + 1];
            for (int n = 0 ; n < N + 1 ; n++)
                nodes[n] = new Node();

            for (int m = 0 ; m < M ; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].friends.add(b);
                nodes[b].friends.add(a);
            }

            if (nodes[1].friends.size() == 0) {
                System.out.printf("#%d %d\n", tc, 0);
            } else {

                HashSet<Integer> invite = new HashSet<>();

                traverse(1, 0, invite);

                System.out.printf("#%d %d\n", tc, invite.size() - 1);
            }
        }

    }

    public static void traverse(int idx, int depth, HashSet<Integer> invite) {
        if (depth > 2)
            return;

        for (int friend : nodes[idx].friends) {
            traverse(friend, depth + 1, invite);
        }

        invite.add(idx);
    }

    public static class Node {
        ArrayList<Integer> friends;
        Node() {
            friends = new ArrayList<>();
        }
    }
}