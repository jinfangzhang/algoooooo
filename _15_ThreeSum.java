/**
 * _15_ThreeSum
 */
import java.util.*;

public class _15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0)
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));

                if (sum <= 0)
                    while (start < end && nums[start] == nums[++start]) ;
                else
                    while (start < end && nums[end] == nums[--end]) ;
            }
        }
        return res;
    }
    
}