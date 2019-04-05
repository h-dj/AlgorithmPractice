package org.hdj.AlgorithmPractice.DataStructure.ch3.stack;


import org.hdj.AlgorithmPractice.DataStructure.Stack.LinkStack.LinkStack;

/**
 * 栈的应用之
 * <p>
 * 中缀表达的的运算
 * <p>
 * 步骤：
 * 1. 将中缀表达式转为后缀表达式
 * <pre>
 *      1. 初始化一个运算符栈
 *      2. 把算数表达式从左到右 读取一个字符
 *      3. 如果当前字符为数字，则直接压入后缀表达式栈中
 *      3. 如果当前字符为左括号“(”时，将其压入运算符栈中
 *      4. 如果当前字符为运算符时，如果运算符栈为空，则入栈；如果当前运算符的优先级大于栈顶运算符优先级，则要入后缀表达式栈中，否则压入运算符栈中，重复此步骤
 *      5. 如果当前符合为右括号时")" , 反复把运算符的栈顶符合弹出，压入后缀表达式栈中，直到栈顶元素符合为左括号“(”为止，再将左括号弹出，丢弃
 *      6. 如果读取未完成，跳到步骤2
 *      7. 如果读取完毕，将运算符栈中所有运算符弹出，压入后缀表达式栈中
 * </pre>
 * <p>
 * 2. 再把后缀表达式进行计算
 * <pre>
 *     1. 初始化操作栈
 *     2. 从左到右依次读入后缀表达式
 *     3. 如果当前字符为操作数，则压入操作数栈中
 *     4. 如果当前字符为运算符，则从操作数栈中弹出两个操作数参与运算，再将结果压入操作数栈中
 *     5. 重复步骤2-4，直到读取的后缀表达式结束为止，则操作数中的数字为最终结果
 * </pre>
 */
public class Example3_3 {

    public String convertToPostFix(String expression) {
        //操作符栈
        LinkStack st = new LinkStack();
        //后缀表达式
        StringBuffer postFix = new StringBuffer();

        for (int i = 0; i < expression.length(); i++) {
            //读取表达式
            char ch = expression.charAt(i);
            //判断是否为数字
            if (Character.isDigit(ch)) {
                postFix.append(String.valueOf(ch));
            } else if (isOpParenthesis(ch)) { //判断字符是否为左括号
                //入运算符栈
                st.push(ch);
            } else if (isCloseParenthesis(ch)) { //判断是否为右括号
                //弹出运算符栈的栈顶元素，直到遇左括号为止
                while (!st.isEmpty()) {
                    char pop = (Character) st.pop();
                    //如果该字符为左括号，则退出
                    if (isOpParenthesis(pop)) break;
                    //否则，加入后缀表达式中
                    postFix.append(String.valueOf(pop));
                }
            } else if (isOperator(ch)) {//如果是运算符
                if (!st.isEmpty()) {
                    //取出运算符栈中，优先级高的运算符，加入后缀表达式中
                    Character pop = (Character) st.pop();
                    while (pop != null && priority(pop) >= priority(ch)) {
                        postFix.append(String.valueOf(pop));
                        pop = (Character) st.pop();
                    }
                    //如果最后一次取出的优先级低的操作符，重新压栈
                    if (pop != null) {
                        st.push(pop);
                    }
                }
                st.push(ch);
            } else {
                postFix.append(String.valueOf(ch));
            }
        }

        //运算符栈中剩余的运算符串联到后缀表达式中
        while (!st.isEmpty()) {
            postFix.append(String.valueOf(st.pop()));
        }
        return postFix.toString();
    }

    public double numberCalc(String postFix) {
        LinkStack stack = new LinkStack();
        for (int i = 0; postFix != null && i < postFix.length(); i++) {
            //读取后缀表达式
            char ch = postFix.charAt(i);

            //当为操作符时
            if (isOperator(ch)) {
                //取出两个操作数
                Double d2 = Double.valueOf(stack.pop().toString());
                Double d1 = Double.valueOf(stack.pop().toString());

                Double d3 = 0.0;

                if ('+' == ch) {
                    d3 = d1 + d2;
                } else if ('-' == ch) {
                    d3 = d1 - d2;
                } else if ('*' == ch) {
                    d3 = d1 * d2;
                } else if ('/' == ch) {
                    d3 = d1 / d2;
                } else if ('^' == ch) {
                    d3 = Math.pow(d1, d2);
                } else if ('%' == ch) {
                    d3 = d1 % d2;
                }
                stack.push(d3);
            } else {
                stack.push(Double.valueOf(String.valueOf(ch)));
            }
        }

        return (Double) stack.pop();
    }

    /**
     * 获取运算符优先级
     *
     * @param ch
     * @return
     */
    private int priority(char ch) {
        if ('^' == ch) return 3; //幂运算
        if ('*' == ch || '/' == ch || '%' == ch) return 2; //乘、除、取模
        if ('+' == ch || '-' == ch) return 1; //加减
        return 0;
    }

    private boolean isOperator(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
            default:
                return false;
        }
    }

    private boolean isCloseParenthesis(char ch) {
        return ')' == ch;
    }

    private boolean isOpParenthesis(char ch) {
        return '(' == ch;
    }

    public static void main(String[] args) {
        Example3_3 p = new Example3_3();
        String postFix = p.convertToPostFix("(1+2)*(5-2)/2^2+5%3");

        System.out.println(postFix);
        System.out.println(p.numberCalc(postFix));
    }
}
