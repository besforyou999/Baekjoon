import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Truck {
    int weight;
    int time;
    Truck(int w, int t) {
        this.weight = w;
        this.time = t;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Truck> line = new LinkedList<>();
        LinkedList<Truck> bridge = new LinkedList<>();

        for (int i = 0 ; i < n ; i++) {
            Truck t = new Truck(Integer.parseInt(st.nextToken()), 0);
            line.add(t);
        }

        int time = 0;
        int bridge_weight = 0;

        for (int i = 0 ; i < 1000000 ; i++) {
            if (bridge.isEmpty()) {
                if (line.isEmpty()) break;
                Truck newTruck = line.poll();
                bridge.add(newTruck);
                bridge_weight += newTruck.weight;
            } else {
                increaseAllTruckTimeOnBridge(bridge);
                if (bridge.peekFirst().time >= w) {
                    Truck truck = bridge.remove(0);
                    bridge_weight -= truck.weight;
                }

                if (!line.isEmpty()) {
                    Truck frontTruck = line.peekFirst();
                    if (bridge_weight + frontTruck.weight <= L) {
                        bridge.add(frontTruck);
                        bridge_weight += frontTruck.weight;
                        line.remove(0);
                    }
                }
            }
            time += 1;
        }

        System.out.println(time);

    }

    static void increaseAllTruckTimeOnBridge(LinkedList<Truck> bridge) {
        for (int i = 0 ; i < bridge.size() ; i++) {
            bridge.get(i).time += 1;
        }
    }
}