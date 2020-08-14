/**
Iterator for Combination

Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 */

 class CombinationIterator {
    Queue<String> que;
    public CombinationIterator(String characters, int combinationLength) {
        que = new LinkedList<>();
        generateQue(characters,0,combinationLength,new String());
    }
    public void generateQue(String str,int i, int k, String s){
        if(k==0){
            que.add(s);
            return;
        }
        if(i<str.length()){
            char ch = str.charAt(i);
            //System.out.println(i+" : "+sb.append(ch));
            generateQue(str,i+1,k-1,s+ch);
            generateQue(str,i+1,k,s);   
        }
        
    }
    public String next() {
        return que.poll();
    }
    
    public boolean hasNext() {
        return !que.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */