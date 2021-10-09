import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class 상호평가 {
    public String solution(int[][] scores) {
        String answer = "";
        for (int i = 0; i < scores.length; i++) {
            List<Integer> one = new ArrayList<>();
            for (int j = 0; j < scores.length; j++) {
                one.add(scores[j][i]);
            }
            Collections.sort(one);
            int max = one.get(one.size() - 1);
            if (max == scores[i][i]) {
                one.remove(one.size() - 1);
                if (one.contains(max)) {
                    one.add(max);
                }
            }
            int min = one.get(0);
            if (min == scores[i][i]) {
                one.remove(0);
                if (one.contains(min)) {
                    one.add(min);
                }
            }
            int total = 0;
            for (int number : one) {
                total += number;
            }
            int avg = total / one.size();
            if (avg >= 90) {
                answer += "A";
            } else if (avg >= 80 && avg < 90) {
                answer += "B";
            } else if (avg >= 70 && avg < 80) {
                answer += "C";
            } else if (avg >= 50 && avg < 70) {
                answer += "D";
            } else answer += "F";
        }
        return answer;
    }
}
