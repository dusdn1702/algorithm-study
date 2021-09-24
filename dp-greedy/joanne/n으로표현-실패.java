import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class prg_N으로표현 {

    private int answer = -1;

    public int solution(int N, int number) {
        dfs(0, 0, number, N);
        return answer;
    }

    private void dfs(int cnt, int value, int target, int n) {
        // 기저 사례
        if (cnt > 8) {
            return;
        }
        if (value == target) {
            if (answer > cnt || answer == -1) answer = cnt;
            return;
        }

        // nn = 5, 55, 555 ... , 55555555
        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dfs(cnt + 1 + i, value + nn, target, n);
            dfs(cnt + 1 + i, value - nn, target, n);
            dfs(cnt + 1 + i, value * nn, target, n);
            dfs(cnt + 1 + i, value / nn, target, n);
        }
    }

    @Test
    public void 테스트() {
        assertEquals(solution(5, 12), 4);
    }
}
