package BOJ.DFS_BFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
    static boolean[] visited;
    static LinkedList<Integer>[] adjacent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        visited = new boolean[N + 1];
        adjacent = new LinkedList[N + 1];

        // 배열 원소 하나하나마다 인접 리스트가 들어가니까 초기화
        for (int i = 0; i < adjacent.length; i++) {
            adjacent[i] = new LinkedList<>();
        }

        // 간선 연결 추가
        for (int i = 0; i < M; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            adjacent[n1].add(n2);
            adjacent[n2].add(n1);
        }

        // 인덱스 작은 순서대로 방문할 것이기 때문에 정렬
        for (LinkedList<Integer> integers : adjacent) {
            Collections.sort(integers);
        }

        dfsR(V);
        System.out.println();

        // dfs 이후이기 때문에 visited 배열 초기화 필요
        visited = new boolean[N + 1];
        bfs(V);

        scanner.close();
    }

    static void dfsR(int index) {
        visited[index] = true;
        System.out.print(index + " ");    // index 그대로 출력하면 됨(어차피 시작 노드의 경우 값이랑 인덱스랑 같다)
        for (int i : adjacent[index]) {
            if(!visited[i]){
                dfsR(i);
            }
        }
    }

    static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        visited[index] = true;
        queue.offer(index);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int a : adjacent[n]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.offer(a);
                }
            }
            System.out.print(n + " ");
        }
    }
}
