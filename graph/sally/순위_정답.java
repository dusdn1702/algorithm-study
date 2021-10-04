public class 순위_정답 {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                visited[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(visited[i][j] && visited[j][k]) visited[i][k] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(visited[i][j] || visited[j][i]) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] e = {{4,2},{4,3},{3,2},{1,2},{2,5}};
        System.out.println(solution(5, e));
    }
}
