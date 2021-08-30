import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 수묶기 {
    /**
     * 1. 0과 1은 묶지 않는다.
     * 2. 음수와 양수를 분리한다.
     * 3. 음수가 1개인 경우 묶지 않는다.
     * * 음수가 1개인데 0이 있는 경우 0과 묶는다.
     * 4. 양수는 큰수부터 정렬한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean hasZero = false;

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number < 0) {
                negative.add(number);
            } else {
                if (number == 1) {
                    answer += number;
                } else if (number == 0) {
                    hasZero = true;
                } else {
                    positive.add(number);
                }
            }
        }

        negative.sort(Comparator.naturalOrder()); // -3, -2, -1
        positive.sort(Comparator.reverseOrder()); // 9, 8, 7

        answer = getAnswer(answer, negative);
        answer = getAnswer(answer, positive);

        if (negative.size() == 1 && !hasZero) {
            answer = postProcess(answer, negative);
        }
        answer = postProcess(answer, positive);

        System.out.println(answer);
    }

    private static int postProcess(int answer, List<Integer> list) {
        while (!list.isEmpty()) {
            answer += list.remove(0);
        }
        return answer;
    }

    private static int getAnswer(int answer, List<Integer> list) {
        int i = 0;
        while (list.size() > 1) {
            int first = list.remove(i);
            int second = list.remove(i);
            answer += (first * second);
        }
        return answer;
    }
}
