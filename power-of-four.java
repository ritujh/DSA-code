/**
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
 */

 class Solution {
    public boolean isPowerOfFour(int num) {
        if((num&(num-1))==0){
            while(num>0){
                if((num&1)==1){
                    return true;
                }
                num = num>>2;
            }
        }
        return false;
    }
}

class Solution {
    public boolean isPowerOfFour(int num) {
        //0x55555555 in 32bit places 1at odd place
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}