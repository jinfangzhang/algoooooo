import java.util.*;

/**
 * _39_CombinationSum
 */
public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        _combinationSum(target, new ArrayList<>(), 0, candidates, res);
        return res;
    }

    public void _combinationSum(int restValue, List<Integer> list, int index, int[] candidate, List<List<Integer>> res) {
        if (restValue < 0)
            return;

        if (restValue == 0) {
            List<Integer> singleList = new ArrayList<>(list);
            res.add(singleList);
            return;
        }

        for (int i = index; i < candidate.length; ++i) {
            list.add(candidate[i]);
            _combinationSum(restValue - candidate[i], list, i, candidate, res);
            list.remove(list.size() - 1);
        }
    }
}