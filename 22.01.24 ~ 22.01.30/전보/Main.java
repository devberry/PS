package com.company;

import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }

        return 1;
    }
}

public class Main {
    public static final int INF = (int) 1e9;
    public static int n,m,start;
    public static List<List<Node>> graph = new ArrayList<List<Node>>();
    public static int[] d = new int[30001];

    public static void dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowDist = now.getDistance();
            int nowIndex = now.getIndex();
            //최단 거리 테이블에서 꺼낸 도시 까지의 최단 거리 정보가(처음엔 INF였던)
            //현재 도시에서 해당 도시로 이동하는 거리보다 짧으면
            //이미 지나간 도시라고 볼 수 있다.
            if (d[nowIndex] < nowDist) {
                continue;
            }

            for (int i = 0; i < graph.get(nowIndex).size(); i++) {
                int newDist = d[nowIndex] + graph.get(nowIndex).get(i).getDistance();
                int newIndex = graph.get(nowIndex).get(i).getIndex();

                if (newDist < d[newIndex]) {
                    d[newIndex] = newDist;
                    pq.offer(new Node(newIndex, newDist));
                }
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //도시 번호가 0이 아니라 1부터 시작한다고 가정
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int cnt = 0;
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                cnt++;
                maxDist = Math.max(maxDist, d[i]);
            }
        }

        //시작 도시는 제외 -> cnt - 1
        System.out.println(cnt - 1 + " " + maxDist);
    }


}

/*
i 도시의 개수 n, 통로의 개수 m, 메시지를 보내고자 하는 도시 c, 통로에 대한 정보 x,y,z(x to y, 전달 시간 z)
o c에서 보낸 메시지를 받는 도시의 총 개수, 총 전달 시간
c 1<=n<=30000, 1<=m<=200000, 1<=c<=n, 1<=x,y<=n, 1<=z<=1000
e

sol
optimal
1.
최단 거리 테이블을 INF로 초기화한다.
시작 도시(c)로 가기 위한 최단 경로를 0으로 설정하고 우선순위 큐에 넣는다.
큐가 비어있지 않을 때 아래를 반복
    최단 거리가 가장 짧은 도시에 대한 정보를 꺼낸다.
    꺼낸 도시가 이미 지나간 도시라면 무시한다.
    꺼낸 도시와 연결된 인접 도시들을 확인한다.
        현재 도시를 거쳐서 다른 도시로 이동하는 거리가 더 짧을 경우 최단 거리 테이블을 갱신하고 큐에 넣는다.
다익스트라 알고리즘을 수행한 뒤 최단 거리 테이블을 확인해서 가장 큰 최단 거리 값을 찾아서 총 전달 시간으로 출력하고
INF가 아닌 도시의 갯수 - 1를 전달한 도시의 갯수로 반환하면 된다.

time O(mlogn)
space O(n)
 */
