import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수_묶기 {
    static List<Integer> numbers = new ArrayList<>();
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(numbers);
        System.out.println(calculate(numbers));
    }

    private static int calculate(List<Integer> numbers) {
        Integer lastMinus = getLastMinus(numbers);
        return calculateMinus(numbers, lastMinus) + calculatePlus(numbers, lastMinus);

    }

    private static int calculatePlus(List<Integer> numbers, Integer lastMinus) {
        int plus = 0;
        if(numbers.get(lastMinus + 1) == 0) {
            lastMinus +=1;
            if((size - lastMinus) % 2 == 1) {
                lastMinus += 1;
                plus+=numbers.get(lastMinus);
            }
            for (int i = lastMinus + 1; i < size-1; i += 2) {
                plus += numbers.get(i) * numbers.get(i + 1);
            }
        } else{
            if((size - lastMinus) % 2 == 1) {
                lastMinus += 1;
                plus+=numbers.get(lastMinus);
            }
            for (int i = lastMinus + 1; i < size-1; i += 2) {
                plus += numbers.get(i) * numbers.get(i + 1);
            }
        }
        return plus;
    }

    private static int calculateMinus(List<Integer> numbers, Integer lastMinus) {
        int minus = 1;
        if((lastMinus - 1) % 2 == 0) {
            for (int i = 0; i <= lastMinus; i++) {
                minus *= numbers.get(i);
            }
        } else{
            for (int i = 0; i < lastMinus; i++) {
                minus *= numbers.get(i);
            }
            minus += numbers.get(lastMinus);
        }
        return minus;
    }

    private static Integer getLastMinus(List<Integer> numbers) {
        for (int i = 0; i < size; i++) {
            if(numbers.get(i) >= 0) {
                return i-1;
            }
        }
        return size;
    }
}
