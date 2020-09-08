/**
Mass of molecules
PrepBuddy is quite good at maths but is bad at chemistry. He got the task of finding the mass of given molecules.
All the molecules that he gets are having only three atoms H i.e hydrogen atom, O i.e oxygen atom and C i.e. carbon atom.
Each of them has mass 1, 16 and 12 respectively.

The Chemistry teacher was feeling sleepy while he was creating the assignment so he has used several representations of the formula. So, if the molecule is COOHH it means it has 1 atom of carbon, one atom of oxygen and 2 atoms of hydrogen and it can also be written as CO2H2 or CO(OH)H or CO2(H2).

Note: Formula will only contain C, H, O , (, ), 1, 2,3,4,5,6,7,8,9.

Input
COOH
Output
45

HINT: Test your code for cases like (OHC(CH(O)9)7)2, Correct answer will be 2256

 */

 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      String str = sc.next();
      Stack<Integer> stack = new Stack();
      Map<Character,Integer> map = new HashMap<>();
      map.put('H',1);
      map.put('C',12);
      map.put('O',16);
      int mw = 0;
      for(char ch : str.toCharArray()){
        if(ch=='C'||ch=='H'||ch=='O'){
          stack.push(map.get(ch));
        }else if('1'<=ch && ch<='9' && !stack.isEmpty()){
          int top = stack.pop();
          int x = Integer.parseInt(""+ch);
          stack.push(top*x);
        }else{
          if(ch=='(')stack.push(-1);
          else if(ch==')'){
            int sum = 0;
            while(!stack.isEmpty() && stack.peek()!=-1){
              sum+=stack.pop();
            }
            stack.pop();
            stack.push(sum);
          }
        }
      }
      while(!stack.isEmpty()){
        mw+=stack.pop();
      }
       System.out.println(mw);
    }
  }