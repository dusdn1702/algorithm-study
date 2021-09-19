# 알고리즘 - 완전탐색

모든 경우의 수를 계산해 원하는 결과를 탐색하는 것

### 언제 사용하는가?

모든 경우의 수를 모두 탐색해 원하는 결과를 도출해내는 경우에 사용한다.

순열과 같이 순서가 중요해서 123,321이 다른 수인 경우가 있고, 조합과 같이 순서가 중요하지 않은 경우가 있다.

뿐만 아니라, 부분집합이 필요한 경우 즉 "123"에서 "1", "2", "3", "12", "13", "23", "123" 을 구하는 경우에도 사용할 수 있다.



### 재귀함수

자기 자신을 계속해서 호출하는 것

함수 탈출하는 조건이 확실하게 있어야 한다.

- 순열

  n개 중에 r개를 순서대로 뽑는 것(nPr)

    1. 이중 포문 사용

       ```java
       //str 배열에서 2개를 순서대로 뽑는 경우의 수 구하기
       String[] str = {"a","b","c","d","e"};
       int cnt = 0;
       for(int i = 0; i < str.length; i++) {
         for(int j = 0; j < str.length; j++) {
           if(i == j) continue;
           cnt++;
         }
       }
       ```

    2. 재귀함수 구현

       ```java
       //str 배열에서 2개를 순서대로 뽑는 경우의 수 구하기
       
       private static void result() {
             String[] str = {"a","b","c","d","e"};
           int cnt = 2;
           List<String> result = new ArrayList<>();
           
           permutation(str, isChecked, result, str.length, cnt);
       }
       
       private static void permutation(List<String> arr, List<String> result, int n, int r) {
               if (r == 0) {
                   System.out.println(result.toString());
                   return;
               }
       
               for (int i = 0; i < n; i++) {
                   result.add(arr.remove(i));
                   permutation(arr, result, n - 1, r - 1);
                   arr.add(i, result.remove(result.size() - 1));
               }
           }
       ```

- 조합

  n개 중 r개 뽑기, 순서 무관 (nCr)

    1. 이중포문 사용

       ```java
       //str 배열에서 2개를 순서대로 뽑는 경우의 수 구하기
       
       String[] str = {"a","b","c","d","e"};
       int cnt = 0;
       for(int i = 0; i < str.length; i++) {
         for(int j = i+1; j < str.length; j++) {
           if(i == j) continue;
           cnt++;
         }
       }
       ```

    2. 재귀함수 구현

       ```java
       //str 배열에서 2개를 순서대로 뽑는 경우의 수 구하기
       
       private static void result() {
             String[] str = {"a","b","c","d","e"};
           int cnt = 2;
           List<String> result = new ArrayList<>();
           
           combination(str, isChecked, result, 0, str.length, cnt);
       }
       
       private static void combination(List<String> arr, List<String> result, int index, int n, int r) {
               if (r == 0) {
                   System.out.println(result.toString());
                   return;
               }
       
               for (int i = index; i < n; i++) {
                   result.add(arr.get(i));
                   combination(arr, result, i+1, n, r-1);
                   result.remove(result.size() - 1);
               }
           }
       ```

- 부분집합

  123으로부터 1, 2, 3, 12, 13, 23, 123 얻기

    1. 체크해가며 모두 탐색해 얻기

  ```java
  private static void result() {
    String[] str = {"a","b","c","d","e"};
    boolean[] visited = new boolean[str.length];
    
    subset(str, visited, 0, str.length);
  }
  
  private static void subset(String[] arr, boolean[] visited, int index, int end) {
  // 탈출문
  		if (index >= end) {
  
  			// 현재 true로 체크되어 있는 인덱스의 값만 출력
  			for (int w = 0; w < end; w++) {
  				if (visited[w]) {
  					System.out.print(arr[w] + " ");
  				}
  			}
  			System.out.println();
  
  			return;
  		}
  
  		// "내가 없을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
  		visited[index] = false;
  		subset(arr, state, index + 1, end);
  
  		// "내가 있을 경우"를 체크한 뒤 다른 부분집합을 구하는 재귀함수 호출 (다음 인덱스로 기준 이동)
  		visited[i] = true;
  		subset(arr, state, index + 1, end);
  }
  ```

