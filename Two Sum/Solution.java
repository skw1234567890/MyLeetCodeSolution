/*
 Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution.
 
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        
        //use a map to record the number and index pair
        Map<Integer, Integer> record = new HashMap<>();
        
        for(int i = 0; i < l; i++){
            //check if the diff exits, if so, we find two numbers, just return their indices
            if(record.containsKey(target - nums[i])){
                return new int[]{record.get(target - nums[i]) + 1, i + 1};
            //otherwise, update the map
            } else{
                record.put(nums[i], i);
            }
        }
        
        //the case if we don't find those numbers
        return null;
    }
}
