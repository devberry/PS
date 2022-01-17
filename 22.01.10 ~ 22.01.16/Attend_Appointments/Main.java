package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] input = {{6,7}, {2,4}, {8,12}, {20,24}, {7,10}};

        System.out.println(attendAppointments(input));
    }

    private static boolean attendAppointments(int[][] input) {
        if(input.length == 1) {
            return true;
        }

        Arrays.sort(input, (a,b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < input.length - 1; i++) {
            if(input[i][1] > input[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}

/*
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Example 1:

Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
Example 2:

Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.
Example 3:

Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.

i int[][]: 'N' appointments
o boolean: if a person can attend all the appointments
c x
e appointments.length == 1 -> return true

sol
1.
appointments[n][0] 기준으로 정렬
23 36 45
16 710 1011 1112 1218
appointments[n][1], appointments[n + 1][0] 비교, 하나라도 겹치면 바로 false return

time O(nlgn) n == appointments.length
space O(1)
 */
