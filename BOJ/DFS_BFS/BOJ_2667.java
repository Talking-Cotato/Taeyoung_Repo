package BOJ.DFS_BFS;

import java.util.*;

public class BOJ_2667 {
    private static boolean[][] visited;
    private static int[][] map;
    private static int N;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static int apartCnt = 0;
    private static int[] apartArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        visited = new boolean[N][N];
        map = new int[N][N];
        apartArr = new int[N * N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 값이 1인 좌표를 찾아서 그 위치부터 dfs 시작, 단지 수 ++
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartCnt++;
                    dfs(i, j);
                    // bfs(i, j); // bfs 버전
                }
            }
        }

        // 단지 수 출력
        System.out.println(apartCnt);

        // 각 단지 내 집 수 오름차순 정렬, 한줄에 하나씩 출력
        Arrays.sort(apartArr);
        for (int a : apartArr) {
            if (a != 0) {
                System.out.println(a);
            }
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        apartArr[apartCnt]++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX > -1 && nextY > -1 && nextX < N && nextY < N) {
                if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        visited[x][y] = true;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(x);
        arrayList.add(y);
        queue.offer(arrayList);
        apartArr[apartCnt]++;

        while (!queue.isEmpty()) {
            ArrayList<Integer> arr = queue.poll();
            int curX = arr.get(0);
            int curY = arr.get(1);

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX > -1 && nextY > -1 && nextX < N && nextY < N) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        ArrayList<Integer> nextArr = new ArrayList<>();
                        nextArr.add(nextX);
                        nextArr.add(nextY);
                        queue.offer(nextArr);
                        apartArr[apartCnt]++;
                    }
                }
            }
        }
    }
}
