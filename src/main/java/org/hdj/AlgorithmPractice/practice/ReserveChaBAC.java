package org.hdj.AlgorithmPractice.practice;

public class ReserveChaBAC {

    public static void main(String[] args) {
        String a = "BBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCC";
        char[] chars = a.toCharArray();
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = a.length() - 1;

        while (aIndex <= cIndex) {
            if (chars[aIndex] == 'B' && bIndex != aIndex) {
                char t = chars[aIndex];
                chars[aIndex] = chars[bIndex];
                chars[bIndex] = t;
                bIndex++;
            } else if (chars[aIndex] == 'C') {
                char t = chars[aIndex];
                chars[aIndex] = chars[cIndex];
                chars[cIndex] = t;
                cIndex--;
            }else{
                aIndex++;
            }
        }
        System.out.println(new String(chars));
    }
}
