import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 모음사전 {
    class Solution {
        List<String> alphabet = List.of("A", "E", "I", "O", "U");
        List<String> all = new ArrayList<>();

        public int solution(String word) {
            int answer = 0;
            for (int i = 0; i < alphabet.size(); i++) {
                dfs(0, "", i + 1);
            }
            Collections.sort(all);
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).equals(word)) {
                    answer = i + 1;
                    break;
                }
            }
            return answer;
        }

        void dfs(int depth, String s, int len) {
            System.out.println(s);
            if (len == depth) {
                all.add(s);
                return;
            }
            for (int i = 0; i < 5; i++) {
                dfs(depth + 1, s + alphabet.get(i), len);
            }
        }
    }
}
