package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String pattern = "yxyyyxxy";
        String string = "baddaddoombaddaddoomibaddaddoombaddaddoombaddaddoombaddaddoomibaddaddoomibaddaddoom";

        patternMatcher(pattern, string);
    }

    private static void patternMatcher(String pattern, String string) {
        String newPattern = pattern;

        if(pattern.charAt(0) == 'y') {
            newPattern = newPattern.replace('x', 'a');
            newPattern = newPattern.replace('y', 'x');
            newPattern = newPattern.replace('a', 'y');
        }

        int numX = 0;
        int numY = 0;
        int beforeY = 0; //첫 y 이전에 존재하는 x의 갯수

        //O(N) N == pattern.length
        for(int i = 0; i < newPattern.length(); i++) {
            if (newPattern.charAt(i) == 'x') {
                numX++;
            } else {
                numY++;
                if (beforeY == 0) {
                    beforeY = numX;
                }
            }
        }

        int lenX = 0;
        int lenY = 0;
        StringBuilder sb = new StringBuilder();
        String[] result = new String[2];

        //O(M^2 + M*N) M = string.length
        loop:
        for(int i = 1; i < string.length() + 1; i++) {
            lenX = i;
            if(numY != 0) {
                if ((string.length() - numX * lenX) % numY != 0) {
                    continue;
                }
                lenY = (string.length() - numX * lenX) / numY;
            }


            String x = string.substring(0, lenX);
            String y = string.substring(beforeY * lenX, beforeY * lenX + lenY);

            for(int j = 0; j < newPattern.length(); j++) {
                if (newPattern.charAt(j) == 'x') {
                    sb.append(x);
                } else {
                    sb.append(y);
                }
            }

            if (sb.toString().equals(string)) {
                result[0] = x;
                result[1] = y;
                break loop;
            }
            sb.setLength(0);
        }

        if(newPattern.equals(pattern)) {
            System.out.println(result[0] + ", " + result[1]);
        }
        else {
            System.out.println(result[1] + ", " + result[0]);
        }
    }
}

/*
i string: pattern, string: normal
o string array: s1 s2
c input string doesnt match input pattern -> return empty array
s1 s2 -> only one pair exist
e

solution
1.
xxyxxy
yyxyyx

pattern에서 첫 글자가 y일 경우 모든 문자를 x와 y끼리 swap
pattern에서 x와 y 갯수를 구한다.
x의 길이를 정한다.
예를 들어 처음엔 x가 g라고 가정(길이: 1)
string의 길이가 10이라고 했을 때 y 길이는 3
pattern대로 문자열을 만들어서 string이랑 비교
같으면 x랑 y를 return
아니면 x 길이를 다시 정하는 것부터 반복

time O(M^2 + M*N)
space O(1)
 */