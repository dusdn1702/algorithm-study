class kakao4 {
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        while(true) {
            int total = 0;
            for(int i = 0; i < info.length; i ++) {
                int peach = info[i];

            }
            break;
        }

        return answer;
    }
}
//양궁
//라이언과 어피치 중에 그 점수에 더 많이 맞춘 사람이 이김
//라이언이 이기고 싶은데 그러면 어떻게 맞춰야 하는지?
//활 개수 들어오고, 어피치가 맞춘 것 10~0까지 들어옴
//10~0까지 어떻게 맞춰야 할가?
//절대 못이기면 -1

//입출력 예
//    n	info	result
//    5	[2,1,1,1,0,0,0,0,0,0,0]	[0,2,2,0,1,0,0,0,0,0,0]
//    1	[1,0,0,0,0,0,0,0,0,0,0]	[-1]
//    9	[0,0,1,2,0,1,1,1,1,1,1]	[1,1,2,0,1,2,2,0,0,0,0]
//    10	[0,0,0,0,0,0,0,0,3,4,3]	[1,1,1,1,1,1,1,1,0,0,2]
