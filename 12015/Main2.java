import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for (int i = 0 ; i < N ; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (arr.get(arr.size() - 1) < temp) {
                arr.add(temp);
            } else {
                int left = 1, right = arr.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (arr.get(mid) < temp) {
                        left = mid + 1;
                    } else
                        right = mid;
                }
                arr.set(right, temp);
            }
        }
        System.out.print(arr.size() - 1);
    }
}
