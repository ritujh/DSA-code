/**
Vowel and Consonants
You are given a linked list consisting of vowels and consonants. The vowels and consonants are arranged in random order. You have to rearrange the array such that all the vowel's node come before the consonants and make sure that their order of appearance should match with that of original list.

Input
2
4
m o d i
7
a z e y i o w

Output
o i m d
a e i o z y w
 */

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
          char ch = sc.next().charAt(0);
          list.add(ch);
        }
        list.VowelsAndConsonants();
        list.print();
        System.out.println();
      }
    }
  }
  class Node{
    char ch;
    Node next;
    Node(char ch){
      this.ch = ch;
    }
  }
  class LinkedList{
    Node head;
    Node tail;
    void VowelsAndConsonants(){
      Node consonantHead=null;
      Node vowel=null;
      Node consonant=null;
      Character[] arr = {'a','e','i','o','u'};
      Set<Character> set = new HashSet<>(Arrays.asList(arr));
      Node curr = head;
      while(curr!=null){
        Node temp = curr.next;
        curr.next = null;
        if(set.contains(curr.ch)){
          if(vowel==null){
            vowel = curr;
            head = vowel;
          }else{
            vowel.next = curr;
            vowel = vowel.next;
          }
        }else{
          if(consonant==null){
            consonant = curr;
            consonantHead = consonant;
          }else{
            consonant.next = curr;
            consonant = consonant.next;
          }
        }
        curr = temp;
      }
      if(vowel!=null)vowel.next = consonantHead;
    }
    void add(char ch){
      Node temp = new Node(ch);
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
        System.out.print(curr.ch+" ");
        curr = curr.next;
      }
    }
  }