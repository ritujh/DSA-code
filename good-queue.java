/**
Good Queue
You are given two numbers L and R , and the task is to find the count of GoodQueue numbers in the range [ L , R ] inclusive of L and R . All the digits in the number are distinct. All the digits are less than or equal to 5

 */

 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int L = sc.nextInt();
        int R = sc.nextInt();
        int res = goodQueue(L,R);
        System.out.println(res);
      }
    }
    public static boolean noDuplicate(String str){
      char[] arr = str.toCharArray();
      Set<Character> set = new HashSet<>();
      for(char ch:arr){
        if(set.contains(ch))return false;
        set.add(ch);
      }
      return true;
    }
    public static int goodQueue(int L,int R){
      int count=0;
      Queue<String> que = new LinkedList<>();
      que.add("1");
      que.add("2");
      que.add("3");
      que.add("4");
      que.add("5");
      for(int i=1;i<=R;i++){
        String  str = que.poll();
        int val = Integer.parseInt(str);
        if(noDuplicate(str)){
          que.add(str+"0");
          que.add(str+"1");
          que.add(str+"2");
          que.add(str+"3");
          que.add(str+"4");
          que.add(str+"5");
          if(L<=val && val<=R)
            count++;
        }
        if(val>R){
          break;
        }
      }
      return count;
    }
  }