import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int [] parent;
    static ArrayList<ArrayList<Integer>> parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        st = new StringTokenizer(br.readLine());

        int truthPersonCnt = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            union(0, Integer.parseInt(st.nextToken()));
        }

        for (int m = 0 ; m < M ; m++) {

            st = new StringTokenizer(br.readLine());

            int partyPeople = Integer.parseInt(st.nextToken());

            ArrayList<Integer> party = new ArrayList<>();

            while (st.hasMoreTokens()) {
                party.add(Integer.parseInt(st.nextToken()));
            }

            parties.add(party);
        }

        for (ArrayList<Integer> party : parties) {
            if (party.size() > 1) {
                for (int i = 0 ; i < party.size() - 1 ; i++) {
                    union(party.get(i), party.get(i+1));
                }
            }
        }

        int canLie = 0;

        for (ArrayList<Integer> party : parties) {
            if (!sameParent(0, party.get(0))) canLie += 1;
        }

        System.out.println(canLie);
    }

    public static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x == y) return;

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static boolean sameParent(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    public static int findRoot(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findRoot(parent[x]);
    }

    public static void init() {

        parties = new ArrayList<>();

        parent = new int[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            parent[i] = i;
        }
    }
}