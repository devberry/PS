# PS

성적이 낮은 순서로 학생 출력하기
-> Comparable vs Comparator: https://st-lab.tistory.com/243

Arrays.sort(b, Collections.reverseOrder());
위와 같이 Collections를 이용할 때는 b를 int[]가 아닌 Integer[]로 작성해야 한다.

데이터의 갯수가 1000만 개를 넘기거나 탐색 범위가 10억을 넘어간다면 이진 탐색을 의심해보자.

1e9 = 1*10^9 = 1000000000, 2e9 = 2*10^9 = 2000000000

백트래킹을 사용할 때 res.add(sub)로 작성하게 되면 sub의 객체 주소를 삽입하는 것으로, 이후 재귀의 과정에서 sub에 일어나는 변경사항까지 전부 적용되기 때문에 아래처럼 작성해야 한다.
-> res.add(new ArrayList(sub));

이진 트리의 높이는 최악의 경우 O(n), 최적의 경우(포화, 완전 이진트리) O(logn)이 된다.

이분 탐색을 사용할 때 주어진 범위를 고려해서 (start + end)에서 overflow가 발생할 가능성이 있다면 mid를 start + (end - start) / 2로 설정하면 된다.

switch문을 사용할 때 같은 코드를 이용하는 케이스가 여러 개라면 case 1: case 4: case 7: 이렇게 연달아 작성하는 것도 가능하다.

hashmap에서 value로 배열을 넣고 싶다면 map.put(key, {1,2}) 이렇게 작성하는 게 아니라 map.put(key, new int[]{1,2}) 이렇게 작성해야 한다. 
또는 넣을 배열을 미리 만들어서 배열명을 넣는 방법을 써도 괜찮다.
