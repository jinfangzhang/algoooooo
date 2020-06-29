import java.util.*;

/**
 * _40_CombinationSum2
 */
public class _40_CombinationSum2 {

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        _combinationSum2(target, new ArrayList<>(), 0, candidates, res);
        return res;
    }

    private void _combinationSum2(int restValue, List<Integer> list, int index, int[] candidates, List<List<Integer>> res) {
        if (restValue < 0)
            return;

        if (restValue == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            if (i != index && candidates[i] == candidates[i - 1]) continue;

            list.add(candidates[i]);
            _combinationSum2(restValue - candidates[i], list, i + 1, candidates, res);
            list.remove(list.size() - 1);
        }
    }
}