/**
Arnab is given a number n.
Help Arnab print all the combination to factorise the number.
Print the combinations in lexiographical order. Please see the example output.

Input
1
8

Output
1 2 2 2
1 2 4
1 8

Approach
1. Initialize an empty string `Str = ""` to store a valid combination of the factorization of the given number.
2. Run a loop from $i = 2$ to $N$, and check whether $i$ is a factor of $N$ or not. If `Yes` append $i$ to `Str` and recursively call for $(N/i)$, such that again run a loop from $j = i$ to $(N/i)$ and check whether $j$ is a factor of $N/i$ or not.   
3. Keep calling recursively till value of $N$ becomes equal to $1$ as $1$ cannot be factorized further.
 */

 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        if(n==1){
          System.out.println("1");
        }else
          func("1",n,1);
      }
    }
    
    public static void func(String str,int n,int fac){
      if(n==1){
        return;
      }
      for(int i=2;i<=n/i;i++){
          if(n%i==0 && i>=fac){
            func(str+" "+i,n/i,i);
            //break;
          }
      }
      System.out.println(str+" "+n);
      
    }
  }