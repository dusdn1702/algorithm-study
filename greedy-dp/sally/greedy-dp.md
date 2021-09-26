## 알고리즘 - Greedy

탐욕 알고리즘은 경우를 선택할 때 그 순간의 최선의 경우를 선택해가는 알고리즘이다.



### 언제 사용하는가?

그때 그때 선택을 하기 때문에 성능이 빨라야 하는 경우에 사용한다.

이전의 선택이 이후에 영향을 주지 않는 경우, 부분의 최선이 합쳐져 전체의 최선이 되는 경우에 사용한다.



### in java

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
Collections.sort(list);


list.get(list.size()-1);
```

위와 같이 정렬을 해서 그때 그때 최소/최대값을 찾거나 문제에 따라 알맞는 최선의 값을 구한다.
