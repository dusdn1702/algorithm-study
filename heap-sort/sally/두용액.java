import java.io.*;
import java.util.Arrays;

public class 두용액 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(list);
        int[] result = calculate(list, N);

        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] calculate(int[] list, int n) {

    }
}
