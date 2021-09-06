import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] map;
    static int[][] count;
    static boolean[][] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        count = new int[n][m];
        visit = new boolean[n][m];
        visit[0][0] = true;
        count[0][0] = 1;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        dfs(0, 0, 1);
        int answer = count[n - 1][m - 1];
        if (answer == 0) answer = -1;
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int breakSquare) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        if (x == n - 1 && y == m - 1) return;

        for (int at = 0; at < 4; at++) {
            int nx = x + dx[at];
            int ny = y + dy[at];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (!visit[nx][ny] && map[nx][ny] == 0) {
                visit[nx][ny] = true;
                count[nx][ny] = count[x][y] + 1;
                dfs(nx, ny, breakSquare);
                visit[nx][ny] = false;
            }

            if (breakSquare == 1 && !visit[nx][ny] && map[nx][ny] == 1) {
                visit[nx][ny] = true;
                count[nx][ny] = count[x][y] + 1;
                dfs(nx, ny, --breakSquare);
                ++breakSquare;
                visit[nx][ny] = false;
            }
        }
    }
}
