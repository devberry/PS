# MoMo

성적이 낮은 순서로 학생 출력하기
-> Comparable vs Comparator: https://st-lab.tistory.com/243

Arrays.sort(b, Collections.reverseOrder());
위와 같이 Collections를 이용할 때는 b를 int[]가 아닌 Integer[]로 작성해야 한다.

데이터의 갯수가 1000만 개를 넘기거나 탐색 범위가 10억을 넘어간다면 이진 탐색을 의심해보자.
