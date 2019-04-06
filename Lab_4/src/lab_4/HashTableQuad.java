/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

/**
 *
 * @author TheYo
 */
public class HashTableQuad {
    private Integer[] table;
    private int size, keyNum;
    private double maxLoad;
    
     
   private boolean isPrime(int n){
        int[] primes = {2,3,5,7};
        
        if(n == 1) return false;
        if(n == 2 || n == 3 || n ==5 || n == 7) return true;
        
        for(int a : primes)
            if (n % a == 0) return false;
        
        return true;
    }
    
    private int findPrime(double a){
        //Algorithm makes use of the Sieve of Erotosthenes to the next prime number
        int x = (int)a + 1;
        if(x%2 == 0) x++;
        
        for(x = x; isPrime(x) == false; x += 2){}
        
        return x;
    }
    
    private int hash_function(int x, int i){
        return (x + i*i) % size;
    }
    
    public HashTableQuad(int maxNum, double load){
        size = findPrime(maxNum/load);
        table = new Integer[size];
        keyNum = 0;
        maxLoad = load;
    }
    
    public void insert(int n){
        int place;
        
        if(isIn(n)) return;
        if((double)(keyNum + 1)/size > maxLoad){
            rehash();
            insert(n);
        }
            
        
        else{
            
            for(int i = 0; i < size; i++){
                place = hash_function(n,i);
                
                if(table[place] == null){
                    table[place] = n;
                    keyNum++;
                    return;
                }
            }
            
            rehash();
            
        }
        
    }
    
    private void rehash(){
        Integer[] oldTable = table;
        size = findPrime(2*size);
        table = new Integer[size];
        keyNum = 0;
        
        for(Integer a : oldTable){
            if(a != null) insert(a);
        }
    }
    
    public boolean isIn(int n){
        int i = 0, slot = hash_function(n,i);
        
        while(table[slot] != null && i < size){
            if(table[slot] == n)
                return true;
            else slot = hash_function(n,i++);
        }
        
        return false;
    }
    
    public void printKeys(){
        for(int i = 0; i < size; i++)
            if(table[i] != null)
                System.out.print(table[i] + " ");
        System.out.println();
    }
    
    public void printKeysandIndexes(){
        for(int i = 0; i < size; i++)
            if(table[i] != null)
                System.out.println(i + " : " + table[i] + " ");
    }
    
    public int getSize(){
        return size;
    }
    
    public int getKeyNum(){
        return keyNum;
    }
    
    public double getMaxLoad(){
        return maxLoad;
    }
    
    public double getLoadFactor(){
        return (double) keyNum/size;
    }
    
    public int insertCount(int n){
        int i, slot;
        insert(n);
        
        slot = hash_function(n, 0);
        for(i = 1; table[slot] != n; i++)
            slot = hash_function(n, i);
        
        return i;
    }
}
