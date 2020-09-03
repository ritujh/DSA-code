/**
Redundant Braces
You are given a mathematical formula consisting of '*', '-', '+', '/'. The formula also contains brackets '()'. These formulas are given as assignments to the students for evaluation but the Teacher has made a small mistake while preparing the assignment. He has added redundant braces.

If the formula is ((a+b))+c, you can see there is an extra bracket around a+b, which means this formula has 1 redundant bracket.

Your task is to find whether the given formula consists of a redundant bracket or not.

Output Format
Output contains the 
0
 or 
1
 depending upon whether redundant brackets are there or not.
I: ((a+b))
O: 1

I:((a))
O:1

*/
 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      String str = sc.next();
      System.out.println(redundantBracket(str));
    }
    public static int redundantBracket(String str){
      Stack<Character> stack = new Stack<>();
      for(char ch : str.toCharArray()){
        if(ch==')'){
          if(stack.peek()=='(')return 1;
          while(stack.isEmpty()==false && stack.peek()!='('){
            stack.pop();
          }
          stack.pop();
        }else{
          if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='(')
            stack.push(ch);
        }
      }
      return 0;
    }
  }