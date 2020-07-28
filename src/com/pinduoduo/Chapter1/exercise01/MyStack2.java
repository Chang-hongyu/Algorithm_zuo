package com.pinduoduo.Chapter1.exercise01;

import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }
        else if (newNum < this.getMin()){
            this.stackMin.push(newNum);
        }
        else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    private int getMin() {
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty!");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(3);
        myStack2.push(4);
        myStack2.push(2);
        System.out.println(myStack2.getMin());
        System.out.println(myStack2.stackData);
        myStack2.pop();
        System.out.println(myStack2.getMin());
        myStack2.push(1);
        System.out.println(myStack2.getMin());
    }
}
