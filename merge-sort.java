/**
Merge Sort
PrepBuddy is given an array of integers of size 
N
.
He is challenged to sort the array using the Merge Sort algorithm.

Please help him implement the merge sort.
 */
 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
          arr[i] = sc.nextInt();
        }
        mergeSort(0,n-1,arr);
        for(int i:arr){
          System.out.print(i+" ");
        }
      }
      
    }
    public static void mergeSort(int start,int end, int[] arr){
      int mid = start + (end-start)/2;
      if(start<end){
        mergeSort(start,mid,arr);
        mergeSort(mid+1,end,arr);
        merge(start,end,mid,arr);
      }
    }
    public static void merge(int start,int end,int mid, int[] arr){
      int l1 =mid-start+1;
      int r1 = end-mid;
      int left[] = new int[l1];
      int right[] = new int[r1];
      for(int i=0;i<l1;i++){
        left[i]=arr[i+start];
      }
      for(int i=0;i<r1;i++){
        right[i]=arr[i+mid+1];
      }
      int l=0;
      int r=0;
      int k=start;
      while(l<l1 && r<r1){
        if(left[l]<=right[r])
          arr[k++]=left[l++];
        else
          arr[k++]=right[r++];
      }
      while(l<l1){
        arr[k++]=left[l++];
      }
      while(r<r1){
        arr[k++]=right[r++];
      }
    }
  }