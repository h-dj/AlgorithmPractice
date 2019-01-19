package org.hdj.AlgorithmPractice.stack;

import org.hdj.AlgorithmPractice.Stack.SqStack.SqStack;
import org.junit.Before;
import org.junit.Test;

/**
 * 顺序栈测试
 */
public class SqStackTest {

    private SqStack<Integer> sqStack = new SqStack<>();

    @Before
    public void init() {
        sqStack.push(1);
        sqStack.push(2);
        sqStack.push(3);
        sqStack.push(4);
    }

    @Test
    public void test(){
        sqStack.display();
    }

    @Test
    public void testPush(){
        sqStack.push(89);

        sqStack.display();

        Integer peek = sqStack.peek();
        System.out.println(peek);

        System.out.println();
        sqStack.display();

        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        sqStack.pop();
        Integer pop = sqStack.pop();
        System.out.println(pop);
        sqStack.display();
    }
}
