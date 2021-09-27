import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {
    public static int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new HashSet<>());
        }
        for (int i = 0; i < 8; i++) {
            int num = 0;
            for (int j = 0; j < i + 1; j++) {
                num += Math.pow(10, j)*N;
            }
            list.get(i).add(num);

            for (int j = 0; j < i; j++) {
                for (int op1 : list.get(j)) {
                    for (int op2 : list.get(i - j - 1)) {
                        list.get(i).add(op1 + op2);
                        list.get(i).add(op1 - op2);
                        list.get(i).add(op1 * op2);
                        if(op2 != 0) list.get(i).add(op1 / op2);
                    }
                }
            }

            if(list.get(i).contains(number)){
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }
}
