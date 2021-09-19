import java.util.Arrays;

class 입국심사 {
    private int[] arr;
    long answer = 0;
    long all = 0;

    public long solution(int n, int[] times) {
        all = n;
        arr = times;
        Arrays.sort(arr);

        long min = 0;
        long max = (long) arr[arr.length - 1] * n;

        return binarySearch(min, max);
    }

    long binarySearch(long low, long high) {
        while(low <= high) {
            long mid = (low + high) / 2;
            long done = 0;
            for (int j : arr) {
                done += mid / j;
            }
            if(done < all) {
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
