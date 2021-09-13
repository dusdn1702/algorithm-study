import java.util.ArrayList;
import java.util.List;

class kakao2 {
    public int solution(int n, int k) {
        int answer = 0;
        String converted = convert(n, k);
        StringBuffer sb = new StringBuffer(converted);
        converted = sb.reverse().toString();

        String[] splited = sp(converted);

        for (String str : splited) {
            int i = Integer.parseInt(str);
            if(i > 1) {
                answer += findPrime(i);
            }
        }

        return answer;
    }

    private String[] sp(String converted) {
        List<String> str = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < converted.length(); i++) {
            if(converted.charAt(i) == '0') {
                String substring = converted.substring(index, i);
                if(substring.length() >= 1){
                    str.add(substring);
                }
                index = i +1;
            }
        }
        str.add(converted.substring(index, converted.length()));

        return str.toArray(new String[0]);
    }

    private int findPrime(int parseInt) {
        for (int i = 2; i < parseInt; i++) {
            if (parseInt % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    private String convert(int num, int n) {
        StringBuilder result = new StringBuilder();
        if (num == 0) {
            return "0";
        }

        while (num > 0) {
            int mok = num / n;
            int nameoji = num % n;
            if (nameoji > 9) {
                result.append((char) (nameoji + 55));
            } else {
                result.append(nameoji);
            }
            num = mok;
        }
        return result.toString();
    }

}

