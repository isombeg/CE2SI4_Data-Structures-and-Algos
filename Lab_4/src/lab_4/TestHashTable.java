/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.Random;

/**
 *
 * @author TheYo
 */
public class TestHashTable {
    
    public static void testSize(HashTableLin a){
        System.out.println(a.getSize());
    }
    
    public static void testSize(HashTableQuad a){
        System.out.println(a.getSize());
    }
    
    public static void testIsIn(HashTableLin a){
        Random rdm = new Random();
        int x = rdm.nextInt();
        a.insert(x);
        a.insert(x);
        System.out.print("Table: ");
        a.printKeys();
    }
    
    public static void testIsIn(HashTableQuad a){
        Random rdm = new Random();
        int x = rdm.nextInt();
        a.insert(x);
        a.insert(x);
        System.out.print("Table: ");
        a.printKeys();
    }
    
    public static void testProbing(HashTableLin a){
        Random rdm = new Random();
        int x = rdm.nextInt();
        a.insert(x);
        a.insert(a.getSize()+x);
        a.printKeys();
    }
    
    public static void testProbing(HashTableQuad a){
        Random rdm = new Random();
        int x = rdm.nextInt();
        a.insert(x);
        a.insert(a.getSize()+x);
        a.printKeys();
    }
    
    public static void testRehash(HashTableLin a){
        int init = a.getSize(), x;
        Random rdm = new Random();
        
        while(a.getSize() == init){
            x = rdm.nextInt();
            if(x < 0) x *= -1;
            System.out.println("Inserting " + x);
            a.insert(x);
        }
        
        System.out.println("Initial size: " + init + ", Final size: " + a.getSize());
    }
    
    public static void testRehash(HashTableQuad a){
        int init = a.getSize(), x;
        Random rdm = new Random();
        
        while(a.getSize() == init){
            x = rdm.nextInt();
            if(x < 0) x *= -1;
            System.out.println("Inserting " + x);
            a.insert(x);
        }
        
        System.out.println("Initial size: " + init + ", Final size: " + a.getSize());
    }
    
    public static void measureProbeAvgLin(int maxNum){
        double loadFactors[] = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9}, avg = 0;
        int digitsInserted, testsDone, x, tally = 0;
        Random rdm = new Random();
        HashTableLin a;
        
        for(double loadFactor : loadFactors){
            
            for(testsDone = 0; testsDone < 100; testsDone++){
                a = new HashTableLin(maxNum, loadFactor);
                for(digitsInserted = 0; digitsInserted < 100000; digitsInserted++){
                    do {
                        x = rdm.nextInt();
                        if(x < 0) x*=-1;
                    } while(a.isIn(x));
                    tally += a.insertCount(x);
                }
                avg += tally;
            }
            
            avg /= (100*100000);
            System.out.println(loadFactor + ": Theoretical: " + (0.5*(1+1/(1-loadFactor))) + " Real: " + avg);
        }
    }
    
    public static void measureProbeAvgQuad(int maxNum){
        double loadFactors[] = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9}, avg = 0;
        int digitsInserted, testsDone, x, tally = 0;
        Random rdm = new Random();
        HashTableQuad a;
        
        for(double loadFactor : loadFactors){
            
            for(testsDone = 0; testsDone < 100; testsDone++){
                a = new HashTableQuad(maxNum, loadFactor);
                for(digitsInserted = 0; digitsInserted < 100000; digitsInserted++){
                    do {
                        x = rdm.nextInt();
                        if(x < 0) x*=-1;
                    } while(a.isIn(x));
                    tally += a.insertCount(x);
                }
                avg += tally;
            }
            
            avg /= 100*100000;
            System.out.println(loadFactor + ": Theoretical: " + (0.5*(1+1/(1-loadFactor))) + " Real: " + avg);
        }
    }
    
}
