import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] array = new int[A];
        int index = 0;
        for (int i = 0; i < A; i++) {
            final int number = Integer.parseInt(stringTokenizer.nextToken());
            if (number > array[index]) {
                array[++index] = number;
            } else if (number < array[index]) {
                final int lowerBound = lower_bound(number, array, index + 1);
                if (lowerBound > index) {
                    array[++index] = number;
                }
                array[lowerBound] = number;
            }
        }
        System.out.println(index);
    }

    private static int lower_bound(int number, int[] array, int size) {
        int left = 1;
        int right = size; // size

        while (left < right) {
            int mid = (left + right) / 2;
            int now = array[mid];

            if (number <= now) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
