package org.hdj.AlgorithmPractice.SwordOffer;

import java.util.Stack;

/**
 * @author hdj
 * @version 1.0
 * @date 10/25/19 10:39 AM
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class TwoStackMockQueue_09 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //stack1 用来入队列
        stack1.push(node);


    }

    public int pop() {
        //stack2　用来出队列
        if(!stack2.isEmpty()){
            return stack2.pop();
        }

        //如果stack2, stack1 都为null，返回-1
        if (stack1.isEmpty()) {
            return -1;
        }

        //如果stack2为null, stack1不为null
        //则把stack1中的数据pop　到stack2中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }


    public static void main(String[] args) {
        TwoStackMockQueue_09 t = new TwoStackMockQueue_09();
        int pop = t.pop();

        t.push(1);
        t.push(2);


        t.push(3);
        t.push(4);

        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
