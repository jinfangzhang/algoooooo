package SwordOffer;

import java.util.LinkedList;

/**
 * _06_TwoStackQueue
 */
public class _06_TwoStackQueue {

    //A Stack 叫做入栈
    //B Stack 叫做出栈
    LinkedList<Integer> A, B;

    public _06_TwoStackQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    //添加到 Stack A 中
    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        //
        if (!B.isEmpty())
            return B.removeLast();

        if (A.isEmpty())
            return -1;

        while (!A.isEmpty())
            B.addLast(A.removeLast());

        return B.removeLast();
    }
}