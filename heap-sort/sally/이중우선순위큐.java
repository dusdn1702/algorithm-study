import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<Integer> pq = new ArrayList<>();

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        LinkedList<String[]> splitedOperations = new LinkedList<>();
        for (String operation : operations) {
            String[] o = operation.split(" ");
            splitedOperations.add(o);
        }
        for (String[] splitedOperation : splitedOperations) {
            if (splitedOperation[0].equals("I")) {
                pq.add(Integer.parseInt(splitedOperation[1]));
                Collections.sort(pq, Collections.reverseOrder());
            } else if (splitedOperation[0].equals("D")) {
                if (splitedOperation[1].equals("1")) {
                    if (!pq.isEmpty()) {
                        pq.remove(0);
                    }
                } else {
                    if (!pq.isEmpty()) {
                        pq.remove(pq.size() - 1);
                    }
                }
            }
        }
        if (pq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = pq.get(0);
            answer[1] = pq.get(pq.size() - 1);
        }
        return answer;
    }
}
