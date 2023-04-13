import java.util.*;
public class day1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int res = target-nums[i];
            if(m.containsKey(res)){
                result[0] = m.get(res);
                result[1] = i;
                break;
            }
            else{
                m.put(nums[i] , i);
            }
        }
        return result;
    }
}
