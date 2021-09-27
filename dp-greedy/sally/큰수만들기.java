class 큰수만들기 {
    public static String solution(String number, int k) {
        String[] numbers = number.split("");
        String result = "";
        int index = -1;
        for (int i = 0; i < numbers.length - k; i++) {
            int max = 0;
            for (int j = index + 1; j <= i + k; j++) {
                int i1 = Integer.parseInt(numbers[j]);
                if(i1 > max) {
                    max = i1;
                    index = j;
                }
                if(max == 9) break;
            }
            result += max;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }
}
