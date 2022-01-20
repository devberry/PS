package com.company;

import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }

        return 1;
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            list.add(new Student(name, score));
        }

        Collections.sort(list);

        for (Student student : list) {
            System.out.print(student.getName() + " ");
        }
    }
}

/*
i 학생 수 n, 두번째 줄부터 학생의 이름을 나타내는 문자열 a, 학생의 성적을 나타내는 정수 b
o 모든 학생의 이름을 성적이 낮은 순으로 출력
c 1<=n<=100000, a의 길이와 학생의 성적은 100이하의 자연수
e

sol
1.
2차원 배열에 이름,성적의 형태로 저장
성적을 오름차순으로 정렬 후 이름만 출력

time O(nlogn)
space O(n)
 */
