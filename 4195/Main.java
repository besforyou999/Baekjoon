import java.util.*;
import java.io.*;

class Main {
    public static int [] parent;
    public static int [] level;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < T ; i++) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2];
            level = new int[F * 2];

            for (int k = 0 ; k < F * 2 ; k++) {
                parent[k] = k;
                level[k] = 1;
            }

            int idx = 0;
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0 ; j < F ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String one = st.nextToken();
                String two = st.nextToken();

                int one_num, two_num;

                if (!map.containsKey(one)) {
                    map.put(one, idx++);
                    one_num = idx - 1;
                } else {
                    one_num = map.get(one);
                }

                if (!map.containsKey(two)) {
                    map.put(two, idx++);
                    two_num = idx - 1;
                } else {
                    two_num = map.get(two);
                }

                int result = union(one_num, two_num);
                sb.append(result).append('\n');

            }
        }
        System.out.print(sb);
    }

    public static int find_root(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find_root(parent[x]);
    }

    public static int union (int x, int y) {
        x = find_root(x);
        y = find_root(y);
        if (x != y) {
                parent[y] = x;
                level[x] += level[y];
                return level[x];
        }
        return level[x];
    }

    public static boolean sameParent(int x, int y) {
        return find_root(x) == find_root(y);
    }
}

