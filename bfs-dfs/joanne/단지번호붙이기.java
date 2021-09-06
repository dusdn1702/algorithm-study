import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static ArrayList<Integer> arr;
    static int[][] map;
    static int[][] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                if (map[i][j] == 0) {
                    visit[i][j] = 1;
                }
            }
        }

        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(arr);

        System.out.println(arr.size());
        arr.forEach(System.out::println);
    }

    private static void bfs(int i, int j) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(i, j));
        visit[i][j] = 1;
        int numberOfHouse = 0;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            numberOfHouse += 1;

            for (int at = 0; at < 4; at++) {
                int nx = now.x + dx[at];
                int ny = now.y + dy[at];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (visit[nx][ny] == 0) {
                    visit[nx][ny] = 1;
                    queue.add(new Pair(nx, ny));
                }
            }
        }

        arr.add(numberOfHouse);
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
