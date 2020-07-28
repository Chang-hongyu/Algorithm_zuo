package com.pinduoduo.Chapter1.exercise03;

import java.util.Stack;

public class ReverseStackWithRecursion {
    private Stack<Integer> stack = new Stack<>();

    // 将栈底元素返回兵移除
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }
        else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void printStack(Stack<Integer> stack){
        for (Integer i: stack){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        ReverseStackWithRecursion myStack = new ReverseStackWithRecursion();
        myStack.stack.push(1);
        myStack.stack.push(2);
        myStack.stack.push(3);
        myStack.stack.push(4);
        myStack.stack.push(5);
        printStack(myStack.stack);
        reverse(myStack.stack);
        printStack(myStack.stack);
    }
}
