import java.util.ArrayDeque;
import java.util.Deque;

class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nowWeight = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int truck : truck_weights) {
            while (true) {
                if (deque.isEmpty()) { // 다리 위에 트럭이 없을 때
                    deque.offer(truck);
                    answer++;
                    nowWeight += truck;
                    break;
                }

                if (deque.size() == bridge_length) { // 다리 위의 트럭의 개수가 bridge_length와 동일할 때
                    nowWeight -= deque.poll();
                }

                if (nowWeight + truck > weight) {
                    deque.offer(0); // 아무 트럭도 올리지 않음.
                    answer++;
                } else {
                    deque.offer(truck);
                    nowWeight += truck;
                    answer++;
                    break;
                }
            }
        }

        return answer + bridge_length; // 첫번째 올라간 트럭이 다 지나가려면 bridge_length 만큼의 시간이 더해져야한다.
    }
}