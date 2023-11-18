package SWEA;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_2001 {

    static int[][] map;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();
        for (int t = 1; t < tc + 1; t++) {
            N = scanner.nextInt();
            M = scanner.nextInt();

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            System.out.println("#" + t + " " + killMax());
        }
    }

    static int killMax() {
        //n - m + 1만큼 새 배열을 만들어야
        int arrSize = N - M + 1;
        LinkedList<Integer> compare = new LinkedList<>();

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                 compare.add(sum(i,j));
            }
        }

        Collections.sort(compare);

        return compare.get(arrSize * arrSize - 1);
    }

    static int sum(int x, int y) {
        int sum = 0;

        for (int i = x; i < x + M; i++) {
            for (int j = y; j < y + M; j++) {
                sum += map[i][j];
            }
        }

        return sum;
    }
}
