class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = (brown - 2) / 2;
        int y = 1;

        while(x > y) {
            int total = x * (y + 2);
            int tmpYellow = (x-2) * y;
            if(tmpYellow == yellow && total-tmpYellow == brown) {
                answer[0] = x;
                answer[1] = y+2;
                return answer;
            }
            x--;
            y++;
        }
        return answer;
    }
}
