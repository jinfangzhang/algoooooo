/**
 * _35_BinarySearch
 */
public class _35_BinarySearch {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}