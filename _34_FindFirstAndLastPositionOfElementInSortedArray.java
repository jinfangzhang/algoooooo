/**
 * FindFirstAndLastPositionOfElementInSortedArray
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        targetRange[0] = searchFirst(nums, target);

        if (targetRange[0] == -1) {
            return targetRange;
        }
        
        targetRange[1] = searchLast(nums, target);
        return targetRange;
    }

    public int searchFirst(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target == arr[mid]) {
                if (mid - 1 < 0 || arr[mid - 1] != target) return mid;
                else r = mid;
            } else if (target > arr[mid]) l = mid + 1;
            else r = mid;
        }
        return -1;
    }

    public int searchLast(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target == arr[mid]) {
                if (mid + 1 >= arr.length || arr[mid + 1] != target) return mid;
                else l = mid + 1;
            } else if (target > arr[mid]) l = mid + 1;
            else r = mid;
        }
        return -1;
    }
}
在这里，base64编码的设置是一个帧有效载荷，
它已经被base64url编码，所有尾随的等于字符都被删除，
以便安全地将它包含在这个文本头格式中