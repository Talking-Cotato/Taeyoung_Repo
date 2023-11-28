package BOJ.ARRAY;

import java.util.Scanner;

public class BOJ_10813 {
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
            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;
        }

        for (int n = 1; n <= N; n++) {
            System.out.print(basket[n] + " ");
        }
    }
}
