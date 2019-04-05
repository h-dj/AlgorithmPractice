package org.hdj.AlgorithmPractice.DataStructure.ch3.stack;


import org.hdj.AlgorithmPractice.DataStructure.Stack.SqStack.SqStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 栈的应用：
 * 括号匹配
 * <p>
 * a = b + (c+d)*(e-f);
 * s[4] = t[a[2]] + u/((i + j) * k);
 */
public class Example3_1_5 {

    private final int LEFT = 0; //记录分隔符为“左”分隔符
    private final int RIGHT = 1;//记录分隔符为“右”分隔符
    private final int OTHER = 2;//记录其它分隔符

    private final Map<String, String> map = new HashMap() {{
        put("(", ")");
        put("[", "]");
        put("{", "}");
        put("/*", "*/");
    }};

    /**
     * 验证分隔符
     *
     * @return
     */
    public int verifyFlag(String str) {
        if (map.containsKey(str))
            return LEFT;
        if (map.containsValue(str))
            return RIGHT;
        return OTHER;
    }

    /**
     * 验证左右分隔符是否匹配
     *
     * @return
     */
    public boolean matchs(String s1, String s2) {
        String s = map.getOrDefault(s1, null);
        return s != null && s.equals(s2);
    }

    public boolean isLegal(String str) {
        if (str != null && !"".equals(str)) {
            //创建容量为100的栈
            SqStack<String> s = new SqStack(100);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                String t = String.valueOf(c);
                //不是最后一个字符
                if (i != length - 1) {
                    char c2 = str.charAt(i + 1);
                    String s2 = String.valueOf(c2);
                    if (map.containsKey(t + s2) || map.containsValue(s2 + t)) {
                        t = t.concat(s2);
                        //跳过一个字符
                        ++i;
                    }

                }

                if (LEFT == verifyFlag(t)) {
                    s.push(t);
                } else if (RIGHT == verifyFlag(t)) {
                    if (s.isEmpty() || !matchs(s.pop().toString(), t)) {
                        //右分隔符与栈顶元素不匹配，抛出异常
                        throw new RuntimeException("Java 语句不合法！");
                    }
                }

            }

            if (!s.isEmpty())
                throw new RuntimeException("Java 语句不合法！");
            return true;
        }
        throw new RuntimeException("Java 语句为空！");
    }

    public static void main(String[] args) {
        Example3_1_5 example3_1_5 = new Example3_1_5();
        System.out.println("请输入java语句！\n");
        Scanner in = new Scanner(System.in);
        if (example3_1_5.isLegal(in.nextLine())) {
            System.out.println("java语句合法");
        } else {
            System.out.println("java语句不合法");
        }
    }
}
