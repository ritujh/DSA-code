/**
Pascal's Triangle II

Solution
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */

 class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i=1;i<=rowIndex;i++){
            for(int j=i-1;j>0;j--){
                res.set(j,res.get(j)+res.get(j-1));
            }
            res.add(1);
        }
        return res;
    }
}