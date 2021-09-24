import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 숫자야구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<OneCount> allInputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String three = input[0];
            int strike = Integer.parseInt(input[1]);
            int ball = Integer.parseInt(input[2]);
            allInputs.add(new OneCount(three, strike, ball));
        }

        int answer = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i==j) continue;
                for (int k = 1; k <= 9; k++) {
                    if(i==k || j==k) continue;
                    boolean flag = true;
                    for(OneCount oneCount : allInputs){
                        String hundred = Integer.toString(i);
                        String ten = Integer.toString(j);
                        String one = Integer.toString(k);
                        if(!oneCount.isMatching(hundred + ten + one)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static class OneCount {
        String three;
        int strike;
        int ball;

        public OneCount(String three, int strike, int ball) {
            this.three = three;
            this.strike = strike;
            this.ball = ball;
        }

        public boolean isMatching(String str) {
            int s = 0;
            int b = 0;
            if(three.charAt(0) == str.charAt(0)) s++;
            if(three.charAt(1) == str.charAt(1)) s++;
            if(three.charAt(2) == str.charAt(2)) s++;
            if(three.charAt(0) == str.charAt(1) || three.charAt(0) == str.charAt(2)) b++;
            if(three.charAt(1) == str.charAt(0) || three.charAt(1) == str.charAt(2)) b++;
            if(three.charAt(2) == str.charAt(0) || three.charAt(2) == str.charAt(1)) b++;
            return strike == s && ball == b;
        }
    }
}
