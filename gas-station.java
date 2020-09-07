import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int gas[] = new int[n];
      int cost[] = new int[n];
      for(int i=0;i<n;i++){
        gas[i]=sc.nextInt();
      }
      for(int i=0;i<n;i++){
        cost[i]=sc.nextInt();
      }
      System.out.println(circularRoute(n,gas,cost));
    }
    private static int circularRoute(int n,int[] gas,int[] cost){
      int index=-1;
      if(checkSurplus(n,gas,cost)){
        for(int i=0;i<n;i++){
          if(gas[i]>cost[i] && helper(n,gas,cost,i)){
            index=i;
            break;
          }
        }
      }
      return index;
    }
    private static boolean helper(int n,int[] gas,int[] cost,int index){
      long tank=0;
      for(int i=index;i<n+index;i++){
        int x = i%n;
        tank+=gas[x]-cost[x];
        if(tank<0)
          return false;
      }
      return true;
    }
    private static boolean checkSurplus(int n,int[] gas,int[] cost){
      long diff =0;
      for(int i=0;i<n;i++){
        diff+=gas[i]-cost[i];
      }
      if(diff<0){
        return false;
      }
      return true;
    }
    
  }