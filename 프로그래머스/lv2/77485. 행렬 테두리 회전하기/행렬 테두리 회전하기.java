import java.util.*;

class Solution {

    int [][] matrix;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        buildMatrix(rows, columns);

        for (int i = 0 ; i < queries.length ; i++) {
            int [] query = queries[i];
            answer[i] = execute_query(query);
        }

        return answer;
    }

    public void buildMatrix(int rows, int columns) {
        matrix = new int[rows + 1][columns + 1];

        for (int r = 1 ; r < rows + 1 ; r++)
            for (int c = 1; c < columns + 1; c++)
                matrix[r][c] = (r - 1) * columns + c;
    }

    public int execute_query(int [] query) {
        int r1 = query[0];
        int c1 = query[1];
        int r2 = query[2];
        int c2 = query[3];

        int min_value = 10001;

        ArrayList<Coord> coords = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0 ; i <= c2 - c1 ; i++) {
            coords.add(new Coord(r1, c1 + i));
            queue.add(matrix[r1][c1 + i]);
            min_value = Math.min(min_value, matrix[r1][c1 + i]);
        }

        for (int i = 0 ; i < r2 - r1 ; i++) {
            coords.add(new Coord(r1 + 1 + i, c2));
            queue.add(matrix[r1 + 1 + i][c2]);
            min_value = Math.min(min_value, matrix[r1 + 1 + i][c2]);
        }

        for (int i = 1 ; i <= c2 - c1 ; i++) {
            coords.add(new Coord(r2, c2 - i));
            queue.add(matrix[r2][c2 - i]);
            min_value = Math.min(min_value, matrix[r2][c2 - i]);
        }

        for (int i = 1 ; i < r2 - r1 ; i++) {
            coords.add(new Coord(r2 - i, c1));
            queue.add(matrix[r2 - i][c1]);
            min_value = Math.min(min_value, matrix[r2 - i][c1]);
        }

        int tail = queue.pollLast();
        queue.addFirst(tail);

        for (Coord coord : coords) {
            matrix[coord.r][coord.c] = queue.pollFirst();
        }

        return min_value;
    }


}

class Coord {
    int r, c;
    Coord (int r, int c) {
        this.r = r;
        this.c = c;
    }
}