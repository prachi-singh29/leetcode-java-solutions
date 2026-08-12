import java.util.HashMap;
class Solution {
    public int majorityElement(int[] nums) {
        int len=nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num)>len) {
                return num;
            }
        }
        return -1;
    }
}