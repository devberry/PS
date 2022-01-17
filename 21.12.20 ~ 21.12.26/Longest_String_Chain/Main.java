package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strings = {"abde", "abc", "abd", "abcde", "ade", "ae", "labde", "abcdef"};

        longestChain(strings);
    }

    private static void longestChain(String[] input) {
        //O(NlgN) N = input.length
        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Map<String, List<String>> map = new HashMap<>();
        int maxSize = 0;
        String maxOwner = "";

        //O(N)
        for(int i = 0; i < input.length; i++) {
            map.put(input[i], new ArrayList<>());
            map.get(input[i]).add(input[i]);
        }

        //O(N*M^2) M = input string 중 가장 긴 문자열의 길이
        for(String key : input) {
            for(int i = 0; i < key.length(); i++) {
                String str = "";
                
                if (i == 0) {
                    str = key.substring(i + 1);
                } else if (i == key.length() - 1) {
                    str = key.substring(0, key.length() - 1);
                } else {
                    str = key.substring(0, i) + key.substring(i + 1);
                }
                
                if (map.containsKey(str)) {
                    map.get(key).addAll(map.get(str));
                    if (maxSize < map.get(key).size()) {
                        maxSize = map.get(key).size();
                        maxOwner = key;
                    }
                    break;
                }
            }
        }

        System.out.println(map.toString());
        System.out.println(map.get(maxOwner).toString());
    }
}

/*
i list: strings
o string 하나를 골라서 chain의 시작으로 삼고 거기에서 char 하나를 지워서 만든
string(initial array에 포함되어 있는)을 chain에 포함시킨다.
이 string chain이 가장 길 경우에 반환.
c string chains' length > 1
e strings의 길이가 1일 때 empty array를 return.

solution
1.
initial array 정렬
ae abc abd ade abde abcde labde abcdef
ae:{ae}
ade:{ade}
위와 같이 자기 자신이 value로 포함되도록 map을 만든다.
key를 전부 돌면서 자신의 char를 앞에서 끝까지 전부 하나씩 빼보고 그 string이
map에 있는지 확인한다. 있으면 해당 string의 체인이 현재 string의 체인보다 크기가
작을 경우에만 체인을 추가한다.

time O(NlgN + N*M^2)
space O(N*N)
 */