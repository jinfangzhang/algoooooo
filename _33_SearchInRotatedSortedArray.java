/**
 * _33_SearchInRotatedSortedArray
 */
public class _33_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[0] < nums[mid]) { //mid 左边是有序的
                    if (nums[l] <= target && target < nums[mid]) {//在左边
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                } else { //mid 右边是有序的
                    if (nums[mid] < target && target <= nums[r - 1]) {//在右边
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
            }
        }
        return -1;
    }
}