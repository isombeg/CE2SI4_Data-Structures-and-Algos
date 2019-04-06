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
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaxHeap test1 = new MaxHeap(5);
        
        System.out.println("maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //Inserting 4 into test1
        test1.insert(4);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //Inserting 2 into test1
        test1.insert(2);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //Inserting 10 into test1, must percolate up
        test1.insert(10);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //Inserting 5 into test1, must percolate up
        test1.insert(5);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //Inserting 20 into test1, must percolate up to max
        test1.insert(20);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //Inserting 3 into test1, heap must enlarge (i.e. maxSize becomes 10)
        test1.insert(3);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //deleting Max
        test1.deleteMax();
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //deleting Max
        test1.deleteMax();
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //constructing from an array
        Integer arr[] = {5,4,2,1,10,11,16,3,2,5,100};
        test1 = new MaxHeap(arr);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        
        //test heapSort
        MaxHeap.heapSort(arr);
        System.out.print("Sorted array: ");
        for(int n : arr) System.out.print(n + " ");
        System.out.println();
        
        System.out.println();
        
        arr = new Integer[7];
        Integer[] arr2 = {89, 52, 19, 50, 21, 2, 7};
        test1 = new MaxHeap(arr2);
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
        test1.deleteMax();
        System.out.println("heap: " + test1 + " maxSize: " + test1.get_maxSize() + ", liveSize: " + test1.get_liveSize());
    }
    
}
