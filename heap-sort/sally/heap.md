---
title: "알고리즘 분류별 공부"
excerpt: "힙"
permalink: /algorithms/65

categories:
- algorithms
  tags:
- algorithms
- java


---

# 알고리즘 - 힙

최솟값, 최댓값을 빠르게 찾아내기 위해 완전이진트리 형태로 만들어진 자료구조

완전이진트리란? 모든 노드의 최대 차수가 2인 트리로 마지막 레벨을 제외한 모든 노드가 채워져 있으면서 왼쪽부터 채워지도록 하는 트리

힙은 부모 노드가 항상 자식 노드보다 우선순위가 높도록 하는 조건으로 트리를 채워나간다. 따라서 루트 노드가 가장 우선순위가 높은 노드가 된다.

1. 힙에 추가하기

   - 들어온 값을 배열의 마지막에 넣는다.

   - 부모와 비교해 (자식 값 / 2) 우선순위가 더 작으면 냅두고 크면 위치를 바꾼다.

   - 계속 부모와 비교해가며 올바른 트리가 될 때까지 위치를 바꿔간다.

![image](https://user-images.githubusercontent.com/43775108/131214152-3f1585cb-0757-498b-83be-34315c8fffb0.png)


2. 힙에서 삭제하기

   - 삭제하고자 하는 요소를 삭제하고, 힙의 마지막 노드를 루트로 가지고 온다.

   - 힙에 추가할 때처럼 값을 바꿔가며 올바른 트리의 형태를 찾는다.

![image](https://user-images.githubusercontent.com/43775108/131214276-bbcf77cb-cdc7-4909-bfe0-efb01aa569d5.png)

## 언제 사용하나?

삽입/삭제가 트리 구조로 O(logN)으로 매우 빠르다.

따라서, 최소 값이나 최대 값을 빨리 찾아야 할 때 사용하면 좋다.

크기를 미리 알 수 없는 경우에 얼마나 개수가 많을지 모를 때 사용하면 좋다.

## in java

- PriorityQueue 라이브러리 사용

```java
import java.util.PriorityQueue;

PriorityQueue<Element> priorityQueue = new PriorityQueue<>();    //등록, Collections.reversOrder() 시 최대 힙, 오름차순 정렬 시 최대 힙 구현

priorityQueue.add(E e);     // priorityQueue 값 추가, 성공하면 true, 공간 없으면 IllegalStateException
priorityQueue.offer(E e);   // priorityQueue 값 추가
priorityQueue.poll(); // priorityQueue 첫번째 값 반환하고 제거, 비어있으면 null
priorityQueue.remove(); // priorityQueue 첫번째 값 제거
priorityQueue.peek(); // priorityQueue 첫번째 값 참조
priorityQueue.clear();  // priorityQueue 초기화
```

- 배열을 이용한 직접 구현

0번째 인덱스는 편한 구현을 위해 사용하지 않는다.

1번째부터 시작하면 인덱스의 자식 노드는 `*2`, `*2+1` 이다.

- 배열 정렬

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

Collections.sort(list); //오름차순
Collections.sort(list, Collections.reverseOrder()); //내림차순
```

## in python

- Heapq 라이브러리 사용

```python
import heapq

heapq.heappush(heap, item)	# heap에 item 추가
heapq.heappop(heap)  # heap에서 가장 작은 원소를 삭제하고 반환
heapq.heapify(list)  # list를 heap으로 변환

# 최대 힙 만들기 과정
max_heap = []
for item in heap_items:
  heapq.heappush(max_heap, (-item, item))

  
```

