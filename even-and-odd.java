/**
You are given a linked list consisting of even and odd elements. Your task is to bring even elements to the end of the list but there is a twist here. You have to bring even elements to the end of the list in a reverse order.
Input
2
6
4 8 3 2 1 9
5
10 11 15 12 16

Output
3 1 9 2 8 4
11 15 16 12 10
**/
import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        LinkedList list = new LinkedList();
        for(int i=0;i<n;i++){
          int x= sc.nextInt();
          list.add(x);
        }
        list.evenAndOdd();
        list.print();
        System.out.println();
      }
    }
  }
  class Node{
    int val;
    Node next;
    Node(int val){
      this.val = val;
    }
  }
  class LinkedList{
    Node head;
    Node tail;
    void evenAndOdd(){
     // Node even=null;
      Node odd=null;
      Node evenHead=null;
      Node oddHead=null;
      Node curr = head;
      while(curr!=null){
        Node temp = curr.next;
        curr.next = null;
        if(curr.val % 2 ==0){
          if(evenHead==null){
            evenHead = curr;
          }else{
            Node even = evenHead;
            evenHead = curr;
            evenHead.next = even;
          }
        }else{
          if(odd==null){
            odd = curr;
            head = odd;
          }else{
            odd.next = curr;
            odd = odd.next;
          }
        }
        curr = temp;
      }
      if(odd!=null)odd.next = evenHead;
      if(odd==null) head = evenHead;
    }
    
    void add(int x){
      Node temp = new Node(x);
      if(head==null){
        head = temp;
        tail=head;
      }else{
        tail.next = temp;
        tail = tail.next;
      }
    }
    void print(){
      Node curr = head;
      while(curr!=null){
        System.out.print(curr.val+" ");
        curr = curr.next;
      }
    }
  }