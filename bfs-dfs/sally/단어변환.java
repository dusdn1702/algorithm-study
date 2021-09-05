// 풀이
// words와 같은 사이즈의 boolean을 생성한다.
// words를 돌면서 begin과 글자수가 다른 것을 찾고, 그걸 visited 변경하고 거기서부터 또 같은 것을 재귀로 찾아간다.
// begin == target이 되면 리턴

class 단어변환 {
    int answer = 0;
    boolean visited[];

    public int solution(String begin, String target, String[] words) {
        int count = words.length;
        visited = new boolean[count];

        dfs(begin, target, words, 0);
        return answer;
    }

    private void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (findSame(begin, words[i]) + 1 == begin.length()) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    private int findSame(String begin, String word) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == word.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
