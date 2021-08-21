import java.util.*;

class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] c : clothes) {
            String key = c[1];
            String value = c[0];
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                List<String> emptyList = new ArrayList<>();
                emptyList.add(value);
                map.put(key, emptyList);
            }
        }

        for (String key : map.keySet()) {
            final List<String> values = map.get(key);
            answer *= (values.size() + 1);
        }

        return answer - 1;
    }
}