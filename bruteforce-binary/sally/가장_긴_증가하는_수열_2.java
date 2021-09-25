import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장_긴_증가하는_수열_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> suyeol = new ArrayList<>();
        suyeol.add(0);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if(numbers[i] > suyeol.get(suyeol.size()-1)){
                suyeol.add(numbers[i]);
            } else {
                int left = 0;
                int right = suyeol.size()-1;
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(numbers[i] <= suyeol.get(mid)){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                suyeol.set(right, numbers[i]);
            }
        }
        System.out.println(suyeol.size() - 1);
    }
}
