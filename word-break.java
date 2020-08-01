/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 
 Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
 
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]

 **/

class Solution {
   public List<String> wordBreak(String s, List<String> wordDict) {  
       HashMap<Integer, List<String>> hm = new HashMap<>(); 
       HashSet<String> hs = new HashSet<>(wordDict);
       return wordBreakHelper(s, 0, hs, hm);
}

private List<String> wordBreakHelper(String s, int start, HashSet<String> dict, HashMap<Integer, List<String>> hm ) {

    if (hm.containsKey(start))
        return hm.get(start); 

    List<String> validSubstr = new ArrayList<>();

    if (start == s.length())
        validSubstr.add("");

    for (int end = start + 1; end <= s.length(); end++) {
        String prefix = s.substring(start, end);
        if (dict.contains(prefix)) {
            List<String> suffixes = wordBreakHelper(s, end, dict, hm);
            for (String suffix : suffixes)
               validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix); 
        }
    }
 
    hm.put(start, validSubstr);
    return validSubstr;
 }
}