import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int distance[] = new int[n];
        boolean connect[][] = new boolean[n][n];
        for(int i = 0; i < edge.length; i++) {
            connect[edge[i][0] - 1][edge[i][1] - 1] = true;
            connect[edge[i][1] - 1][edge[i][0] - 1] = true;
        }
        
        Queue<Integer> queue = new LinkedList();
        queue.offer(0);
        int max = 0;
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            for(int j =1 ; j < n; j++) { //1번부터 실행하므로 2번부터 확인하도록 한다!
                if(distance[j] == 0 && connect[idx][j]) {
                    distance[j] = distance[idx] + 1; // 거리를 하나씩 늘려준다.
                    queue.offer(j);
                }
            }
        }
        
        // 거리 중 가장 큰 값을 찾는다.
        for(int i = 0; i < n; i++) {
            max = Math.max(max, distance[i]);
        }
        
        // 가장 큰 값에 해당하는 거리 개수세기
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(max == distance[i])
                answer++;
        }
        
        return answer;
    }
}
