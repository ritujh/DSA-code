/**
Evaluate the expression
You are given postfix representation of an algebraic expression. Your task is to evaluate the expression and output the result.

Postfix expression contains, space separated +, -, /, * and integer numbers 

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

leetcode:-https://leetcode.com/problems/evaluate-reverse-polish-notation/

Hint-> solve it via stack
        -> on every opration, pop out last two integer fron stack and do opration
        -> push back the result
        ->in last only integer will remain
        -> return that
    -> to check a string is integer; write a function to check each char in string is '0'>=ch and ch<='9' && also check for '-';
 */

import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      String[] arr = new String[n];
      for(int i=0;i<n;i++){
        String str = sc.next();
        arr[i] = str;
      }
      long num = evaluateExp(arr);
      System.out.println(num);
    }
    public static long evaluateExp(String[] arr){
      int n = arr.length;
      Stack<Long> stk = new Stack<>();
      for(int i=0;i<n;i++){
        String str = arr[i];
        if(isInteger(str)){
          long val = Integer.parseInt(str);
            //System.out.println(val);
          stk.push(val);
        }else{
          char ch = str.charAt(0);  
          long x = stk.pop();
          long y = stk.pop();
            //System.out.println(x +" "+ ch +" "+ y);
          long val=0;
          if(ch=='+') val = y+x;
          if(ch=='-') val = y-x;
          if(ch=='*') val = y*x;
          if(ch=='/') val = y/x;
          stk.push(val);
        }
      }
      return stk.peek();
    }
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
  }