# 동적계획법
동적 계획법은 큰 의미에서 분할 정복과 같은 접근 방식을 의미한다. 처음 주어진 문제를 더 작은 문제들로 나눈 뒤, 각 조각의 답을 계산하고 이 답들로부터 원래 문제에 대한 답을 계산해내는 방식이다. 

동적 계획법 알고리즘의 가장 유명한 예시는 `이항 계수`의 계산이다.
nCr = n-1Cr-1 + n-1Cr

```
// 재귀 호출을 이용한 이항 계수의 계산
int bino(int n, int r){
    if (r == 0 || n == r) return 1;
    return bino(n-1, r-1) + bino(n-1, r);
```

bino(4,2)를 계산한다고 생각해보았을 때, 중복으로 호출되는 부분이 매우 많다. (Ex. bino(2,1))

따라서, 한번 계산한 값을 저장해뒀다 재활용하는 최적화기법인 메모이제이션을 활용한다.
```
int cache[30][30];
int binoWithMemo(int n, int r){
    if (r == 0 || n == r) return 1;
    if (cache[n][r] != -1) return cache[n][r];
    return cache[n][r] = binoWithMemo(n-1, r-1) + binoWithMemo(n-1,r);
```

이와 같이 두번 이상 반복 계산되는 부분 문제들의 답을 미리 저장함으로써 속도의 향상을 꾀하는 알고리즘 설계 기법을 동적 계획법이라고 한다.

## 메모이제이션 구현 패턴
```
// 전부 1로 초기화
int cache[2500][2500];

int someFunction(int a, int b){
    // 기저 사례 처리
    if(...) return ...;
    // (a,b)에 대한 답을 구한 적이 있으면 반환
    if(cache[a][b] != -1) return ...;

    // 답을 계산
    return 답;
}
```
