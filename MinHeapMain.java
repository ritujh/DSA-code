import java.util.*;
  import java.io.*;
  
 public class MinHeapMain {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        MinHeap minheap = new MinHeap(n);
        for(int i=0;i<n;i++){
          int x = sc.nextInt();
          minheap.insert(x);
        }
        //minheap.printHeap();
        //System.out.println();
        System.out.print(minheap.extractMin()+" ");
        minheap.printHeap();
        System.out.println();
      }
    }
  }
  class MinHeap{
    int[] heap;
    int size;
    int capacity;
    MinHeap(int capacity){
      capacity = capacity;
      size=0;
      heap = new int[capacity+1];
      heap[0] = Integer.MAX_VALUE;
    }
    private int parent(int i){
      return i/2;
    }
    private void swap(int a, int b){
      int t = heap[a];
      heap[a] = heap[b];
      heap[b]=t;
    }
    void insert(int val){
      heap[++size] = val;
      int i = size;
      while(i>1 && heap[parent(i)]>heap[i]){
        swap(parent(i),i);
        i = parent(i);
      }
    }
    void printHeap(){
      for(int i=1;i<=size;i++){
        System.out.print(heap[i]+" ");
      }
    }
    private boolean isLeaf(int key){
      if(key>size/2 && key<=size)
        return true;
      return false;
    }
    private void minHeapify(int key){
      if(isLeaf(key)){
        return;
      }
      int i = key;
      int lc = 2*i<=size?2*i : 0;
      int rc = (2*i+1)<=size? (2*i+1) : 0;
      int smallest = i;
      if(heap[lc]<heap[i] && heap[lc]<=heap[rc]){
        smallest = lc;
      }
      if(heap[rc]<heap[i] && heap[rc]<heap[lc]){
        smallest = rc;
      }
      if(i!=smallest){
        swap(i,smallest);
        minHeapify(smallest);
      }
    }
    public int extractMin(){
      int ans = heap[1];
      swap(1,size);
      size--;
      minHeapify(1);
      return ans;
    }
    
    
    
  }