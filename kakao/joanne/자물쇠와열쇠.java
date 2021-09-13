// 도저히 짧은 시간 내에 못풀겠어서 해당 게시글의 코드를 학습하였습니다.
// https://moonsbeen.tistory.com/90
// 이후 다시 풀어서 새로운 코드로 업로드하겠습니당 ㅠㅠㅠㅠ

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1;     
        for(int x = 0; x < point + lock.length; x++) { //이동 거리는 열쇠와 자물쇠가 처음으로 겹치는 부분 + 자물쇠의 크기이다.
            for(int y = 0; y < point + lock.length; y++) {
                //key를 회전한다.
                for(int r = 0; r < 4; r++) {
                    int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2]; //확장한 lock배열 생성
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            newLock[i + point][j + point] = lock[i][j]; //확장할 lock배열(arr) 초기화
                        }
                    }
                    match(newLock, key, r, x, y);  //newLock배열에 key배열을 더해준다
                    if(check(newLock, point, lock.length)) return true; //자물쇠 영역이 모두 유효한 값인지 확인
                }
            }
        }
        return false;
    }
    
    public void match(int[][] newLock, int[][] key, int rot, int x, int y) {
        int len = key.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(rot == 0) { //한 번도 회전하지 않았을 때
                    newLock[x + i][y + j] += key[i][j];
                } else if(rot == 1) { //시계방향으로 90도 회전한 경우
                    newLock[x + i][y + j] += key[j][len - i - 1];
                } else if(rot == 2) { //180도 >회전<한 경우 (뒤집은 거랑은 다름)
                    newLock[x + i][y + j] += key[len - i - 1][len- j - 1];
                } else { //270도 회전한 경우 == 반시계 방향으로 90도 회전한 경우
                    newLock[x + i][y + j] += key[len - j - 1][i];
                }
            }
        }
    }
    
    public boolean check(int[][] newLock, int point, int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(newLock[point + i][point + j] != 1) return false;
            }
        }
        return true;
    }
}
