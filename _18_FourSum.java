import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class _18_FourSum {

    public List<List<Integer>> fourSum_28ms(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j != i + 1 && nums[j - 1] == nums[j]) continue;
                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                    if (sum <= target)
                        while (start < end && nums[start] == nums[++start]) ;
                    else
                        while (start < end && nums[end] == nums[--end]) ;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum_14ms(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;


        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            int sum = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (sum > target) break;

            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j != i + 1 && nums[j - 1] == nums[j]) continue;
                sum = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (sum > target) break;

                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                    if (sum <= target)
                        while (start < end && nums[start] == nums[++start]) ;
                    else
                        while (start < end && nums[end] == nums[--end]) ;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum_4ms(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            int sum = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (sum > target) break;

            sum = nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (sum < target) continue;

            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j != i + 1 && nums[j - 1] == nums[j]) continue;
                sum = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (sum > target) break;

                sum = nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1];
                if (sum < target) continue;

                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                    if (sum <= target)
                        while (start < end && nums[start] == nums[++start]) ;
                    else
                        while (start < end && nums[end] == nums[--end]) ;
                }
            }
        }
        return res;
    }
}