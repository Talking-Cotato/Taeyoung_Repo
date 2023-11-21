package SWEA;

import java.util.Scanner;

public class SWEA_15941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 90도일때 가장 넓은 평행사변형 -> 정사각형
        int T = sc.nextInt();
        for (int t = 1; t < T + 1; t++) {
            int N = sc.nextInt();
            System.out.println("#" + t + " " + (N * N));
        }
    }
}
