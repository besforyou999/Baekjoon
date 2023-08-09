import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int row = 1;

        while (row * (row + 1)  < X * 2) {
            row++;
        }

        int start = (row - 1) * row / 2;
        start += 1;
        int head = row;
        int bottom = 1;

        if (row % 2 == 0) {
            head = 1;
            bottom = row;
        }

        while (start < X) {
            if (row % 2 == 0) {
                head++;
                bottom--;
            } else {
                head--;
                bottom++;
            }
            start++;
        }

        System.out.println(head + "/" + bottom);
    }
}
