package cn.com.xvym.learning.leetcode.no704;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/5/19 21:24
 * @Description:
 */
@Slf4j
public class No704Test {

    private int[] nums = {-1, 0, 3, 5, 9, 12};

    private int target = 9;

    @Test
    public void test() {
        log.info(String.valueOf(search(nums, target)));
    }

    public int search(int[] nums, int target) {
        int res = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                res = mid;
                break;
            }
        }
        return res;
    }
}
