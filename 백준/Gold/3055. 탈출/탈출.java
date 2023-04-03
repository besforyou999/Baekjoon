import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char [][] mat;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mat = new char[R][C];

        ArrayDeque<Node> water = new ArrayDeque<>();
        ArrayDeque<Node> animal = new ArrayDeque<>();

        for (int r = 0 ; r < R ; r++) {
            String line = br.readLine();
            for (int c = 0 ; c < C ; c++) {
                mat[r][c] = line.charAt(c);
                if (mat[r][c] == 'S') {
                    animal.add(new Node(mat[r][c], r, c, 0));
                } else if (mat[r][c] == '*') {
                    water.add(new Node(mat[r][c], r, c, 0));
                }
            }
        }

        int result = bfs(water, animal);

        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }

    }

    static int bfs(ArrayDeque<Node> water, ArrayDeque<Node> animal) {

        while (!(water.isEmpty() && animal.isEmpty())) {
            int size = water.size();

            while(size-- > 0) {
                Node node = water.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = node.r + dr[i];
                    int nc = node.c + dc[i];
                    if (isIn(nr, nc)) {
                        if (mat[nr][nc] == '.' || mat[nr][nc] == 'S') {
                            mat[nr][nc] = '*';
                            water.add(new Node(node.ch, nr, nc, node.cnt));
                        }
                    }
                }
            }

            size = animal.size();

            while(size-- > 0) {
                Node node = animal.poll();

                for (int i = 0 ; i < 4 ; i++) {
                    int nr = node.r + dr[i];
                    int nc = node.c + dc[i];
                    if (isIn(nr, nc)) {
                        if (mat[nr][nc] == '.') {
                            mat[nr][nc] = 'S';
                            animal.add(new Node(node.ch, nr, nc, node.cnt + 1));
                        } else if (mat[nr][nc] == 'D') {
                            return node.cnt + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < R && c >= 0 && c < C);
    }
}


class Node {
    char ch;
    int r, c, cnt;
    Node(char letter, int r, int c, int cnt) {
        this.ch = letter;
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}