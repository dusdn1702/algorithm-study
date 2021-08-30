import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<Job> waitList = new LinkedList<>();
        for (int[] job : jobs) {
            waitList.offer(new Job(job[0], job[1]));
        }
        waitList.sort(Comparator.comparingInt(o -> o.requestTime));
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.workingTime));

        int now = waitList.peek().requestTime;
        int count = 0;

        while (count < jobs.length) {
            while (!waitList.isEmpty() && waitList.peek().requestTime <= now) {
                jobQueue.offer(waitList.poll());
            }

            if (jobQueue.isEmpty()) {
                now = waitList.peek().requestTime;
                continue;
            }

            Job job = jobQueue.poll();
            answer += (job.workingTime + (now - job.requestTime));
            now += job.workingTime;
            count++;
        }

        return answer / count;
    }

    class Job {
        int requestTime;
        int workingTime;

        public Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }
}