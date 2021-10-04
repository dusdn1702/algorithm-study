import java.util.*;

public class 순위 {
    public static int solution(int n, int[][] results) {
        List<List<Integer>> winning = new ArrayList<>();
        List<List<Integer>> losing = new ArrayList<>();

        winning.add(0, null);
        losing.add(0, null);
        for (int i = 1; i <= n; i++) {
            winning.add(i, new ArrayList<>());
            losing.add(i, new ArrayList<>());
        }
        for (int i = 0; i < results.length; i++) {
            winning.get(results[i][0]).add(results[i][1]);
            losing.get(results[i][1]).add(results[i][0]);
        }

        return calculate(winning, losing);
    }

    private static int calculate(List<List<Integer>> winning, List<List<Integer>> losing) {
        int n = winning.size() -1;

        List<Integer> fix = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int wins = winning.get(i).size();
            int loses = losing.get(i).size();
            if(wins + loses == n-1) {
                fix.add(loses+1);   //등수
            }
        }

        if(fix.contains(n-1) && !fix.contains(n)) {
            fix.add(n);
        }
        if(fix.contains(2) && !fix.contains(1)) {
            fix.add(1);
        }
        Collections.sort(fix);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(!fix.contains(i)) {
                cnt++;
            }
        }

        if(cnt == 1) return fix.size() + 1;
        return fix.size();
    }

    public static void main(String[] args) {
        int[][] e = {{4,2},{4,3},{3,2},{1,2},{2,5}};
        System.out.println(solution(5, e));
    }
}
