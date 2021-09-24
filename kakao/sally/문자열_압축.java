class 문자열_압축 {
    public int solution(String s) {
        int answer = s.length();
        if (answer == 1) return answer;

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder tmp = new StringBuilder();
            int cnt = 1;//aabbcc
            String begin = s.substring(0, i);//aa
            for (int j = i; j < s.length(); j += i) {
                String emd = s.substring(i);//bbcc
                String substr = emd.substring(0, begin.length());
                if (begin.equals(substr)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        tmp.append(begin);//aabbcc
                        System.out.println("쌓아논거 하나: " + tmp);
                        begin = substr;
                    } else {
                        tmp.append(cnt).append(begin);//2aabbcc
                        System.out.println("쌓아논거 하나: " + tmp);
                        begin = substr;
                        cnt = 1;
                    }
                }
                if (i + j >= s.length()) {
                    if (cnt == 1) {
                        System.out.println("뒤로 더 갈게 없는데 쌓아온 것도 없: " + tmp);
                        tmp.append(s.substring(j));
                        break;
                    } else {
                        System.out.println("뒤로 더 갈게 없는데 쌓아온게 있: " + tmp);
                        tmp.append(cnt).append(begin);
                        break;
                    }
                }
            }
            if (tmp.length() < answer) {
                return tmp.length();
            }
        }
        return answer;
    }
}
