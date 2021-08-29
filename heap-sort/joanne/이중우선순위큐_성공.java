import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class 이중우선순위큐_성공 {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (String op : operations) {
            String[] operation = op.split(" ");

            if (operation[0].equals("I")) {
                maxHeap.add(Integer.parseInt(operation[1]));
                minHeap.add(Integer.parseInt(operation[1]));
            }

            if (operation[0].equals("D")) {
                if (!maxHeap.isEmpty()) {
                    if (operation[1].equals("1")) {
                        int max = maxHeap.peek();
                        maxHeap.remove(max);
                        minHeap.remove(max);

                    } else {
                        int min = minHeap.peek();
                        maxHeap.remove(min);
                        minHeap.remove(min);
                    }
                }
            }

        }
        if (!maxHeap.isEmpty()) {
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }
        return answer;
    }
}
