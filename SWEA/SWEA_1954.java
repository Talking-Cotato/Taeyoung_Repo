package SWEA;

import java.util.Scanner;

public class SWEA_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int T = sc.nextInt();
        for (int tc = 1; tc < T + 1; tc++) {
            int N = sc.nextInt();
            System.out.println("#" + tc);

            int[][] map = new int[N][N];

            int x = 0;
            int y = 0;

            int direction = 0;
            for (int i = 1; i <= N * N; i++) {
                map[x][y] = i;

                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    direction++;
                    if (direction >= 4) {
                        direction = 0;
                    }
                    x = x + dx[direction];
                    y = y + dy[direction];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
