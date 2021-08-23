import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Stack<Pair> temp = new Stack<>(); // 대기열
        Stack<Pair> tower = new Stack<>();
        int[] answers = new int[n];
        answers[0] = 0;

        for (int i = 1; i <= n; i++) {
            tower.push(new Pair(Integer.parseInt(st.nextToken()), i));
        }

        Pair now = tower.pop();
        while (!tower.isEmpty() || !temp.isEmpty()) {
            if (tower.isEmpty()) {
                answers[now.index - 1] = 0;
                while (!temp.isEmpty()) {
                    tower.push(temp.pop());
                }
                now = tower.pop();
                continue;
            }
            Pair next = tower.pop();
            if (now.lowerThan(next)) {
                answers[now.index - 1] = next.index;
                tower.push(next);
                while (!temp.isEmpty()) {
                    tower.push(temp.pop());
                }
                now = tower.pop();
            } else {
                temp.push(next);
            }
        }

        for (int i = 0; i < answers.length - 1; i++) {
            System.out.print(answers[i] + " ");
        }
        System.out.print(answers[answers.length - 1]);
    }

    public static class Pair {
        int height;
        int index;

        public Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }

        public boolean lowerThan(Pair other) {
            return other.height > this.height;
        }
    }
}
