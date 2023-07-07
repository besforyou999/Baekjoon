import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1 ; tc <= T ; tc++) {
            Trie trie = new Trie();

            int N = Integer.parseInt(br.readLine());

            for (int n = 0 ; n < N ; n++) trie.insert(br.readLine());

            if (trie.consist(N))
                sb.append("YES");
            else
                sb.append("NO");

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static class Trie {

        Node rootNode = new Node();

        void insert (String str) {
            Node node = this.rootNode;

            for (int i = 0; i < str.length() ; i++) {
                node = node.childNode.computeIfAbsent(str.charAt(i) - '0', key -> new Node());
            }

            node.endOfword = true;
        }

        boolean consist(int N) {

            int cnt = dfs(this.rootNode);

            if (cnt == N) return true;

            return false;
        }

        int dfs(Node node) {
            if (node.childNode.isEmpty()) return 1;

            int cnt = 0;
            for (Node next : node.childNode.values()) {
                cnt += dfs(next);
            }

            return cnt;
        }



    }

    static class Node {
        // 자식 노드
        Map<Integer, Node> childNode = new HashMap<Integer, Node>();
        // 단어의 끝인지 아닌지 체크
        boolean endOfword;
    }
}