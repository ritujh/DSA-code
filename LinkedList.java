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
        list.removeDuplicate(list.head);
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
	void insert(int x){
		if(head==null){
			head = new Node(x);
			return;
		}
		Node curr = head;
		Node temp = new Node(x);
		if(curr.data > x){
			temp.next = curr;
			head = temp;
		}else{
			while(curr.next!=null && curr.next.data<x){
				curr = curr.next;
			}
			temp.next  = curr.next;
			curr.next = temp;
		}
	}
    void removeDuplicate(Node curr){
      while(curr!=null && curr.next!=null){
          if(curr.data == curr.next.data){
            curr.next = curr.next.next;
          }else{
            curr = curr.next;
          }
      }
    }
  }