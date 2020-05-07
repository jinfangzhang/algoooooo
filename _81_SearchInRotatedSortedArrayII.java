/**
 * _81_SearchInRotatedSortedArrayII
 * 当需要考虑的东西越来越多时，就应该首先对没有歧义的部分的进行考虑，
 * 对于剩下部分使用保守逻辑，将更为恰当
 */
public class _81_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = (l + r) >> 1;
            if(nums[l] < nums[mid]) {
                if(nums[l] <= target && target < nums[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else if (nums[l] > nums[mid]) {
                if(nums[mid] <= target && target <= nums[r - 1])
                    l = mid;
                else
                    r = mid;
            } else {
                if(nums[mid] == target)
                    return true;
                else
                    l = l + 1;
            }
        }
        return false;
    }
}