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
public class MyQueue {
    TNode queue[];
    int front, end;
    
    public MyQueue(int v){
        queue = new TNode[v];
        front = 0;
        end = 0;
    }
    
    public MyQueue(TNode n, int v){
        queue = new TNode[v];
        queue[0] = n;
        front = 0;
        end = 1;
    }
    
    public boolean isEmpty(){
        return queue[front] == null;
    }
    
    public boolean isFull(){
        return front == end && queue[front] != null;
    }
    
    public TNode getFront(){
        return queue[front];
    }
    
    public void enqueue(TNode q) throws NullPointerException {
//        if(q == null) throw new NullPointerException();
        queue[end] = q;
        end = (end + 1) % queue.length;
    }
    
    public TNode dequeue() throws RuntimeException {
        TNode q;
        
        if(isEmpty()) throw new RuntimeException("Empty Queue");
        
        q = queue[front];
        
        queue[front] = null;
        front = (front + 1) % queue.length;
        return q;
    }
    
    public void printQueue(){
        for(int i = 0; i < queue.length; i++){
            System.out.print(queue[(i + front + 1) % queue.length].element + " ");
        }
        System.out.println();
    }
}
