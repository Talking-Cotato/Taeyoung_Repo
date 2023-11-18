package SWEA;

import java.util.Scanner;

public class SWEA_2005 {
    static int[][] arr = new int[10][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        pascal();

        int T = sc.nextInt();

        for (int tc = 1; tc < T + 1; tc++) {
            int N = sc.nextInt();

            System.out.println("#" + tc);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void pascal(){
        arr[0][0] = 1;

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i-1][j];
                } else if (j > 0 && j < i) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                } else if (j == i) {
                    arr[i][j] = arr[i-1][j-1];
                }
            }
        }
    }
}
