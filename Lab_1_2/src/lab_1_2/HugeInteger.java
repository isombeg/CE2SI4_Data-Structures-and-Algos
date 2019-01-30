/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_1_2;

import java.lang.Math;
/**
 *
 * @author TheYo
 */
public class HugeInteger {
    private String value;
    private boolean isPos;
    
    public HugeInteger(String val) throws RuntimeException {
        
        //Determine whether integer is negative or not
        if(val.charAt(0) == '-'){
            isPos = false;
            val = val.substring(1);
        }
        
        else isPos = true;
        
        //Argument is invalid if not number is passed
        if(val.compareTo("") == 0) throw new RuntimeException("Invalid argument");
        
        for(int index = 0; index < val.length(); index++){
            
            //Argument is invalid if there is a non digit character within argument
            if(val.charAt(index) < '0' || val.charAt(index) > '9')
                throw new RuntimeException("Invalid argument");
            
            //Once all beginning zeroes are encountered, store rest of string within value
            else if(val.charAt(index) != '0' || index == val.length() - 1){
                value = val.substring(index);
                break; //end for lood
            }
            
        }
        
        //verify that all characters within string are digits
        for(char digit : value.toCharArray())
            if (digit < '0' || digit > '9') 
                throw new RuntimeException("Invalid argument");
        
    }
    
    public HugeInteger(int n) throws RuntimeException {
        if(n <= 0) throw new RuntimeException("Invalid argument");
        
        isPos = (int)(10*Math.random()) % 2 == 0 ? true : false;
        
        value = "" + ((int)(10*Math.random()) + 48); //concatenate random integer to value
        
        while(value.charAt(0) == '0'){
            value.replace('0', (char)((int)(10*Math.random()) + 48));
        }
        
        for(int index = 1; index < n; index++)
            value += (int)(10*Math.random()); //concatenate random integer to value
    }
    
    public int compareTo(HugeInteger h){
        
        //Case where signs differ
        if(isPos != h.isPos)
            return isPos == true ? 1 : -1; 
        
        //Protocol for when the signs are the same
        else{
            
            //Case where the number of digits differ
            if(value.length() != h.value.length()){
                return (value.length() > h.value.length()) == (isPos == true)? 1 : -1;
            }
            
            // Case where both integers have the same number of digits
            else{
                for(int index = 0; index < value.length(); index++){
                    
                    if(value.charAt(index) != h.value.charAt(index))
                        return (value.charAt(index) > h.value.charAt(index)) == (isPos == true) ? 1 : -1;
                }
                
                return 0;
            }
            
        }
        
        
    }
    
    public HugeInteger add(HugeInteger h){
        
        //Protocol when signs are the same
        if(isPos == h.isPos){
            HugeInteger longer, shorter;
        
            //determining greater and lesser integer
            if(this.compareTo(h) == 1 || this.compareTo(h) == 0){
                longer = this;
                shorter = h;
            }

            else{
                longer = h;
                shorter = this;
            }

            //allocate memory for resulting number
            char[] rslt = new char[longer.value.length() + 1];

            //store zeroes within array
            for(int index = 0; index < rslt.length; index++)
                rslt[index] = '0';

            for(int index = rslt.length - 1; index > 0; index--){

                //Protocol when dealing with two digits
                if(index > longer.value.length() - shorter.value.length()){
                    int tempVar = longer.value.charAt(index - 1) + shorter.value.charAt(index - longer.value.length() + shorter.value.length() - 1) - 2*48;

                    if((rslt[index] + tempVar) % 48 < 10) rslt[index] += tempVar; //protocol when carry over is not required
                    
                    //Protocol when carry over is required
                    else{

                        rslt[index] = rslt[index] + tempVar % 10 <= 57 ? (char)(rslt[index] + tempVar % 10) : (char)(rslt[index] + tempVar % 10 - 10);

                        rslt[index - 1]++;
                        int backs = 1;

                        while(rslt[index - backs] == ':'){
                            rslt[index - backs++] = '0';
                            rslt[index - backs]++;
                        }
                    }

                }

                //Protocol when dealing with one digit is required
                else{
                    int tempVar = longer.value.charAt(index - 1) - 48;

                    if((rslt[index] + tempVar) % 48 < 10) rslt[index] += tempVar;
                    else{

                        rslt[index] = rslt[index] + tempVar % 10 <= 57 ? (char)(rslt[index] + tempVar % 10) : (char)(rslt[index] + tempVar % 10 - 10);

                        rslt[index - 1]++;
                        int backs = 1;

                        while(rslt[index - backs] == ':'){
                            rslt[index - backs++] = '0';
                            rslt[index - backs]++;
                        }
                    }
                }


            }

            return new HugeInteger(isPos == true ? new String(rslt) : '-' + new String(rslt));
        }
        
        else if(isPos == false) return h.subtract(new HugeInteger(value)); //leverage subtract when this is a negative integer
        else return this.subtract(new HugeInteger(h.value)); //leverage subtract when h is a negative integer
        
        
    }
    
    public HugeInteger subtract(HugeInteger h){
        
        //Protocol when signs match
        if(isPos == h.isPos){
            
            HugeInteger longer, shorter;
            char[] rslt;
            
            //return 0 if numbers are the same
            if(this.compareTo(h) == 0) return new HugeInteger("0");
            
            //assignment when this is greater and positive
            else if(this.compareTo(h) == 1 && isPos == true){
                longer = this;
                shorter = h;
                rslt = new char[longer.value.length()];
            }

            //assignment otherwise
            else{
                longer = h;
                shorter = this;
                rslt = new char[longer.value.length()];
            }

            for(int index = 0; index < rslt.length; index++)
                rslt[index] = '0';
            
            int tempVar;
            
            for(int index = rslt.length - 1; index >= 0; index--){
                
                //case when dealing with one digit
                if(index - longer.value.length() + shorter.value.length() < 0){
                    rslt[index] += (char)(longer.value.charAt(index) - 48);
                    continue;
                }
                
                tempVar = longer.value.charAt(index) - shorter.value.charAt(index - longer.value.length() + shorter.value.length());
                
                //adding difference to appropriate index of rslt when it is positive
                if(tempVar >= 0) rslt[index] += (char)(tempVar);
                
                //protocol when difference is negative
                else{
                    int x = 1;
                    rslt[index] += (char)(tempVar + 10);
                    rslt[index - 1]--;
                    
                    while(index - x > 0 && rslt[index - x] == '/' && index - x - longer.value.length() + shorter.value.length() < 0){
                        rslt[index - x++] += 10;
                        rslt[index - x]--;
                    }
                }
            }
            
            return new HugeInteger(compareTo(h) == 1 ? new String(rslt) : '-' + new String(rslt));
            
        }
        
        else if(isPos == true) return add(new HugeInteger(h.value)); //leverage add when h is negative and this is positive
        else return new HugeInteger("0").subtract(h.add(new HugeInteger(this.value))); //leverage add when this is negative and h is negative
        
    }
    
    public String toString(){
        return isPos == true ? value : '-' + value;
    }
}
