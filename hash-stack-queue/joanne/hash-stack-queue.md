## 해시
### 해시 테이블
해시 테이블은 hash function을 사용해 주어진 key 값을 hash 값으로 매핑하고, 이 해시값을 index로 하여금 value를 key와 함께 저장하는 자료구조이다.

예를 들어, `hash function := mod 3`이라고 해보자. 그러면 주어진 key에 대한 value 쌍은 다음과 같다.  

|key|hash value|
|------|---|
|1|1|
|2|2|
|3|0|
|4|1|

하지만 위의 예시에서 확인할 수 있듯이, key가 1, 4일때의 value 값이 동일한 것을 확인할 수 있다. 이렇게 서로 다른 key가 같은 해시값을 가지는 상황을 `hash collision`이라고 한다. 

### 해시 충돌
해시 충돌이 발생했을 때엔 어떻게 해결할 수 있을까? 우선, `Chaining` 방식이 존재한다.
즉, 같은 해시값을 갖는 key의 경우 해당 해시값에 대해 연결 리스트로서 값을 저장하는 것이다.

![chaining](https://media.vlpt.us/images/adam2/post/ca25f031-e6a7-4ef0-8a82-6cf5a25a4153/image.png)

이렇게 구현할 경우 한정된 저장소를 효율적으로 사용할 수 있으며, 해시 함수를 어떻게 선택하든 연결하기만 하면 모든 값들을 해시화할 수 있기 때문에 해시 함수의 선택 중요성을 낮출 수 있다. 하지만 한 값에 여러 자료들이 연결된다면 검색 효율이 낮아질 수 있다.

두번째로는 `Open Addressing` 방법이 존재한다.
![open addressing](https://media.vlpt.us/images/adam2/post/a0880019-83ec-44b2-ae32-67ab4d536445/image.png)

이 방법은 비어있는 해시값을 찾아 데이터를 저장하는 기법이다. 즉, 충돌이 발생할 경우 그 다음 비어있는 해시값에 해당 값을 저장하는 것이다. 그 과정에서 다음 비어있는 값을 찾아갈 때의 규칙에는 여러가지가 존재한다.

* 선형 탐색
![linear probing](https://media.vlpt.us/images/adam2/post/f62536c5-bcf9-4d33-82f8-f6a1cd3973b6/image.png)
* 제곱 탐색  
![quadratic probing](https://media.vlpt.us/images/adam2/post/45c9c1da-429a-41f4-af83-95f1e54f2369/image.png)

마지막으로는 `이중 해싱` 방법이 존재한다.
즉, 동일한 해시값이 나온 경우에는 또다른 해시 function을 적용해 다른 값을 얻어내는 것이다.
예를 들어, 첫번째 `hash function := mod 3`이면, 두번째 `hash function := mod 4`와 같이 연쇄적으로 해시를 적용하는 것이다. 

### hash function
그렇다면, 해시 함수는 어떻게 결정할 수 있을까?  

* division method  
숫자로 된 키를 해시 테이블의 크기로 나눈 나머지를 해시값으로 결정  
* multiplication method  
key를 k, A는 0~1사이의 실수일 때, `h(k) = (kA mod 1)*m`  
* universal hashing  
다수의 해시함수를 만들고, 이 해시함수의 집합 H에서 무작위로 해시함수를 선택해 해시값을 만드는 기법 

---

## 스택

스택은 LIFO 즉, 나중에 들어온 값이 먼저 빠져나가는 구조로서 아래가 막혀있는 어떠한 물체와도 같다. 즉, 한쪽 끝에서만 자료를 넣고 뺄 수 있되 가장 먼저 빠지는 자료는 가장 나중에 들어온 자료인 것이다. 스택에서는 가장 상단에 있는 데이터를 Top 이라고 부른다.

![stack](https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Data_stack.svg/1200px-Data_stack.svg.png)

### Java에서의 Stack
```
Stack<Element> stack = new Stack<>();

public Element push(Element item); // 데이터 추가
public Element pop(); // 최근에 추가된(Top) 데이터 삭제
public Element peek(); // 최근에 추가된(Top) 데이터 조회
public boolean empty(); // stack의 값이 비었는지 확인, 비었으면 true, 아니면 false
public int seach(Object o); // 인자값으로 받은 데이터의 위치 반환
```

---

## 큐

큐는 스택과 반대로 FIFO(First In First Out) 구조를 가진다. 즉, 가장 먼저 들어온 데이터가 가장 먼저 나가는 구조를 말한다.

![queue](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile24.uf.tistory.com%2Fimage%2F9929C0495C932BB1153D55)

```
public boolean add(E e); // e를 큐에 추가
public E element(); // front의 값을 반환 
public boolean offer(E e); //용량 제한을 위반하지 않고 이 큐를 사용할 수 있다면 e를 큐에 추가
public E peek(); // front부분의 값을 반환, 비었으면 null
public E poll(); // front의 값을 제거하고 반환, 비었으면 null
public E remove(); //front의 값을 제거하고 그 값을 반환
```

## 번외 - 덱
Deque는 Queue + Stack의 성격을 갖고 있다.
Queue와 거의 유사하지만 front와 rear에서 삽입, 삭제가 가능하다.

```
public boolean add(E e); // e를 rear에 추가
public void addFirst(E e); //e를 front에 추가
public void addLast(E e); // add와 동일
public boolean contains(O o); //o가 덱에 있으면 true
public Iterator<E> descendingIterator(); //덱의 reverse Iterator 반환
public E element(); // 덱의 front 값을 반환
public Iterator<E> iterator(); // 덱의 iterator 값을 반환
public E peek(); // 덱의 front 값을 반환, 덱이 비었으면 null
public E peekFirst(); // peek과 동일
public E peekLast(); //덱의 rear 반환, 비었으면 null
public E pop(); //덱의 front 값을 제거 후 그 값을 반환
public void push(E e); // addFirst
public E remove(); // pop
public E removeFirst(); // pop
public boolean removeFirstOccurence(Object o); //front부터 o값이 처음 나온 지점을 찾아내 제거
public E removeLast(); //덱의 rear 값을 제거 후 반환
public boolean removeLastOccurence(Object o); //rear부터 o값이 처음 나온 지점을 찾아내 제거
public int size();
```
