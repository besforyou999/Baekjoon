import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class HW {
    int d, w;
    public HW(int d, int w) {
        this.d = d;
        this.w = w;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<HW> list = new ArrayList<>();

        int maxD = -1;

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new HW(d, w));
            maxD = Math.max(maxD, d);
        }

        Collections.sort(list, new Comparator<HW>() {
            @Override
            public int compare(HW o1, HW o2) {
                return Integer.compare(o1.w, o2.w) * -1;
            }
        });

        int sum = 0;
        int day = maxD;

        while (day > 0) {
            for (int i = 0 ; i < list.size() ; i++) {
                HW hw = list.get(i);
                if (day <= hw.d) {
                    sum += hw.w;
                    list.remove(i);
                    break;
                }
            }
            day--;
        }

        System.out.println(sum);
    }
}