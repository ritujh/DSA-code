/**
Reverse in a group
This is another reverse the list problem. You must be thinking, "Its easy , I have already Done it!" But wait, there is a twist.
You have to reverse the list in a group of 
K
 nodes. 
 Input
2
6
1 2 3 4 5 6
2
7
4 8 6 5 7 9 2
3

Ouput
2 1 4 3 6 5
6 8 4 9 7 5 2

//Solved in while-for loop
best way is to solve it by recursion
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
          int x = sc.nextInt();
          list.add(x);
        }
        int k = sc.nextInt();
        list.reverseInAGroup(k);
        //reverseByRecursion(list.head,k); 
        list.print();
        System.out.println();
      }
    }
  }
  class Node{
    int data;
    Node next;
    public Node(int data){
      this.data = data;
    }
  }
  class LinkedList{
    Node head;
    LinkedList(){
      head=null;
    }
	void reverseInAGroup(int k){
	  Node curr = head;
	  head = null;
	  Node prev = null;
		Node nx = null;
		Node tail = curr;
	  while(curr!=null){
	    prev = null;
	    Node temp = curr;
	    for(int i=0;i<k && curr!=null;i++){
	      nx = curr.next;
	      curr.next=prev;
	      prev = curr;
	      curr = nx;
	    }
	    if(head==null)
	      head = prev;
	    else
	      tail.next = prev;
	      tail = temp;
	  }
	}
	void reverse(){
		if(head==null)return;
		Node curr = head;
		Node prev = null;
		Node nx = null;
		while(curr!=null){
			nx = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nx;
		}
		head = prev;
	}
    Node reverseByRecursion(Node head, int k) 
    { 
       Node current = head; 
       Node next = null; 
       Node prev = null; 
         
       int count = 0; 
  
       /* Reverse first k nodes of linked list */
       while (count < k && current != null)  
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           count++; 
       } 
  
       /* next is now a pointer to (k+1)th node  
          Recursively call for the list starting from current. 
          And make rest of the list as next of first node */
       if (next != null)  
          head.next = reverse(next, k); 
  
       // prev is now head of input list 
       return prev; 
    }
	
    void add(int x){
      Node curr = head;
      if(head==null){
        head = new Node(x);
        curr = head;
      }else{
        while(curr.next!=null){
          curr = curr.next;
        }
        curr.next = new Node(x);
      }
    }
    void print(){
      Node curr = head;
      while(curr!=null){
        System.out.print(curr.data+" ");
        curr = curr.next;
      }
    }
  }