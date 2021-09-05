public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (check[i] == 0) {
                dfs(computers, i, check);
                answer++;
            }
        }

        return answer;
    }

    int[] dfs(int[][] computers, int i, int[] check) {
        check[i] = 1;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && check[j] == 0) {
                check = dfs(computers, j, check);
            }
        }

        return check;
    }
}
