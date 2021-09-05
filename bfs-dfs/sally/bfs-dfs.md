# 알고리즘 - BFS/DFS

많은 양의 데이터 중에서 원하는 데이터를 찾는 탐색의 대표적인 알고리즘

- 재귀함수

  자기 자신을 계속 호출하기 위함. 종료 조건을 꼭 명시해야한다.

  반복문 대신 재귀 함수를 사용했을 때 재귀 함수가 더 간결해 이해가 쉽다.



## DFS

깊이 우선 탐색으로 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘

노드와 간선으로 표현되는 그래프이다.

- 그래프

    - 인접 행렬

      2차원 배열로 그래프의 연결관계 표현

      노드 개수가 많을수록 불필요한 메모리 낭비

![image](https://user-images.githubusercontent.com/43775108/132096497-96c3c664-cc83-4387-88bc-20ba49f35bfb.png)

- 인접 리스트

  링크드리스트로 그래프의 연결관계 표현

  연결된 정보만 저장해 메모리 효율적 사용, 정보 조회 느림

  ![image](https://user-images.githubusercontent.com/43775108/132096505-d520d792-6810-4d1d-89b2-4682bbcf3332.png)

### 언제 사용하는가?

구현은 BFS에 비해 좀 더 간단하지만 속도 자체는 느리다.

시간 복잡도는 인접리스트 `O(V+E)` , 인접행렬 `O(V^2)`

### 동작 방식

1. 탐색 시작 노드를 스택에 넣고 방문 처리

2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접노드를 차례로 스택에 넣고 방문처리

   인접한 노드가 여러개인 경우 더 작은 노드를 먼저 방문

   방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드 팝

3. 모든 노드 방문할 때까지 1, 2 반복

### in java

```java
//재귀함수

class Graph {
  private int count;
  private LinkedList<Integer> adj[];
  
  public Graph (int count){
    count = count;
    adj = new LinkedList[count];
    for (int i = 0; i < count; ++i) {
      adj[i] = new LinkedList();
    }
  }
  
  public void addEdge(int n1, int n2) {
    adj[n1].add(n2);
  }
  
  public void dfs(int startNode) {
    boolean visited[] = new boolean[count];
    for (int i = 0; i < count; ++i) {
      if(visited[i] == false){
        visitNode(i, visited);
      }
    }
  }
  
  public void visitNode(int node, boolean visited[]) {
    visited[node] = true;
    
    Iterator<Integer> iter = adj[node].listIterator();
    while (iter.hasNext()) {
      int node = iter.next();
      if(!visited[node]) {
        visitNode(node, visited);
      }
    }
  }
}
```



## BFS

가까운 노드부터 탐색하는 너비 우선 탐색 알고리즘

- 큐 사용

  인접한 노드를 반복적으로 큐에 넣으면 먼저 들어온 것이 먼저 나가게 되어 가까운 노드부터 탐색 가능


### 언제 사용하는가?

BFS의 구현이 DFS 보다 더 빠르게 동작한다.

최단 경로나 임의의 경로를 찾고 싶을 때 사용

### 동작 방식

1. 탐색 시작 노드를 큐에 넣어 방문 처리
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
   인접 노드를 방문하기 위해 4방향으로 움직이는 배열을 선언하는 것이 일반적
3. 반복

### in java

이중배열로 map과 visited를 생성한다.

큐에 시작 값을 넣고 큐가 빌때까지 아래를 반복한다.

map의 경우에는 실제 들어온 값들을 가지고 있고, visited는 false나 최댓값으로 정해둔다.

지나가게 되면 그곳을 true나 distance로 설정해 큐에 넣는다.

지나가는 것은 상하좌우로 엣지를 찾아서 큐에 넣어가며 진행한다.

```java
//Queue

class Graph {
  private int count;
  private LinkedList<Integer> adj[];
  
  public Graph (int count){
    count = count;
    adj = new LinkedList[count];
    for (int i = 0; i < count; ++i) {
      adj[i] = new LinkedList();
    }
  }
  
  public void addEdge(int n1, int n2) {
    adj[n1].add(n2);
  }
  
  public void bfs(int startNode) {
    boolean visited[] = new boolean[count];
    LinkedList<Integer> queue = new LinkedList<>();
    
    visited[startNode] = true;
    queue.add(startNode);
    
    while(queue.size() != 0) {
      startNode = queue.poll();
      Iterator<Integer> iter = adj[node].listIterator();
      while (iter.hasNext()) {
        int node = iter.next();
        if(!visited[node]) {
          visited[node] = true;
          queue.add(node);
        }
      }
    }
  }
}
```

