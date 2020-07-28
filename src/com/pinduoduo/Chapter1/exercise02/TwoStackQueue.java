package com.pinduoduo.Chapter1.exercise02;

import java.util.Stack;

public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    // 加入新元素
    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    // 弹出队列元素
    public int poll(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    // 返回队头元素
    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        queue.add(3);
        queue.add(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
