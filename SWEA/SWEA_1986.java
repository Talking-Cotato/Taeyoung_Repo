package SWEA;

import java.util.Scanner;

public class SWEA_1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t < T + 1; t++) {
            int N = sc.nextInt();

            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) {
                    sum -= i;
                } else {
                    sum += i;
                }
            }

            System.out.println("#" + t + " " + sum);
        }
    }
}
