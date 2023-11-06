package BOJ.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 상, 하, 앞, 뒤, 좌, 우 (6가지 방향)
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, -1, 1};
        int[] dz = {-1, 1, 0, 0, 0, 0};

        // 안 익은 토마토 개수, 토마토가 익을 때까지 걸리는 일 수
        int noRipeTomatoCnt = 0;
        int day = 0;

        int M = sc.nextInt();   // 상자 가로줄
        int N = sc.nextInt();   // 상자 세로줄
        int H = sc.nextInt();   // 상자

        boolean[][][] visited = new boolean[H][N][M];
        int[][][] box = new int[H][N][M];
        Queue<int[]> tomato = new LinkedList<>();

        // 상자에 토마토 넣기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();

                    // 안 익은 토마토 개수 세기
                    if (box[i][j][k] == 0) {
                        noRipeTomatoCnt++;
                    }

                    // 익은 토마토면 큐에 넣기(bfs)
                    else if (box[i][j][k] == 1) {
                        // k가 x(가로), j가 y(세로), i가 z(상하)
                        tomato.offer(new int[]{k, j, i});
                        // 방문처리
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        sc.close();

        // 안 익은 토마토가 없으면 0
        if (noRipeTomatoCnt == 0) {
            System.out.println(0);
            return;
        }

        // 토마토 익히기 (bfs)
        while (!tomato.isEmpty()) {
            int[] curP = tomato.poll();
            int cx = curP[0];
            int cy = curP[1];
            int cz = curP[2];

            // 6가지 방향 다 가보기
            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                // 범위를 넘어가면 진행 x
                if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1 || nz < 0 || nz > H - 1) {
                    continue;
                }

                // 방문한 적 없고, 익지 않은 토마토라면
                if (!visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
                    // 토마토 익히기
                    noRipeTomatoCnt--;

                    // 다음 자리 값을 현재 자리 값 + 1로 (익는 일자 + 1)
                    box[nz][ny][nx] = box[cz][cy][cx] + 1;
                    day = box[nz][ny][nx];

                    // 큐에 넣고 방문처리
                    tomato.offer(new int[]{nx, ny, nz});
                    visited[nz][ny][nx] = true;
                }
            }
        }

        // 익힐 수 있는 토마토 다 익혔는데도 안익은 토마토가 남아있으면 -1
        // (토마토가 모두 익지는 못하는 상황)
        if (noRipeTomatoCnt != 0) {
            System.out.println(-1);
            return;
        }

        // 익는 데 걸리는 일수 출력
        System.out.println(day - 1);
    }
}