import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static StringTokenizer st;
    static int V, E, A, B;
    static Node [] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1 ; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            nodes = new Node[V + 1];
            for (int v= 0 ; v < V + 1 ; v++)
                nodes[v] = new Node();

            for (int e = 0 ; e < E ; e++) {
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                nodes[p].children.add(q);
                nodes[q].parent = p;
            }

            ArrayList<Integer> ancestorA = new ArrayList<>();
            ArrayList<Integer> ancestorB = new ArrayList<>();

            traverse(A, ancestorA);
            traverse(B, ancestorB);

            int root = 0;

            for (int i = 0 ; i < ancestorA.size() ; i++) {
                if (!ancestorA.get(i).equals(ancestorB.get(i))) break;
                root = ancestorA.get(i);
            }

            System.out.printf("#%d %d %d\n", tc, root, lca(root));
        }
    }

    public static void traverse(int idx, ArrayList<Integer> ancestor) {
        int parent = nodes[idx].parent;
        if (parent != 0)
            traverse(parent, ancestor);
        ancestor.add(idx);
    }

    public static int lca(int idx) {
        int res = 1;
        for (int child : nodes[idx].children)
            res += lca(child);
        return res;
    }

    public static class Node {

        int parent;
        ArrayList<Integer> children;

        Node() {
            parent = 0;
            children = new ArrayList<>();
        }
    }
}