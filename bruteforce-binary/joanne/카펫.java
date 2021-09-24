class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int garo, sero;
        int garoSeroSum = (brown + 4) / 2;
        
        for (int i = garoSeroSum - 1; i > 1; i--) {
            garo = i;
            sero = garoSeroSum - i;
            
            if ((garo * sero) - brown == yellow) {
                answer[0] = garo;
                answer[1] = sero;
                break;
            }
        }   
        return answer;
    }
}
