/**
 * _16_ThreeSumClosest
 */
import java.util.*;

public class _16_ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;

                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
        int target = 0;

        _16_ThreeSumClosest instance = new _16_ThreeSumClosest();
        System.out.println(instance.threeSumClosest(arr, target));
    }
}