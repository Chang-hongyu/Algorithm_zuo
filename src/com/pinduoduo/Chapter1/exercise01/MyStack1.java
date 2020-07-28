package com.pinduoduo.Chapter1.exercise01;

import java.util.Stack;

public class MyStack1 {
    // 记录栈中的数据
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    // 构造函数
    public MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    /*
    * 压入数据规则
    * 先将数据压入stackData 之后判断stackMin是否为空：
    * 如果为空 则newNum压入stackMin
    * 如果不为空 则比较newNum和stackMin的栈顶元素中哪一个更小：
    * 如果newNum更小或两者相等 则将newNum也压入stackMin
    * 如果stackMin中栈顶元素更小 则stackMin不压入任何内容
    * */
    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }
        else if (newNum < this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    /*
    * 弹出数据规则
    * 先在stackData上弹出栈顶元素 记为value 之后比较当前stackMin栈顶元素和value哪个更小
    * 当stackMin栈顶元素与value相等时 stackMin弹出栈顶元素
    * 当stackMin栈顶元素小于value时 stackMin不弹出栈顶元素
    * 返回value
    * */
    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    private int getMin() {
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty!");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(3);
        myStack1.push(4);
        myStack1.push(2);
        System.out.println(myStack1.getMin());
        System.out.println(myStack1.stackData);
        myStack1.pop();
        System.out.println(myStack1.getMin());
        myStack1.push(1);
        System.out.println(myStack1.getMin());
    }
}
