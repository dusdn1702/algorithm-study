## 알고리즘 - 그래프

그래프란? 정점과 간선으로 이루어진 자료구조로 간선의 가중치로 계산을 하는 경우도 있다.

- 무방향 그래프

  간선을 통해서 어느쪽으로든 갈 수 있는 그래프

- 방향 그래프

  한쪽으로만 갈 수 있는 그래프



### 언제 사용하는가?

그래프 내 최단 경로를 구하는 다익스트라, 플로이드와 같은 알고리즘

노드를 탐색하는 bfs, dfs



### in java

그래프를 만드는 방법은 구현은 dfs, bfs를 참고하면 된다.

1. 최단 경로 구하기 알고리즘

```java
class Graph{
    private int n;           //노드들의 수
    private int maps[][];    //노드들간의 가중치 저장할 변수
 
    public Graph(int n){
        this.n = n;
        maps = new int[n+1][n+1];
         
    }
    public void input(int i,int j,int w){
        maps[i][j] = w;
        maps[j][i] = w;
    }
 
    public void dijkstra(int v){
        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
         
        //distance값 초기화.
        for(int i=1;i<n+1;i++){
            distance[i] = Integer.MAX_VALUE;
        }
         
        //시작노드값 초기화.
        distance[v] =0;
        check[v] =true;
         
        //연결노드 distance갱신
        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
            }
        }
         
         
        for(int a=0;a<n-1;a++){ 
            //원래는 모든 노드가 true될때까지 인데 
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=Integer.MAX_VALUE;
            int min_index=-1;
             
            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //결과값 출력
        for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
    }
}

출처: https://bumbums.tistory.com/4 [범범스의 코딩놀이터]
```

