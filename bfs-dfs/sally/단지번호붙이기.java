import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {
    static int[][] map;
    static int[][] visited;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int cnt = 0;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                visited[i][j] = 0;
            }
        }

        calculate();

        System.out.println(result.size());
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }
    }


    private static void calculate() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    cnt = 0;
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }
    }

    private static void dfs(int startx, int starty) {
        cnt++;
        visited[startx][starty] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = startx + dx[i];
            int ny = starty + dy[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

