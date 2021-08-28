import java.util.*;

class DiskController {
    class Job {
        int input;
        int work;

        public Job(int i, int w) {
            this.input = i;
            this.work = w;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.work));
        LinkedList<Job> tmp = new LinkedList<>();

        for (int[] j : jobs) {
            tmp.add(new Job(j[0], j[1]));
        }
        tmp.sort(Comparator.comparingInt(o -> o.input));

        int time = 0;
        int count = 0;
        while (count < jobs.length) {
            while (!tmp.isEmpty() && tmp.peek().input <= time) {
                pq.offer(tmp.poll());
            }
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                answer += job.work + (time - job.input);
                time += job.work;
                count++;
            } else {
                time++;
            }
        }
        return answer / count;
    }
}
