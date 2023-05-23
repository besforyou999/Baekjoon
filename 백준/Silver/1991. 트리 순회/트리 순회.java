import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String root, left, right;

    public Node(String root, String left, String right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + root + '\'' +
                ", left='" + left + '\'' +
                ", right='" + right + '\'' +
                '}';
    }
}

public class Main {
    static int N;
    static Node []tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for (int n = 0 ; n < N ; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree[root.charAt(0) - 'A'] = new Node(root, left, right);
        }

        preOrder(tree[0], 0);
        System.out.println();
        InOrder(tree[0], 0);
        System.out.println();
        postOrder(tree[0], 0);
    }

    static void preOrder(Node node, int depth) {
        if (depth == N)
            return;

        System.out.print(node.root);

        if (!node.left.equals("."))
            preOrder(tree[node.left.charAt(0) - 'A'], depth + 1);

        if (!node.right.equals("."))
            preOrder(tree[node.right.charAt(0) - 'A'], depth + 1);
    }

    static void InOrder(Node node, int depth) {
        if (depth == N)
            return;


        if (!node.left.equals("."))
            InOrder(tree[node.left.charAt(0) - 'A'], depth + 1);

        System.out.print(node.root);

        if (!node.right.equals("."))
            InOrder(tree[node.right.charAt(0) - 'A'], depth + 1);
    }

    static void postOrder(Node node, int depth) {
        if (depth == N)
            return;

        if (!node.left.equals("."))
            postOrder(tree[node.left.charAt(0) - 'A'], depth + 1);

        if (!node.right.equals("."))
            postOrder(tree[node.right.charAt(0) - 'A'], depth + 1);

        System.out.print(node.root);
    }


}