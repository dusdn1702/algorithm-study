import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = calculate(list, N);

        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] calculate(int[] list, int n) {
        Arrays.sort(list);
        int j = n - 1;
        int i = 0;
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        while (i < j) {
            int sum = list[i] + list[j];
            int abs = Math.abs(sum);
            if (abs < min) {
                min = abs;
                answer[0] = list[i];
                answer[1] = list[j];
            }
            if (sum < 0) {
                i++;
            } else if (sum > 0) {
                j--;
            } else {
                answer[0] = list[i];
                answer[1] = list[j];
                return answer;
            }
        }
        return answer;
    }
}
