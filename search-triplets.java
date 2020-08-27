/**
PrepBud has an array of integers. She was going through the numbers of the array and suddenly she realized there exist triplets in the array such that the sum of two elements equals the third element(not particularly in any order). She created a problem statement for you out of this situation. Given an array of distinct integers find out a triplet that satisfies the given condition.
 
 Input
2
5
20 40 30 50 70
4
29 15 13 30

Output
70 20 50
-1
 
 */

 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
          arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for(int i=n-1;i>0 && list.size()==0;i--){
          list = findPair(arr,0,i-1,arr[i],list);
        }
        
          System.out.println(list.size()>0 ? 
            list.get(0)+" "+list.get(1)+" "+list.get(2) : -1);
        
      }
      
    }
    public static List<Integer> findPair(int[] arr, int l,int r,int sum,List<Integer> list){
      while(l<r){
        if(arr[l]+arr[r]==sum){
          list.add(sum);
          list.add(arr[l]);
          list.add(arr[r]);
          break;
        }
        if(arr[l]+arr[r]<sum){
          l++;
        }else if(arr[l]+arr[r]>sum){
          r--;
        }
      }
      return list;
    }
    
    
    
  }