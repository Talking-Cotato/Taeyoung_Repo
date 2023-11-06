package BOJ.DFS_BFS;

import java.util.*;

public class BOJ_1697 {

    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 수빈
        K = sc.nextInt();   // 동생
        sc.close();

        System.out.println(bfs(N));
    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드를 1로 표시
        visited[node] = 1;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int X = queue.poll();

            // 동생을 찾았다면 return
            if (X == K) {
                // 시작점을 1로 표시하므로 -1 해서 return
                return visited[X] - 1;
            }

            // 앞으로 걷기
            if (X - 1 >= 0 && visited[X - 1] == 0) {
                visited[X - 1] = visited[X] + 1;
                queue.offer(X - 1);
            }

            // 뒤로 걷기
            if (X + 1 <= 100000 && visited[X + 1] == 0) {
                visited[X + 1] = visited[X] + 1;
                queue.offer(X + 1);
            }

            // 순간이동
            if (X * 2 <= 100000 && visited[X * 2] == 0) {
                visited[X * 2] = visited[X] + 1;
                queue.offer(X * 2);
            }
        }

        // 예외
        return -1;
    }
}