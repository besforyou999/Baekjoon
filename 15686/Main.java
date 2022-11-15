import java.io.*;
import java.util.*;

public class Main {
    public static int ans = Integer.MAX_VALUE;
    public static int N, M;
    public static ArrayList<House> houses = new ArrayList<>();
    public static ArrayList<House> stores = new ArrayList<>();
    public static int house_num, store_num;
    public static boolean visit[];
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    houses.add(new House(i+1, j+1));
                } else if (val == 2) {
                    stores.add(new House(i+1, j+1));
                }
            }
        }

        house_num = houses.size();
        store_num = stores.size();

        visit = new boolean[store_num];

        dfs(0, 0);

        System.out.print(ans);
    }

    public static void dfs(int idx, int depth) {
        if (depth == M) {
            House [] chicken = new House[M];
            int index = 0;
            for (int i = 0 ; i < store_num ; i++) {
                if (visit[i]) {
                    chicken[index++] = stores.get(i);
                }
            }
            ans = Math.min(ans, chicken_distance(chicken));
            return;
        }

        for (int i = idx ; i < store_num ; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    public static int chicken_distance(House[] chicken) {
        int sum = 0;
        for (House h2 : houses) {
            int tmp = Integer.MAX_VALUE;
            for (House c : chicken) {
                int d = distance(c, h2);
                if (tmp > d) tmp = d;
            }
            sum += tmp;
        }
        return sum;
    }

    public static int distance(House h1, House h2) {
        return Math.abs(h1.row - h2.row) + Math.abs(h1.col - h2.col);
    }
}

class House {
    int row, col;
    public House(int r, int c) {
        this.row = r;
        this.col = c;
    }
}
