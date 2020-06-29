/**
 * _31_NextPermutation
 */
public class _31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1])
                break;
            i--;
        }

        for (int k = nums.length - 1; k >= i && i != 0; --k) {
            if (nums[k] > nums[i - 1]) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[k];
                nums[k] = tmp;
                break;
            }
        }

        Arrays.sort(nums, i, nums.length);
    }
}