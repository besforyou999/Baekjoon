import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int [] arr;
    static boolean [] visit;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        for (int n = 1 ; n < N + 1 ; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visit = new boolean[N + 1];

        for (int n = 1 ; n < N + 1 ; n++) {
            visit[n] = true;
            dfs(n, n);
            visit[n] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());

        for (int a : list) {
            System.out.println(a);
        }

    }

    static void dfs (int start, int target) {
        if (!visit[arr[start]]) {
            visit[arr[start]] = true;
            dfs(arr[start], target);
            visit[arr[start]] = false;
        }

        if (arr[start] == target) {
            list.add(target);
        }
    }
}