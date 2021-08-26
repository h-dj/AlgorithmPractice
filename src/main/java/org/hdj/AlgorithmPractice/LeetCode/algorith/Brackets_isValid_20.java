package org.hdj.AlgorithmPractice.LeetCode.algorith;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hdj
 * @version 1.0
 * @date 2020/8/14 下午4:43
 * @description: <pre>
 *     给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 *
 * 输入: "{[]}"
 * 输出: true
 * </pre>
 */
public class Brackets_isValid_20 {


    public static void main(String[] args) {
        boolean valid = isValid("{[]}");
        System.out.println(valid);
    }

    /**
     * 判断是否合法
     * <p>
     * 注意：奇数问题
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int length = s.length();
        //如果长度为奇数，直接返回false
        if (length % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if ((c == '}' && peek == '{')
                        || (c == ']' && peek == '[')
                        || (c == ')' && peek == '(')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
