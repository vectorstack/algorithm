package com.vector.stack;

import java.util.Stack;

/**
 * Created by DCITS-cs on 2018/6/3.
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int num){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(num);
        }else if(num < this.getMin()){
            this.stackMin.push(num);
        }else{
            int value = this.stackMin.peek();
            this.stackMin.push(value);
        }
    }

    public int pop(int num){
        if(this.stackData.isEmpty()){
            throw  new RuntimeException("Your stack is empty!");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        }
        return this.stackMin.peek();
    }
}
