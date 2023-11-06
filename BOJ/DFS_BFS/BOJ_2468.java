package BOJ.DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2468 {
    static int N;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] okArea;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;    // 최대 높이
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(max, map[i][j]);
            }
        }
        sc.close();

        // 안전한 영역 개수 담을 배열 생성
        okArea = new int[max];

        // 0부터 max - 1까지 잠기게 하면서 확인
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        okArea[i]++;
                        // dfs 버전
                        dfs(j, k, i);

                        // bfs 버전
//                        bfs(j, k, i);
                    }
                }
            }
            // 매 높이마다 visited 배열 초기화
            visited = new boolean[N][N];
        }

        // 안전한 영역 개수 최댓값 출력
        Arrays.sort(okArea);
        System.out.println(okArea[okArea.length - 1]);

    }

    static void dfs(int x, int y, int max) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > -1 && nx < N && ny > -1 && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] > max) {
                    dfs(nx, ny, max);
                }
            }
        }
    }

    static void bfs(int x, int y, int max) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curP = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curP[0] + dx[i];
                int ny = curP[1] + dy[i];

                if (nx > -1 && nx < N && ny > -1 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] > max) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
