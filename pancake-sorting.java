/**
Pancake Sorting
Given an array of integers A, We need to sort the array performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 0 <= k < A.length.
Reverse the sub-array A[0...k].

HINT: kind of like bubble-sort, find max, flip to put it first then flip to put it at last


Input: A = [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k = 4): A = [1, 4, 2, 3]
After 2nd flip (k = 2): A = [4, 1, 2, 3]
After 3rd flip (k = 4): A = [3, 2, 1, 4]
After 4th flip (k = 3): A = [1, 2, 3, 4], which is sorted.
Notice that we return an array of the chosen k values of the pancake 

 */
 class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        pancakeSort(A,0,A.length-1,res);
        return res;
    }
    public void pancakeSort(int[] A, int l, int r, List<Integer> res){
        if(l<r){
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for(int i=l;i<=r;i++){
                if(max<A[i]){
                    max = A[i];
                    maxIndex = i;
                }
            }
            if(maxIndex!=r){
                if(maxIndex!=0){
                    res.add(maxIndex+1);
                    reverse(A,l,maxIndex);
                }
                res.add(r+1);
                reverse(A,l,r);
            }
            pancakeSort(A,0,r-1,res);
        }
    }
    public void reverse(int[] A, int l, int r){
        while(l<r){
            int temp=A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }
}