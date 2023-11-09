package SWEA;

import java.util.Scanner;

public class SWEA_1979 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();

        for (int t = 1; t < tc + 1; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] map = new int[n][n];

            int kCnt = 0;
            int blank = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = scanner.nextInt();
                    if (map[i][j] == 1) {
                        blank++;
                    } else {
                        if (blank == k) {
                            kCnt++;
                        }
                        blank = 0;
                    }
                }
                if (blank == k) {
                    kCnt++;
                }
                blank = 0;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[j][i] == 1) {
                        blank++;
                    } else {
                        if (blank == k) {
                            kCnt++;
                        }
                        blank = 0;
                    }
                }
                if (blank == k) {
                    kCnt++;
                }
                blank = 0;
            }

            System.out.println("#" + t + " " + kCnt);
        }

    }
}
