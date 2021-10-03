import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    public static int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visit = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        return bfs(graph, visit);
    }

    private static int bfs(List<List<Integer>> graph, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        int distance = 0;
        while (true) {
            List<Integer> adjList = new ArrayList<>();
            while(!queue.isEmpty()){
                int now = queue.poll();
                for (int number : graph.get(now)) {
                    if(!visit[number]) {
                        adjList.add(number);
                        visit[number] = true;
                    }
                }
            }
            if(adjList.isEmpty()) break;
            for (int number : adjList) {
                queue.add(number);
            }
            distance = adjList.size();
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] e = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(6, e));
    }
}
