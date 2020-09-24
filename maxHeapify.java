import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int k = sc.nextInt();
        MaxHeap heap = new MaxHeap(n);
        for(int i=0;i<n;i++){
          int x = sc.nextInt();
          //System.out.println(x);
          heap.insert(x);
        }
        //heap.printHeap();
        int maxK=0;
        while(k-->0){
          maxK = heap.extractMax();
        }
        //heap.printHeap();
        System.out.println(maxK);
      }
    }
  }
  class MaxHeap{
    int[] heap;
    int cap;
    int size;
    public MaxHeap(int c){
      cap = c;
      size = 0;
      heap = new int[c+1];
      heap[0]= Integer.MAX_VALUE;
    }
    int parent(int i){
      return i/2;
    }
    int leftChild(int i){
      return 2*i>size?-1:2*i;
    }
    int rightChild(int i){
      return 2*i+1>size?-1:2*i+1;
    }
    void swap(int a, int b){
      int temp = heap[a];
      heap[a]=heap[b];
      heap[b] = temp;
    }
    public void insert(int val){
      heap[++size]=val;
      int x = size;
      int i = parent(x);
      while(i>0 && heap[i]<heap[x]){
        swap(i,x);
        x = i;
        i = parent(x);
      }
    }
    public int extractMax(){
      int ans = heap[1];
      swap(1,size);
      size--;
      maxHeapify(1);
      return ans;
    }
    void maxHeapify(int i){
      int max = i;
      int lc = leftChild(i);
      int rc = rightChild(i);
      if(lc!=-1 && heap[lc]>heap[max]){
        max=lc;
      }
      if(rc!=-1 && heap[rc]>heap[max]){
        max=rc;
      }
      if(max!=i){
        swap(max,i);
        maxHeapify(max);
      }
    }
    public void printHeap(){
      for(int i=1;i<=size;i++){
        System.out.print(heap[i]+" ");
      }
      System.out.println();
    }
    
  }