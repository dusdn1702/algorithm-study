public class 타겟넘버 {
    int answer = 0;
    boolean[] visited;

    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        int sum = 0;
        dfs(numbers, 0, target, sum);
        return answer;
    }

    private void dfs(int[] numbers, int index, int target, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        sum += numbers[index];
        dfs(numbers, index + 1, target, sum);
        sum -= numbers[index];

        sum += (numbers[index] * -1);
        dfs(numbers, index + 1, target, sum);
    }
}
