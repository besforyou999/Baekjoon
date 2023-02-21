import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Country {
    int win, draw, lose;
    Country(int w, int d, int l) {
        this.win = w;
        this.draw = d;
        this.lose = l;
    }
}

public class Main {

    static int [][]rounds = {
            {0, 1},
            {0, 2},
            {0, 3},
            {0, 4},
            {0, 5},
            {1, 2},
            {1, 3},
            {1, 4},
            {1, 5},
            {2, 3},
            {2, 4},
            {2, 5},
            {3, 4},
            {3, 5},
            {4, 5}
    };

    static boolean available = false;
    static boolean properRounds = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < 4 ; i++) {
            available = false;
            properRounds = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            Country [] countries = new Country[6];
            for (int j = 0 ; j < 6 ; j++) {
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                countries[j] = new Country(win, draw, lose);
                if (win + draw + lose != 5) {
                    properRounds = false;
                }
            }

            if (!properRounds) {
                sb.append(0).append(" ");
                continue;
            }

            rec(countries, 0);
            if (available) {
                sb.append(1);
            } else
                sb.append(0);
            sb.append(" ");
        }

        System.out.print(sb);
    }

    static void rec(Country [] countries, int round) {
        if (round == 15) {
            available = true;
            return;
        }

        Country home = countries[rounds[round][0]];
        Country away = countries[rounds[round][1]];

        if (home.win >= 1 && away.lose >= 1) {
            home.win--;
            away.lose--;
            rec(countries, round + 1);
            home.win++;
            away.lose++;
        }
        if (home.draw >= 1 && away.draw >= 1) {
            home.draw--;
            away.draw--;
            rec(countries, round + 1);
            home.draw++;
            away.draw++;
        }
        if (home.lose >= 1 && away.win >= 1 ) {
            home.lose--;
            away.win--;
            rec(countries, round + 1);
            home.lose++;
            away.win++;
        }
    }
}
