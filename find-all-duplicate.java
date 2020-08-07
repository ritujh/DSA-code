/**
Find All Duplicates in an Array

Solution
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

 class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            int ab = Math.abs(num);
            if(nums[ab-1]<0){
                res.add(ab);
            }
            nums[ab-1] = -1*nums[ab-1];
        }
        return res;
    }
}