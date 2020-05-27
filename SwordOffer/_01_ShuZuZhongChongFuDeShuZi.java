package SwordOffer;

/**
 * _01_ShuZuZhongChongFuDeShuZi
 */
public class _01_ShuZuZhongChongFuDeShuZi {

    public int findRepeatNumber(int[] nums) {
        boolean[] help = new boolean[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (help[nums[i]]) return nums[i];
            help[nums[i]] = true;
        }
        return -1;
    }
}