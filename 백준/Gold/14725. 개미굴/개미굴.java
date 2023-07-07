import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        for (int n = 0 ; n < N ; n++) {

            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            String [] tokens = new String[K];

            for (int k = 0 ; k < K ; k++)
                tokens[k] = st.nextToken();

            trie.insert(tokens);
        }

        System.out.println(trie.buildMap());
    }

    static class Trie {

        Node rootNode = new Node();

        String line = "--";

        void insert (String [] tokens) {
            Node node = this.rootNode;

            for (int i = 0; i < tokens.length ; i++)
                node = node.childNode.computeIfAbsent( tokens[i], key -> new Node() );

            node.endOfword = true;
        }

        String buildMap() {
            StringBuilder sb = new StringBuilder();
            dfs(this.rootNode, sb, 0);
            return sb.toString();
        }

        void dfs(Node node, StringBuilder sb, int depth) {

            ArrayList<String> children = new ArrayList<>(node.childNode.keySet());
            Collections.sort(children);

            for (String child : children) {
                for (int i = 0 ; i < depth ; i++) {
                    sb.append(line);
                }
                sb.append(child).append("\n");

                dfs(node.childNode.get(child), sb, depth + 1);
            }
        }

    }

    static class Node {
        // 자식 노드
        Map<String, Node> childNode = new HashMap<String, Node>();
        // 단어의 끝인지 아닌지 체크
        boolean endOfword;
    }
}