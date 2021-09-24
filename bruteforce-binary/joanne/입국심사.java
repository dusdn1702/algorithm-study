import java.util.*;
class Solution {
        public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long totalCounts = 0;
            for (int i = 0; i < times.length; i++) {
                totalCounts += mid / times[i];
            }
            
            if (totalCounts < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
