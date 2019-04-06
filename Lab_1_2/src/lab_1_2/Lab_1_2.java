/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_1_2;

import java.util.Random;
import java.math.BigInteger;

/**
 *
 * @author TheYo
 */
public class Lab_1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HugeInteger huge1, huge2, huge3;
        BigInteger big1, big2, big3;
        long startTime, endTime;
        double runTime=0.0;
        int MAXNUMINTS = 100, n = 10000, MAXRUN = 500, comparison, amnts[] = {1, 2,3,4,5,6,7,8,9,10,11,12,13,14,15,50};
        
        System.out.println("add Tests");
        for(int i = 0; i < amnts.length; i++){
//            System.out.println("Tests for " + amnts[i] + " digits");
//            for(int trialNum = 0; trialNum < 5; trialNum++){
                for (int numInts=0; numInts < MAXNUMINTS; numInts++){
                    huge1 = new HugeInteger(amnts[i]); //creates a random integer of n digits
                    huge2 = new HugeInteger(amnts[i]); //creates a random integer of n digits
                    startTime = System.currentTimeMillis();
                    for(int numRun=0; numRun < MAXRUN; numRun++)
                    { huge3 = huge1.add(huge2); }
                    endTime = System.currentTimeMillis();
                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
                }
                runTime = runTime/((double)MAXNUMINTS);
                System.out.println(runTime);

//            }
        }
        
        System.out.println("subtract Tests");
        for(int i = 0; i < amnts.length; i++){
//            System.out.println("Tests for " + amnts[i] + " digits");
//            for(int trialNum = 0; trialNum < 5; trialNum++){
                for (int numInts=0; numInts < MAXNUMINTS; numInts++){
                    huge1 = new HugeInteger(amnts[i]); //creates a random integer of n digits
                    huge2 = new HugeInteger(amnts[i]); //creates a random integer of n digits
                    startTime = System.currentTimeMillis();
                    for(int numRun=0; numRun < MAXRUN; numRun++)
                    { huge3 = huge1.subtract(huge2); }
                    endTime = System.currentTimeMillis();
                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
                }
                runTime = runTime/((double)MAXNUMINTS);
                System.out.println(runTime);

//            }
        }
        
//        System.out.println('\n');
//        
//        System.out.println("multiply Tests");
//        for(int i = 0; i < amnts.length; i++){
//            System.out.println("Tests for " + amnts[i] + " digits");
////            for(int trialNum = 0; trialNum < 5; trialNum++){
//                for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//                    huge1 = new HugeInteger(amnts[i]); //creates a random integer of n digits
//                    huge2 = new HugeInteger(amnts[i]); //creates a random integer of n digits
//                    startTime = System.currentTimeMillis();
//                    for(int numRun=0; numRun < MAXRUN; numRun++)
//                    { huge3 = huge1.multiply(huge2); }
//                    endTime = System.currentTimeMillis();
//                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
//                }
//                runTime = runTime/((double)MAXNUMINTS);
//                System.out.println(runTime);
//
////            }
//        }
        
//        System.out.println('\n');
//        
//        System.out.println("divide Tests");
//        for(int i = 0; i < amnts.length; i++){
//            System.out.println("Tests for " + amnts[i] + " digits");
////            for(int trialNum = 0; trialNum < 5; trialNum++){
//                for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//                    huge1 = new HugeInteger(amnts[i]); //creates a random integer of n digits
//                    huge2 = new HugeInteger(amnts[i]); //creates a random integer of n digits
//                    startTime = System.currentTimeMillis();
//                    for(int numRun=0; numRun < MAXRUN; numRun++)
//                    { huge3 = huge1.divide(huge2); }
//                    endTime = System.currentTimeMillis();
//                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
//                }
//                runTime = runTime/((double)MAXNUMINTS);
//                System.out.println(runTime);
//
////            }
//        }
//        
//        System.out.println('\n');
//        
//        System.out.println("compareTo Tests");
//        for(int i = 0; i < amnts.length; i++){
//            System.out.println("Tests for " + amnts[i] + " digits");
////            for(int trialNum = 0; trialNum < 5; trialNum++){
//                for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//                    huge1 = new HugeInteger(amnts[i]); //creates a random integer of n digits
//                    huge2 = new HugeInteger(amnts[i]); //creates a random integer of n digits
//                    startTime = System.currentTimeMillis();
//                    for(int numRun=0; numRun < MAXRUN; numRun++)
//                    { comparison = huge1.compareTo(huge2); }
//                    endTime = System.currentTimeMillis();
//                    runTime +=(double) (endTime - startTime)/((double) MAXRUN);
//                }
//                runTime = runTime/((double)MAXNUMINTS);
//                System.out.println(runTime);
//
////            }
//        }
//        System.out.println('\n');
//        System.out.println("BigInteger add tests");
//        
//        for(int i = 0; i < amnts.length; i++){
//            for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//                big1 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                big2 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                startTime = System.currentTimeMillis();
//                for(int numRun=0; numRun < MAXRUN; numRun++){ 
//                    big3 = big1.add(big2); }
//                endTime = System.currentTimeMillis();
//                runTime +=(double) (endTime - startTime)/((double) MAXRUN);
//            }
//            runTime = runTime/((double)MAXNUMINTS);
//  
//            System.out.println(runTime);
//        }
//        
//        System.out.println('\n');
//        System.out.println("BigInteger subtract tests");
//        
//        for(int i = 0; i < amnts.length; i++){
//            for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//                big1 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                big2 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                startTime = System.currentTimeMillis();
//                for(int numRun=0; numRun < MAXRUN; numRun++){ 
//                    big3 = big1.subtract(big2); }
//                endTime = System.currentTimeMillis();
//                runTime +=(double) (endTime - startTime)/((double) MAXRUN);
//            }
//            runTime = runTime/((double)MAXNUMINTS);
//            System.out.println(runTime);
//        }
//        
//        System.out.println('\n');
//        System.out.println("BigInteger multiply tests");
//        
//        for(int i = 0; i < amnts.length; i++){
//            for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//                big1 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                big2 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                startTime = System.currentTimeMillis();
//                for(int numRun=0; numRun < MAXRUN; numRun++){ 
//                    big3 = big1.multiply(big2); }
//                endTime = System.currentTimeMillis();
//                runTime +=(double) (endTime - startTime)/((double) MAXRUN);
//            }
//            runTime = runTime/((double)MAXNUMINTS);
//  
//            System.out.println(runTime);
//        }
//        
//        System.out.println('\n');
//        System.out.println("BigInteger divide tests");
//        
//        for(int i = 0; i < amnts.length; i++){
//            for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//                big1 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                big2 = new BigInteger((new HugeInteger(amnts[i])).toString()); //creates a random integer of n digits
//                startTime = System.currentTimeMillis();
//                for(int numRun=0; numRun < MAXRUN; numRun++){ 
//                    big3 = big1.divide(big2); }
//                endTime = System.currentTimeMillis();
//                runTime +=(double) (endTime - startTime)/((double) MAXRUN);
//            }
//            runTime = runTime/((double)MAXNUMINTS);
//
//            System.out.println(runTime);
//        }
        
    }
    
}
