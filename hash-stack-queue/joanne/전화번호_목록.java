import java.util.HashMap;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hash = new HashMap<>();
        for (String phone: phone_book) {
            hash.put(phone, 0);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                // 119의 경우 1, 11이 hash에 존재하는지 확인한다.
                // 즉, 자기 자신으로부터 만들 수 있는 substring (자신 제외)이 hash의 key에 포함되어있는지 확인한다.
                if (hash.containsKey(phone_book[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }
            }
        }


        return answer;
    }
}
