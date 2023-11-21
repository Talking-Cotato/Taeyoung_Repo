package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1984 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 1; t < T + 1; t++) {

            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr);
            double sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }

            System.out.println("#" + t + " " + (int) Math.round(sum / 8));
        }
    }
}
