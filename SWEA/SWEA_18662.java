package SWEA;

import java.util.Scanner;

public class SWEA_18662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t < T + 1; t++) {
            int[] arr = new int[3];

            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }

            if (arr[0] + arr[2] == 2 * arr[1]) {
                System.out.println("#" + t + " " + (float)0);
                continue;
            }

            double c1 = Math.abs((arr[0] + arr[2]) / 2.0 - arr[1]);
            double c2 = Math.abs(arr[1] * 2.0 - arr[2] - arr[0]);
            System.out.println("#" + t + " " + Math.min(c1, c2));
        }
    }
}
