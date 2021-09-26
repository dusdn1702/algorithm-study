import java.util.Arrays;

class 구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int max = people.length - 1;
        int min = 0;
        for (int i = max; i >= min; i--) {
            if(people[i] + people[min] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] peo = {70, 50, 80, 40, 10};
        int lim = 100;
        System.out.println(solution(peo, lim));
    }
}
