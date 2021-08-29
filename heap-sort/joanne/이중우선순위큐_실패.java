import java.util.Arrays;
import java.util.Objects;


// 실패.......
public class 이중우선순위큐_실패 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
//        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
//        System.out.println(Arrays.toString(solution(new String[]{"I 4", "I -1", "I 6", "I 3"})));
//        System.out.println(Arrays.toString(solution(new String[]{"I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1"})));
//        System.out.println(Arrays.toString(solution(new String[]{"I 5", "I 5", "D 1", "I 7", "D -1", "I 8"})));
        System.out.println(Arrays.toString(solution(new String[]{"D 1", "D -1", "I 0", "I -1", "I 0"})));
    }

    public static int[] solution(String[] operations) {

        int[] pq = new int[1_000_001];
        int index = 0;
        int size = 0;
        int height = 1;

        for (String op : operations) {
            String[] operation = op.split(" ");
            if (Objects.equals(operation[0], "I")) {
                pq[++index] = Integer.parseInt(operation[1]);
                sort(pq, ++size);
            }
            if (size > 0 && Objects.equals(operation[0], "D")) {
                if (Objects.equals(operation[1], "1")) {
                    int lastValue = pq[index];
                    pq[index] = 0;
                    pq[1] = lastValue;
                    sort(pq, --size); // 다시 최대로 정렬해준다.
                } else {
                    pq[index] = 0;
                    --size;
                }
                --index;
            }
        }

        if (size == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{pq[1], pq[index]};
        }
    }

    private static void sort(int[] pq, int size) {
        int target = size;

        if (size == 1) {
            return;
        }

        while (target > 1) {
            int nowNode = pq[target];
            int parentNode = pq[target / 2];

            if (parentNode < nowNode) {
                pq[target] = parentNode;
                pq[target / 2] = nowNode;
                target /= 2;
            } else {
                break;
            }
        }
    }
}
