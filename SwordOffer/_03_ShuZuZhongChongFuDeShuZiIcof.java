package SwordOffer;

/**
 * _03_ShuZuZhongChongFuDeShuZiIcof
 */
public class _03_ShuZuZhongChongFuDeShuZiIcof {
    
    public int findRepeatNumber(int[] nums) {
        boolean[] help = new boolean[nums.length];
        for (int num : nums) {
            if(help[num]) return num;
            help[num] = true;
        }
        return -1;
    }
}