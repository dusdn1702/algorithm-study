import java.util.Iterator;
import java.util.LinkedList;

class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        LinkedList<Integer> map[];

        map = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (computers[i][j] == computers[j][i] && computers[j][i] == 1) {
                    map[i].add(j);
                }
            }
        }

        boolean visited[] = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i);
            answer++;
        }

        while (!queue.isEmpty()) {
            int visiting = queue.poll();
            Iterator<Integer> iter = map[visiting].listIterator();
            while (iter.hasNext()) {
                Integer next = iter.next();
                if (visited[next] == false) {
                    visited[next] = true;
                    queue.add(next);
                    answer--;
                }
            }
        }
        return answer;
    }
}
