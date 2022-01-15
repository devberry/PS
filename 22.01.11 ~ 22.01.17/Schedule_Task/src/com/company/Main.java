package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int task = 6;
        int[][] pre = {{2,5}, {0,5}, {0,4}, {1,4}, {3,2}, {1,3}};

        System.out.println(checkSchedule(task, pre));
    }

    private static boolean checkSchedule(int task, int[][] pre) {
        //task > 2
        if (pre.length == 0) {
            return false;
        }

        int[] indeg = new int[task];
        List<Integer>[] list = new List[task];

        for (int i = 0; i < task; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] p : pre) {
            list[p[0]].add(p[1]);
            indeg[p[1]]++;
        }

        List<Integer> res = new ArrayList<>();

        topoSort(task, indeg, list, res);
        System.out.println(res.toString());
        //cycle 존재
        if (res.size() != task) {
            return false;
        } else {
            return true;
        }
    }

    private static void topoSort(int task, int[] indeg, List<Integer>[] list, List<Integer> res) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        //cycle 존재
        if (q.size() == 0) {
            return;
        }

        while (!q.isEmpty()) {
            int next = q.poll();
            res.add(next);

            for(int i = 0; i < list[next].size(); i++) {
                indeg[list[next].get(i)]--;
                //indegree가 0이 되면 큐에 넣는다.
                if (indeg[list[next].get(i)] == 0) {
                    q.offer(list[next].get(i));
                }
            }
        }
    }
}

/*
There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’.
Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
Given the number of tasks and a list of prerequisite pairs,
find out if it is possible to schedule all the tasks.

Example 1:

Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
Output: true
Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs
to finish before '2' can be scheduled. One possible scheduling of tasks is: [0, 1, 2]
Example 2:

Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
Output: false
Explanation: The tasks have a cyclic dependency, therefore they cannot be scheduled.
Example 3:

Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
Output: true
Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]

i int: num of tasks, int[][]: prerequisites
o boolean: find out if it is possible to schedule all the tasks
c task > 2
e pre.length == 0 -> return false

sol
1.
topological sort
prereq를 바탕으로 indegree 설정
ex)
indegree: {0, 1, 1}
0:1
1:2

indegree가 0인 정점부터 탐색(bfs 사용)
해당 정점과 연결된 정점으로 이동
이동한 정점의 indegree 1 감소
반복

indegree가 0인 정점이 존재하지 않거나 탐색이 끝났을 때 존재하지 않는 정점이 하나라도 있으면 cycle이 존재한다는 의미
-> false return

결과에 모든 정점이 존재
-> true return

time O(t+e) t = number of tasks, e = prerequisites.length
space O(t)
 */
