import java.util.HashMap;
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int i:map.keySet()){
            int complement=k-i;
            if(!map.containsKey(complement)){
                continue;
            }
            if(i==complement){
                count+=map.get(i)/2;
            }
            else{
                count+=Math.min(map.get(i),map.get(complement));
            }
            map.put(i,0);
            map.put(complement,0);
        }
        return count;
    }
}