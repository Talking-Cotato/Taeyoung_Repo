package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178{
    static int[][] maze;
    static int N;
    static int M;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] option = scanner.nextLine().split(" ");
        N = Integer.parseInt(option[0]);
        M = Integer.parseInt(option[1]);

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            // 현재 좌표 위치
            int[] curP = queue.poll();
            int curX = curP[0];
            int curY = curP[1];

            // 네 가지 방향으로 모두 가보기
            for (int i = 0; i < 4; i++) {
                // 다음 위치 후보군
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 미로 좌표 범위를 넘어서면 continue
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                // 이미 방문한 좌표거나, 갈 수 없는 좌표(0)라면 continue
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }

                queue.offer(new int[]{nextX, nextY});
                maze[nextX][nextY] = maze[curX][curY] + 1; //지나온 자리라고 표시
                visited[nextX][nextY] = true;
            }
        }
    }
}