/**
Excel Sheet Column Number

Solution
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

    Input: "ZY"
    Output: 701

HINT = num = x1 + 26*x2 + 26^2 *x3 + 26^3 *x4 +....
 */

 class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int num=0;
        for(int i=0;i<n;i++){
            char last = s.charAt(n-1-i);
            int val = last - 64;
            num+= Math.pow(26,i)*val;
        }
        return num;
    }
}