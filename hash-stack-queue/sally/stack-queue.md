# 알고리즘 - 스택

항아리에 넣는 것처럼 가장 먼저 들어간 것이 가장 늦게 나오는 자료구조

한쪽 끝에서만 자료를 넣고 뺄 수 있는 LIFO 구조이다.

주로 연결리스트로 구현할 수 있고 배열과 다르게 인덱스로 접근할 수 없지만 배열처럼 앞에 들어가면 하나씩 뒤로 밀어줄 필요가 없어 넣고 빼기 쉽다.

### 사용하는 이유

- 뒤로 가기

- 실행 취소

- 재귀 알고리즘

  재귀를 돌 때 임시 데이터를 스택에 넣어주고 백트래킹 할때는 임시 데이터 빼주는 반복 행위에 사용

- 역순 문자열 만들기

- 올바른 괄호 검사

- 후위 표기법 계산

### 작동방식

1. 빈 리스트(나 다른 자료형)가 있다.[]
2. a를 넣는다. push [a]
3. b, c, d push [a, b, c, d]
4. 하나를 뺀다. Pop [a, b, c]

### in python

파이썬에서는 리스트 자료형을 스택으로 사용할 수 있다.

#### list

- 리스트 등록

  `data = []`

- 데이터 삽입

  `.append(데이터)` 하면 리스트 제일 뒤에 삽입

  `.insert(1, 'a') ` 하면 인덱스 1에 'a' 삽입

- 데이터 삭제

  `.pop()` 하면 리스트 제일 뒤 요소가 삭제

- 제일 마지막 데이터 반환

  `data[-1]`

- 슬라이싱

  `data[1:4]` 하면 두번째부터 4-1인 네번째까지

- 컴프리헨션

  `array = [i for i in range(20) if i % 2 == 1] [i*i for i in range(1, 10)]`

- 정렬

  `data.sort()` 기본은 오름차순

  내림차순은 `data.sort(reverse=True)`

- 뒤집기

  `data.reverse()`

- 갯수 세기 

  `data.count()`

## 문제풀이

[백준 - 탑](https://www.acmicpc.net/problem/2493)  
[풀이](https://dusdn1702.github.io/algorithms/63)  

### heapq 사용
- import

  ```py
  import heapq
  ```

- 등록

  리스트를 힙으로 전환 

  ```py
  heapq.heapify(리스트이름)
  ```

- 삽입

  ```py
  heapq.heappush(리스트이름, 요소)
  ```

- 삭제

가장 작은 항목 삭제하고 반환

  ```py
  heapq.heappop(리스트이름)
  ```

요소 푸시하고 가장 작은 항목 삭제하고 빤환

  ```py
  heapq.heappushpop(리스트이름, 요소)
  ```

가장 작은 항목 삭제하고 반환, 요소 삽입

  ```py
  heapq.heapreplace(리스트이름, 요소)
  ```

# 알고리즘 - 큐

먼저 집어넣는 데이터가 먼저 나오는 자료구조 FIFO

데이터의 앞부분을 front, 뒷부분을 rear라고 한다.

주로 연결리스트로 구현하며 반대 방향에서 삽입, 삭제가 가능하도록 한다.

### 사용하는 이유

- BFS 너비우선탐색

  처리해야 할 노드의 리스트 저장 용도

  노드를 하나 처리할 때마다 그 노드와 인접한 노드들을 큐에 다시 저장

  접근 순서대로 처리하기 용이

- 캐시

- 우선순위

### 작동방식

1. 빈 리스트(나 다른 자료형)가 있다.[]
2. a를 넣는다. enqueue [a]
3. b, c, d enqueue [a, b, c, d]
4. 하나를 뺀다. dequeue [b, c, d]

### in python

스택과 마찬가지로 list를 사용하여 구현할 수 있다.

하지만 스택과 달리 Pop이 아닌 dequeue를 하려면 리스트를 첫번째 요소부터 슬라이싱하거나

삭제할 데이터인 첫번째 요소를 data[0]으로 찾아 `remove(삭제할데이터)` 해도 된다.

#### priority queue

우선순위 큐는 추가는 어떤 순서로 해도 상관 없지만 제거할때는 가장 작은 값을 제거해야 한다.

힙정렬을 이용하기 위해 파이썬 내부에서는 heapq 모듈을 사용한다.

- import

  ```py
  from queue import PriorityQueue
  ```

- 등록

  `que = PriorityQueue()`

  `que = PriorityQueue(maxsize=10)`으로 사이즈 등록도 가능

- 삽입

  `que.put(요소)`

  `que.put((1, 'z'))`, `que.put((2, 'a'))` 과 같이 (우선순위, 값)을 튜플로 삽입하면 우선순위 순으로 원소가 정렬될 수 있다.

- 삭제

  `que.get()` 하면 가장 작은 원소가 나오고, 그게 삭제된 것이다.

#### deque  

추가적으로 양끝에서 인덱싱 없이 사용하는 덱도 파이썬에서 구현할 수 있다. 인덱싱과 슬라이싱이 안된다.

하지만 시간복잡도 O(1)로  list보다 빠르다.

- import  `from collections import deque`

- 가장 뒤 원소 삽입 `append()` 
- 가장 뒤 원소 삭제 `pop()`
- 가장 앞 원소 추가 `appendleft()`
- 가장 앞 원소 삭제 `popleft()  `

## 문제풀이

[백준 - 가장 큰 수](https://www.acmicpc.net/problem/2075)  
[풀이](https://dusdn1702.github.io/algorithms/62)  
