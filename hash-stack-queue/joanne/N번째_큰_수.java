import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째_큰_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 우선순위 큐의 크기를 N으로 유지하면서 삽입/삭제를 반복한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // 첫번째로 n개를 채운다.
            pq.offer(Integer.parseInt(st.nextToken()));
            System.out.println(pq.peek());
        }

        for (int i = 1; i < n; i++) { // 1번째줄부터 읽어들인다.
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                System.out.println(pq.peek());
                if (pq.peek() < number) {
                    pq.poll();
                    pq.offer(number);
                }
            }
        }

        System.out.println(pq.peek());
    }
}
