package cn.com.xvym.learning.leetcode.no279;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Xv
 * @Date: 2021/6/30 0:32
 * @Description:
 */
@Slf4j
public class No279Test {


    @Test
    public void test() {
        System.out.println(numSquares(64));
    }

    private Integer res;

    public int numSquares(int n) {
        res = n;
        List<Integer> elements = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            elements.add(i * i);
        }

        backtrace(n, elements, 0, 0);

        return res;

    }

    public void backtrace(int n, List<Integer> elements, int curCount, int curSum) {
        if (curSum >= n) {
            if (curSum == n) {
                res = Math.min(curCount, res);
            }
            return;
        }
        for (int element : elements) {
            backtrace(n, elements, curCount + 1, curSum + element);
        }
    }
}
