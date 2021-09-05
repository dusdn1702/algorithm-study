import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽_부수고_이동하기 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Edge{
        int y;
        int x;
        int distance;
        int crashingCount;

        public Edge(int y, int x, int distance, int crashingCount) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.crashingCount = crashingCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        N = Integer.parseInt(s1[0]);
        M = Integer.parseInt(s1[1]);

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        int answer = bfs(0, 0);

        System.out.println(answer);
    }

    public static int bfs(int startX, int startY) {
        LinkedList<Edge> queue = new LinkedList<>();

        queue.add(new Edge(startY, startX, 1, 0));
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            if (e.y == N - 1 && e.x == M - 1) {
                return e.distance;
            }
            for (int i = 0; i < 4; i++) {
                int ny = e.y + dy[i];
                int nx = e.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
                    if(visited[ny][nx] > e.crashingCount) {
                        if(map[ny][nx] == 0) {
                            visited[ny][nx] = e.crashingCount;
                            queue.add(new Edge(ny, nx, e.distance + 1, e.crashingCount));
                        } else {
                            if (e.crashingCount == 0) {
                                visited[ny][nx] = e.crashingCount + 1;
                                queue.add(new Edge(ny, nx, e.distance + 1, e.crashingCount + 1));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
