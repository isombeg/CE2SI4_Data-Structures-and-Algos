/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author TheYo
 */
public class MaxHeap {
    private Integer[] heap;
    private int maxSize;
    private int liveSize;
   
    private int detSize(int n){
        int i = 2;
        
        while(n > i) i *=2;
        return i;
    }
    
    private int leftChild(int index){
        return 2*index + 1;
    }
    
    private int rightChild(int index){
        return 2*index + 2;
    }
    
    private int parent(int index){
        return (index + 1)/2 - 1;
    }
    
    private int percolateUp(int index){
        int temp;
        
        temp = heap[parent(index)];
        heap[parent(index)] = heap[index];
        heap[index] = temp;
        
        return parent(index);
    }
    
    private int percolateLeft(int index){
        percolateUp(leftChild(index));
        return leftChild(index);
    }
    
    private int percolateRight(int index){
        percolateUp(rightChild(index));
        return rightChild(index);
    }
    
    private void enlarge(){
        maxSize *= 2;
        Integer[] oldHeap = heap;
        heap = new Integer[maxSize];
        liveSize = 0;
        
        for(int n : oldHeap)
            insert(n);
    }
    
    public MaxHeap(int someSize){
        maxSize = someSize;
        heap = new Integer[someSize];
        liveSize = 0;
    }
    
    public MaxHeap(Integer[] someArray){
        
        maxSize = someArray.length;
        heap = new Integer[maxSize];
        liveSize = 0;
        
        for(int n : someArray){
            insert(n);
        }
    }
    
    public void insert(int n){
        int placeHolder = liveSize;
        
        if(liveSize < maxSize){
            heap[liveSize] = n;

            while(parent(placeHolder) >= 0 && n > heap[parent(placeHolder)])
                placeHolder = percolateUp(placeHolder);
            
            liveSize++;
        }
        
        else{
            enlarge();
            insert(n);
        }
    }
    
    public int deleteMax(){
        int curr = 0, oldMax = heap[0];
        
        heap[0] = heap[liveSize - 1];
        heap[--liveSize] = null;
        
        while(true){
            if(leftChild(curr) < liveSize && rightChild(curr) < liveSize){
                if(heap[curr] < heap[leftChild(curr)] && heap[curr] < heap[rightChild(curr)]){
                    curr = heap[leftChild(curr)] > heap[rightChild(curr)] ? percolateLeft(curr) : percolateRight(curr);
                    continue;
                }
            }
            
            if(leftChild(curr) < liveSize && heap[curr] < heap[leftChild(curr)])
                curr = percolateLeft(curr);
            else if(rightChild(curr) < liveSize && heap[curr] < heap[rightChild(curr)])
                curr = percolateRight(curr);
            else break;
        }
        
        return oldMax;
    }
    
    public String toString(){
        String rslt = "";
        int i = 0;
        
        while(i < maxSize && heap[i] != null){
            rslt += heap[i++] + " ";
        }

        return rslt;
    }
    
    public static void heapSort(Integer[] arrayToSort){
        MaxHeap h = new MaxHeap(arrayToSort);
        
        for(int n = arrayToSort.length - 1; n >= 0; n--)
            arrayToSort[n] = h.deleteMax();
        
    }
    
    public int get_maxSize(){
        return maxSize;
    }
    
    public int get_liveSize(){
        return liveSize;
    }
    
    public int getMax(){
        return heap[0];
    }
}
