/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Input: "A man, a plan, a canal: Panama"
Output: true

Input: "race a car"
Output: false

Constraints:
s consists only of printable ASCII characters.
 */

 class Solution {
    public boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(!isAlphanumeric(str.charAt(l))){
                l++;
            }else if(!isAlphanumeric(str.charAt(r))){
                r--;
            }else{
                if(sl!=sr)
                    return false;
                
            }
        }
        return true;
    }
    public boolean isAlphanumeric(char ch){
        if((ch>='a' && ch<='z')||(ch>='A' && ch<='Z')||(ch>='0' && ch<='9')){
            return true;
        }
        return false;
    }
}