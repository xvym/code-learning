package cn.com.xvym.learning.leetcode.no039;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xv
 * @Date: 2021/6/5 1:05
 * @Description:
 */
@Slf4j
public class No039Test {

    private int[] candidates = {2, 3, 6, 7};

    private int target = 7;

    @Test
    public void test() {
        List<List<Integer>> res = combinationSum(candidates, target);
        res.forEach(o -> {
            log.info("----------------");
            for (Integer num : o) {
                log.info(String.valueOf(num));
            }
            log.info("----------------");
        });
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();
        backtrace(target, 0, curRes, res, candidates);
        return res;
    }

    public void backtrace(int curTarget, int i, List<Integer> curRes, List<List<Integer>> res, int[] candidates) {
        if (i == candidates.length) {
            return;
        }
        if (curTarget == 0) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        backtrace(curTarget, i + 1, curRes, res, candidates);
        if (curTarget >= candidates[i]) {
            curRes.add(candidates[i]);
            curTarget -= candidates[i];
            backtrace(curTarget, i, curRes, res, candidates);
            curRes.remove(curRes.size() - 1);
        }
    }
}
