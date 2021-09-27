import java.util.*;

class Solution {
        public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> boat = new LinkedList<>();
        for (Integer person : people) {
            boat.offer(person);
        }

        int currWeight;
        int size = 0;
        while (!boat.isEmpty()) {
            currWeight = boat.pollLast(); // 가장 큰 값을 뽑는다.
            answer++;

            if (boat.isEmpty()) {
                break;
            }
            // 가장 큰 무게와 가장 작은 무게를 더했는데 무게 제한보다 작은 경우
            if (currWeight + boat.getFirst() <= limit) {
                boat.pollFirst();
            }
        }
        return answer;
    }
}
