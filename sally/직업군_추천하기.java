import java.util.*;

public class 직업군_추천하기 {
    class Solution {
        public String solution(String[] table, String[] languages, int[] preference) {
            String answer = "";
            Map<String, Integer> result = new HashMap<>();
            for (String part : table) {
                List<String> skills = Arrays.asList(part.split(" "));
                String job = skills.get(0);
                int score = 0;
                for (int i = 1; i < skills.size(); i++) {
                    for (int j = 0; j < languages.length; j++) {
                        if (languages[j].equals(skills.get(i))) {
                            int value = skills.size() - i;
                            score += preference[j] * value;
                            break;
                        }
                    }
                }
                result.put(job, score);
            }
            int max = result.values().stream().max(Integer::compareTo).get();
            List<String> r = new ArrayList<>();
            for (Map.Entry<String, Integer> e : result.entrySet()) {
                if (e.getValue() == max) r.add(e.getKey());
            }
            if (r.size() == 1) {
                return r.get(0);
            }
            Collections.sort(r);
            return r.get(0);
        }
    }

}
