import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(solutions);

        int[] answers = new int[2];
        int i = 0, j = N-1, minSum = Integer.MAX_VALUE;
        while (i < j) {
            int sum = solutions[i] + solutions[j];
            int temp = sum;
            if (temp < 0) {
                temp *= -1;
            }
            if (temp < minSum) {
                minSum = temp;
                answers[0] = solutions[i];
                answers[1] = solutions[j];
            }

            if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println(answers[0] + " " + answers[1]);
    }
}
