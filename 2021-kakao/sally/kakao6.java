class kakao6 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        return answer;
    }
}

//행렬 게임 맵
//건물의 내구도 나타내는 board
//적의 공격이나 아군의 회복 능력 나타내는 skill환 [type(1은 공격 내구도--, 2는 회복 내구도++), r1, c1, r2, c2, degree] (r1, c1)부터 (r2, c2)까지 degree만큼 -/+
//1이상 되면 파괴되지 않음
//적의 공격이나 아군의 회복이 끝난 후 파괴되지 않은 건물의 개수 반
//입출력 예
//board	skill	result
//[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]	[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]	10
//[[1,2,3],[4,5,6],[7,8,9]]	[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]	6
