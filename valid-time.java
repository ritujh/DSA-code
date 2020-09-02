/**
Largest Time for Given Digits

Solution
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

HINT:-
    -> find all permutation
    -> filter to valid time
    -> valid time boolean function
    -> sort valid time arr, and get the max
    -> return answer in correct order 

Input: [1,2,3,4]
Output: "23:41"

Input: [5,5,5,5]
Output: ""
 */

 class Solution {
    public String largestTimeFromDigits(int[] A) {
        String str = "";
        List<String> perArr = new ArrayList<>();
        permutation(A,0,perArr);
        List<String> valid = isValid(perArr);
        Collections.sort(valid);
        int n = valid.size();
        if(n>0){
            String num = valid.get(n-1);
            str =num.substring(0,2) +":"+num.substring(2);
        }
        return str;
    }
    public List<String> isValid(List<String> perArr){
        List<String> res = new ArrayList<>();
        for(String num:perArr){
            if(isValidTime(num)){
                res.add(num);
            }
        }
        return res;
    }
    public boolean isValidTime(String num){
        if(num.charAt(0)>'2')return false;
        if(num.charAt(0)=='2'){
            if((num.charAt(1)) >='4')return false;
        }
        if(num.charAt(2) >='6')return false;
        return true;
    }
    public void permutation(int[] A,int k,List<String> perArr){
        if(k>=4){
            String num ="";
            for(int i:A){
                num += i;
            }
            perArr.add(num);
            return;
        }
        for(int i=k;i<4;i++){
            swap(A,i,k);
            permutation(A,k+1,perArr);
            swap(A,i,k);
        }
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j]=temp;
    }
}