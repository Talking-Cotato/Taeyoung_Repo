package BOJ.ARRAY;

import java.util.Scanner;

public class BOJ_10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            basket[n] = n;
        }

        for (int n = 0; n < M; n++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            while (i < j) {
                int temp = basket[i];
                basket[i] = basket[j];
                basket[j] = temp;
                i++;
                j--;
            }
        }

        /*for (int n = 0; n < M; n++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            for (int m = 0; m <= j - i; m++) {
                int temp = basket[i];
                for (int l = i; l < j - m; l++) {
                    basket[l] = basket[l + 1];
                }
                basket[j - m] = temp;
            }
        }*/

        for (int n = 1; n <= N; n++) {
            System.out.print(basket[n] + " ");
        }
    }
}
