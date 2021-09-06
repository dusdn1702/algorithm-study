import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/*
        1. 한글자만 차이나는 단어를 queue에 넣는다.
        2. queue를 poll하면서 최종 단어를 완성시킨다.
         */
public class prg_단어변환 {

    public static void main(String[] args) {
        int solution = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(solution);
    }

    static class Pair {
        String word;
        int index;

        public Pair(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    static int[] visit;
    static Queue<Pair> queue;
    static Queue<Integer> depth;

    public static int solution(String begin, String target, String[] words) {
        if (hasNotContainsTarget(target, words)) {
            return 0;
        }

        queue = new LinkedList<>();
        depth = new LinkedList<>();
        depth.offer(0);

        visit = new int[words.length];

        // begin과 한글자 차이나는 단어를 queue에 먼저 넣는다.
        findWord(begin, words, depth.poll());

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            visit[now.index] = 1;
            if (Objects.equals(target, now.word)) {
                break;
            }
            findWord(now.word, words, depth.poll());
        }

        return depth.poll();
    }

    /**
     * hot
     * dot lot
     * dog log
     * cog cog
     * -> 5가 나옴 (형제 노드 다 돌아서ㅠ)
     */

    private static void findWord(String target, String[] words, int curDepth) {
        for (int i = 0; i < words.length; i++) {
            if (visit[i] == 0 && hasSingleLetterDifference(target, words[i])) {
                visit[i] = 1;
                queue.offer(new Pair(words[i], i));
                depth.offer(curDepth + 1);
            }
        }
    }

    private static boolean hasNotContainsTarget(String target, String[] words) {
        return !Arrays.asList(words).contains(target);
    }

    private static boolean hasSingleLetterDifference(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
