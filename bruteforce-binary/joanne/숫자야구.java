import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class ac_숫자야구 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<BaseBallData> inputDatum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            inputDatum.add(
                new BaseBallData(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
            );
        }

        System.out.println(playBaseBall(inputDatum));
    }

    private static int playBaseBall(List<BaseBallData> inputDatum) {
        int answer = 0;

        // 1~9까지 서로 다른 숫자 3개
        for (int number = 123; number <= 987; number++) {
            if (hasSameOrContainsZero(number)) {
                continue;
            }

            int allCasePass = 0;
            for (BaseBallData baseBallData : inputDatum) {
                final String source = baseBallData.number;
                final String target = String.valueOf(number);
                // strike 개수 확인
                final int strike = countStrike(source, target);
                // ball 개수 확인
                final int ball = countBall(source, target);
                // baseBallData와 일치하는지 확인
                if (strike == baseBallData.strike && ball == baseBallData.ball) {
                    allCasePass++;
                } else {
                    break;
                }
            }

            if (allCasePass == inputDatum.size()) {
                answer++;
            }
        }

        return answer;
    }

    private static int countStrike(String source, String target) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (source.charAt(i) == target.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(String source, String target) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (source.charAt(i) == target.charAt((i + 1) % 3) ||
                source.charAt(i) == target.charAt((i + 2) % 3)) {
                ball++;
            }
        }
        return ball;
    }

    private static boolean hasSameOrContainsZero(int number) {
        String sNumber = String.valueOf(number);
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < sNumber.length(); i++) {
            chars.add(sNumber.charAt(i));
        }

        return chars.contains('0') || chars.size() != 3;
    }

    static class BaseBallData {

        String number;
        int strike;
        int ball;

        public BaseBallData(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
