package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2573 {

    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int yearCnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        while (true) {
            // 얼음 개수 세기
            int result = iceCnt();
            visited = new boolean[N][M];

            // 빙하가 2개 이상 - 처음부터 2개 이상이면 0
            if (result >= 2) {
                System.out.println(yearCnt);
                break;
            }
            // 다 녹았으면 0
            else if (result == 0) {
                System.out.println(0);
                break;
            }

            // 녹이고 1년 ++
            melt();
            yearCnt++;
        }

    }

    // 얼음 녹이기
    static void melt() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curP = queue.poll();
            int seaCnt = 0;

            for (int i = 0; i < 4; i++) {
                int nx = curP[0] + dx[i];
                int ny = curP[1] + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    seaCnt++;
                }
            }

            if (map[curP[0]][curP[1]] > seaCnt) {
                map[curP[0]][curP[1]] -= seaCnt;
            } else {
                map[curP[0]][curP[1]] = 0;
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }
    }

    // 얼음 개수 세기
    static int iceCnt() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 바닷물이 아니고, 방문한 적 없을 때
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
