/**
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Input: "USA"
Output: True

Input: "FlaG"
Output: False
** */

class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstCap = word.charAt(0)>=65 && word.charAt(0)<=90? true : false;
        boolean secondCap = false;
        if(word.length()>1){
            secondCap = word.charAt(1)>=65 && word.charAt(1)<=90? true : false;
        }else{
            return true;
        }
        for(int i=2;i<word.length();i++){
            char ch = word.charAt(i);
            if(secondCap){
                if(ch>=65 && ch<=90){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(ch>=65 && ch<=90){
                    return false;
                }
            }
        }
        return firstCap ? true : !secondCap;
    }
}