package cn.com.xvym.learning.leetcode.no056;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Xv
 * @Date: 2021/5/31 22:18
 * @Description:
 */
@Slf4j
public class No056Test {

    private int[][] intervals = {{1, 4}, {0, 4}};

    @Test
    public void test() {
        int[][] res = merge(intervals);
        for (int[] interval : res) {
            log.info(String.valueOf(interval[0]));
            log.info(String.valueOf(interval[1]));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int length = intervals.length;
        int[][] temp = new int[length][2];
        temp[0][0] = intervals[0][0];
        temp[0][1] = intervals[0][1];
        int j = 0;
        for (int i = 1; i <= length - 1; i++) {
            if (intervals[i][0] <= temp[j][1]) {
                // 1 先判断当前数组的左端是否在合并数组的最后一个区间内，若在则新区间右端点取一个较大值
                temp[j][1] = Math.max(intervals[i][1], temp[j][1]);
            } else {
                // 2 否则直接增加一个新区间
                j++;
                temp[j][0] = intervals[i][0];
                temp[j][1] = intervals[i][1];
            }
        }
        int[][] res = new int[j + 1][2];
        System.arraycopy(temp, 0, res, 0, j + 1);
        return res;
    }

}
