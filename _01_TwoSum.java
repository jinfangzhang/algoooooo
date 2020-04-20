import java.util.HashMap;
import java.util.Map;

/**
 * tip: 不能因为题目简单而停止思考直接写答案.
 *      任何的算法都是一步一步推理出来的.
 */
public class _01_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            int res = target - nums[i];
            map.put(res, i);
        }
        return new int[2];
    }
}