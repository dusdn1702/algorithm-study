
# 알고리즘 - 정렬

정렬의 알고리즘은 다양하다.

## 선택정렬

값을 찾아 정렬하는 것

1. 인덱스 0부터 가장 작은 값을 찾는다.

2. 가장 작은 값을 찾으면 그 값을 현재 인덱스와 바꾼다.

3. 반복한다.

```java
public void selectionSort(List<Integer> numbers) {
    for(int i = 0; i < numbers.size() - 1; i++) {
        int tmp = i;
        for (int j = i + 1; j < numbers.size()l j++) {
            if(numbers[tmp] >= numbers[j]) {
                tmp = j;
            }
        }
        swap(a, tmp, i);
	}
}
private static void swap(List<Integer> a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}
```

### 언제 사용하는가?

메모리 소비가 적어 메모리 효율을 줄여야하는 경우에 사용한다.

O(N^2)의 시간복잡도이다.

## 삽입정렬

현재 위치에서 그 이하의 배열들을 비교해 자신이 들어갈 위치를 찾아 그 위치에 삽입하는 배열 알고리즘

1. 두번째 인덱스부터 시작해 그 값과 그 이전의 값들을 비교해 더 작은 것을 앞에 둔다.

2. 뒤로 쭉 가면서 앞에것들과 비교해 알맞은 자리에 삽입한다.

```java
public void insertionSort(List<Integer> numbers) {
    for(int i = 1; i < numbers.size(); i++) {
        int tmp = numbers[i];
        int j = i - 1;

        while(j >= 0 && tmp < numbers[j]) {
            numbers[j+1] = numbers[j];
            j--;
        }

        a[j+1] = tmp;
	}
}
```

### 언제 사용하는가?

메모리 소비가 작아 메모리 효율을 높여야 할 때 사용할 수 있다.

거의 정렬된 경우 효율적(O(N))이지만 최악은 O(N^2)

## 버블 정렬

연속된 두개의 인덱스를 비교하며 정한 기준의 값을 뒤로 넘겨 정렬

1. 인덱스 0부터 바로 다음의 인덱스와 지금의 인덱스를 비교한다.

2. 지금의 인덱스가 다음의 인덱스보다 크면 바꾼다.

3. 이렇게 쭉 바꿔간다.

```java
public void bubbleSort(List<Integer> numbers) {
    for(int i = 1; i < numbers.size(); i++) {
        for (int j = 0; j < numbers.size()-1; j++) {
            if(numbers[j+1] < numbers[j]) {
                swap(numbers, j, j+1);
            }
        }
	}
}
private static void swap(List<Integer> a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}
```

### 언제 사용하는가?

메모리 소비가 작아 메모리 효율을 높일 때 사용한다.

구현이 쉽지만 시간이 많이 소요되므로 주의해야 한다.

## 합병 정렬

분할 정복이 들어간 방식으로 리스트를 분할해가며 최대한 작게 쪼개진 시점에서 인접한 원소끼리 비교하여 정렬

1. 리스트를 절반으로 나눈다.

2. 리스트의 길이가 1이 아니라면 계속 나눈다.

3. 나눠진 리스트끼리 정렬하고 합쳐간다.

```java
private static void merge(int[] a, int left, int mid, int right) {
	int l = left;
	int r = mid + 1;
	int idx = left;
	
	while(l <= mid && r <= right) {
		if(a[l] <= a[r]) {
			sorted[idx] = a[l];
			idx++;
			l++;
		} else {
			sorted[idx] = a[r];
			idx++;
			r++;
		}
	}
		
	if(l > mid) {
		while(r <= right) {
			sorted[idx] = a[r];
			idx++;
			r++;
		}
	} else {
		while(l <= mid) {
			sorted[idx] = a[l];
			idx++;
			l++;
		}
	}
	
	for(int i = left; i <= right; i++) {
		a[i] = sorted[i];
	}
}
```

### 언제 사용하나?

비교적 짧은 시간 O(NlogN)에 해결되는 알고리즘이다.

메모리 사용량이 많다.

## 퀵 정렬

기준값(pivot)을 두고 부분리스트로 나누어 기준값보다 작은 값들의 부분리스트, 큰 값들을 부분리스트로 두고 그 안에서 또 기준값 잡아서 비교해가며 정렬

1. 기준값 선택

2. 기준값을 기준으로 큰값과 작은값 찾아서 교환

3. 왼쪽과 오른쪽에서 시작한게 만날때까지 반복해서 교환한다.

4. 부분리스트에서 1-3 반복

[참고](https://st-lab.tistory.com/250)

## 라이브러리에서 제공하는 정렬

### 배열

```java
Arrays.sort(arr); //오름차순
Arrays.sort(arr,Collections.reverseOrder()); //내림차순
Arrays.sort(arr, 0, 4); //arr의 0부터 4개만 정렬
```

```java
Collections.sort(list); //오름차순
Collections.sort(list, Collections.reverseOrder()); //내림차순
```

```java
list.sort(Comparator.comparingInt(o -> o.value))    //객체 o의 value를 기준으로 비교
```

```java
class People implements Comparable {
    private int age; 

    public People(int age) {
        this.age = age;
    }

    //직접 객체 내 비교 함수 오버라이딩 하는 방법
    @Override
    public int compareTo(People people) {
         if (this.age < people.age) {
             return -1;
         } else if (this.age == people.age) {
             return 0;
         } else {
             return 1;
         }
     }
}
```
