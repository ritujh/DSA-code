/**
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */

class WordDictionary {
    class Node{
        Node[] children = new Node[26];
        boolean isEnd;
    }
    /** Initialize your data structure here. */
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr = root;
        char[] arr = word.toCharArray();
        for(char ch:arr){
            int index = ch-'a';
            if(curr.children[index]==null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isEnd=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return  search(word,0,root);
    }
    public boolean search(String word,int i, Node curr) {
        if(curr==null){
            return false;
        }
        if(i==word.length()){
            return curr.isEnd;
        }
        char ch = word.charAt(i);
        if(ch=='.'){
            for(int j=0;j<26;j++){
                if(search(word,i+1,curr.children[j])){
                    return true;
                }
            }
        }else{
            if(search(word, i+1, curr.children[ch-'a'])) 
                return true;
        }
        return false;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */