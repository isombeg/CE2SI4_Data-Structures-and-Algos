/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3t;

/**
 *
 * @author TheYo
 */
public class MyStack{
    private MyQueue stack[];
    private int currSize;
    
    public MyStack(int n){
        stack = new MyQueue[n];
        currSize = 0;
//        System.out.println("currSize: " + currSize);
    }
    
    public void push(MyQueue elem) throws IllegalArgumentException {
        if(elem == null) throw new IllegalArgumentException("Argument is null");
        else stack[currSize++] = elem;
//        System.out.println("currSize: " + currSize);
    }
    
    public void pop() throws RuntimeException {
        if(currSize == 0) throw new RuntimeException("Stack Underflow");
        stack[--currSize] = null;
//        System.out.println("currSize: " + currSize);
    }
    
    public int getSize(){
        return currSize;
    }
    
    public boolean isEmpty(){
        if(currSize == 0) return true;
        else return currSize == 1 && top().isEmpty() == true;
        
        
    }
    
    public MyQueue top(){
        return stack[currSize != 0 ? currSize - 1 : 0];
    }
    
    public void printStack(){
        for(int i = currSize; i > 0; i--){
            stack[i-1].printQueue();
        }
    }
}
