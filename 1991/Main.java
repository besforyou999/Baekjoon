import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Node> tree;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>(N+1);

        for (int i = 0 ; i <= N ; i++) {
            tree.add(new Node('A','A'));
        }

        char rt ='A', l , r;
        StringTokenizer st;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            rt = st.nextToken().charAt(0);
            l = st.nextToken().charAt(0);
            r = st.nextToken().charAt(0);
            Node node = new Node(l, r);
            tree.set(rt - 'A', node);
        }

        preOrder('A');
        bw.write("\n");
        bw.flush();
        inOrder('A');
        bw.write("\n");
        bw.flush();
        postOrder('A');
        bw.write("\n");
        bw.flush();
		bw.close();
    }

    // root - left - right
    public static void preOrder(char node) throws IOException {
        if (node == '.') return;

        bw.write(node);
        preOrder(tree.get(node - 'A').left);
        preOrder(tree.get(node - 'A').right);
    }

    // left - root - right
    public static void inOrder(char node) throws IOException {
        if (node == '.') return;

        inOrder(tree.get(node - 'A').left);
        bw.write(node);
        inOrder(tree.get(node - 'A').right);
    }

    // left - right - root
    public static void postOrder(char node) throws IOException {
        if (node == '.') return;

        postOrder(tree.get(node - 'A').left);
        postOrder(tree.get(node - 'A').right);
        bw.write(node);
    }
}

class Node {
    public char left;
    public char right;
    public Node( char l, char r) {
        left = l;
        right = r;
    }
}

