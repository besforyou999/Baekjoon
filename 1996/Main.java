import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Pair> list;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < t ; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            list  = new ArrayList<>();

            for (int j = 0 ; j < N ; j++) {
                int priority = Integer.parseInt(st.nextToken());
                list.add(new Pair(priority, j));
            }

            int count = 0;
            while (!list.isEmpty()) {
                Pair pair = list.get(0);
                list.remove(pair);
                if (checkIfPriorityIsHighest(pair)) {
                    count += 1;
                    if (pair.id == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    list.add(pair);
                }
            }
        }
    }

    public static boolean checkIfPriorityIsHighest(Pair pair) {
        int pri = pair.priority;
        for (int i = 0 ; i < list.size() ; i++) {
            if (pri < list.get(i).priority) return false;
        }
        return true;
    }

}

class Pair {
    public int priority;
    public int id;
    Pair(int priority, int id) {
        this.priority = priority;
        this.id = id;
    }
}
