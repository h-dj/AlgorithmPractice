package org.hdj.AlgorithmPractice.DataStructure.ch3.stack;


import org.hdj.AlgorithmPractice.DataStructure.Stack.LinkStack.LinkStack;

/**
 * 栈的应用之
 * 整型大数求和
 */
public class Example3_2 {


    /**
     * 求两个大数的和
     *
     * @param a 加数a
     * @param b 加数b
     * @return 返回String , 加数和
     */
    public String add(String a, String b) {
        LinkStack sum = new LinkStack();//大数的和
        LinkStack sA = numSplit(a);//加数以字符的形式放在栈中
        LinkStack sB = numSplit(b);//加数以字符的形式放在栈中

        int partialSum;//两个位的求和
        boolean isCarry = false; //进位表示

        //当两个数字栈为空时，退出循环
        while (!sA.isEmpty() && !sB.isEmpty()) {
            //两个数字栈，出栈求和
            Integer numA = (Integer) sA.pop();
            Integer numB = (Integer) sB.pop();

            partialSum = numA + numB;
            //判断是否需要加上上一个数和的进位
            if (isCarry) {
                partialSum++; //加入进位
                isCarry = false;//重置进位标识
            }
            //判断是否需要进位
            if (partialSum >= 10) {
                //是，则得到个位，压入sum栈中
                partialSum = partialSum - 10;
                sum.push(partialSum);
                // 标识下一个相加有进位
                isCarry = true;
            } else {
                sum.push(partialSum);
            }
        }

        //判断有哪个数字栈不为空
        LinkStack temp = sA.isEmpty() ? sB : sA;

        //把剩余不为空的数字栈，压入sum栈中
        //注意是否需要加上进位
        while (!temp.isEmpty()) {
            Integer num = (Integer) temp.pop();
            //有进位
            if (isCarry) {
                num++; //进位加到此位上
                //判断此相加是否需要进位
                if (num >= 10) {
                    num = num - 10;
                    sum.push(num); //把个位压入sum栈中
                    isCarry = true;
                } else {
                    sum.push(num);
                    isCarry = false;
                }
            } else {
                sum.push(num);
            }
        }
        //判断最高为是否需要进位
        if (isCarry) {
            sum.push(1);
        }

        StringBuffer buffer = new StringBuffer();
        while (!sum.isEmpty()) {
            buffer.append(sum.pop().toString());
        }
        return buffer.toString();
    }

    /**
     * 分割大数字符串，以字符形式存入栈中
     *
     * @param a
     * @return
     */
    private LinkStack numSplit(String a) {
        LinkStack<Integer> stack = new LinkStack();
        if (a == null) return stack;
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            //判断是否为空字符
            if (Character.isSpaceChar(ch)) continue;
            //判断是否为不是数字的字符
            if (Character.isDigit(ch)) throw new RuntimeException("存在非法字符！");
            stack.push(Integer.parseInt(String.valueOf(ch)));
        }
        return stack;
    }


    public static void main(String[] args) {
        Example3_2 example3_2 = new Example3_2();
        String numA = "18 452 543 389 943 209 752 345 473";
        String numB = "8 123 542 678 432 986 899 334";

        String add = example3_2.add(numA, numB);
        System.out.println(add);


    }
}
