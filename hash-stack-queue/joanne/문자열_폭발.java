import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

public class 문자열_폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < origin.length(); i++) {
            stack.push(origin.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean hasBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    // stack에 포함된 맨 뒤 bomb 자릿수만큼만 확인하기 위함.
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        hasBomb = false;
                        break;
                    }
                }
                if (hasBomb) {
                    IntStream.range(0, bomb.length()).forEach(j -> stack.pop());
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        System.out.println(answer.length() > 0 ? answer.toString() : "FRULA");
    }
}
