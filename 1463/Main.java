import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[1000001];

        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2 ; i < 1000001 ; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) arr[i] = Math.min(arr[i] , arr[i/2] + 1);
            if (i % 3 == 0) arr[i] = Math.min(arr[i], arr[i/3] + 1);
        }

        System.out.println(arr[N]);

    }
}

