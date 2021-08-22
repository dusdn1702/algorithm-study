# 알고리즘 - 해시

100가지의 데이터를 가지고 있다고 할때 0부터 99까지의 index를 key로 가지며 그에 따른 값을 value로 가지는 것을 의미한다.

### 해시함수란?

키를 인덱스로 변환하는 함수로 어떠한 데이터를 고정된 길이의 데이터로 매핑하는 것

- key

  매핑 전 데이터

- hash value

  매핑 후 데이터

- hash table

  해시 값 + 데이터 index

- hashing

  매핑하는 과정

### 사용하는 이유

1. 효율적인 데이터 관리

   적은 자원만으로도 많은 데이터를 효율적으로 관리할 수 있다.

2. 빠른 데이터 처리

   index에 해시값을 사용함으로써 **빠른 검색, 삽입**, 삭제 가능

### 작동방식

이름(key), 전화번호(value)인 상황에서 삽입

1. 기본적으로 배열로 미리 해시 테이블 크기만큼을 생성한다.
2. 이름을 넣으면 고유 값이 나오는 해시 함수를 만든다.
3. 이름을 해시 함수에 넣어서 고유 값을 받는다.
4. 고유 값을 주소로 하는 저장공간에 전화번호를 저장한다.

검색

1. 해시 함수에 이름을 넣고 해시 값을 받은 뒤
2. 해시 값을 주소로 하는 저장공간 찾아 읽음

### in python

- hash() 함수를 이용해 직접 해시값을 얻어낼 수도 있다. 하지만 프로그램 재시작 시 다시 같은 해시값으로 나오지 않아 활용이 어렵다.
- python에서는 Dictionary를 해시 테이블로 구현한다. 

#### python 딕셔너리

딕셔너리 자료형 {}, key:value 로 구성  

- 등록

   dict = `{1:'a', 'b':'c', 'name'=[1,2,3,hi]}`로 가능  

  입력 요소가 []안에 들어있을 때는 안에 있는 걸 리스트로 보고 element[0], element[1] 등으로 사용하면 된다.  

- 추가

  `dict[추가할 키] = 추가할 값`

- 삭제

  `del dict[삭제할 키]`

- 전체 삭제

  `dict.clear()`

- 특정 value 조회

  `dict.get(조회할 키)`

  `dict[조회할 키]`

  있는지 조사: ` 조회할 키 in dict`

- 모든 key 조회

  `list(dict.keys())` 하면 key들이 리스트로, 안하면 dict_keys 객체로

- 모든 Value 조회

  `list(dict.values())` 하면 value들이 리스트로, 안하면 dict_values 객체로

- 모든 key, value 쌍 조회

  `dict.items()` 하면 쌍을 튜플로 묶은 값을 dict_items 객체로 돌려준다. 위처럼 List로 묶어서도 사용할 수 있다.

- defaultdict(자료형)

  기본값 자료형(list, set, int는 0)으로 정의되어 비어있어도 에러 안남

- enumerate 

  인덱스 번호와 항목 연결 `for p in enumerate([1,2,3,4])`: 하면 (0,1)(1,2)(2,3)(3,4)가 됨  

- zip 

  동일한 개수의 두 자료형을 묶어줌

  list로 만들 경우 ; numbername=list(zip(number,name))

  dictionary로 만들 경우 ; for number, name in zip(number, name): dic[number]=name  

[참고](https://davinci-ai.tistory.com/19)

## 문제풀이
[프로그래머스 - 전화번호 목록](https://programmers.co.kr/learn/courses/30/lessons/42577?language=python3#)  
[풀이](https://dusdn1702.github.io/algorithms/63)  
