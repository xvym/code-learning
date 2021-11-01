package cn.com.xvym.learning.leetcode.no034;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/5/30 22:55
 * @Description:
 */
@Slf4j
public class No034Test {

    private int[] nums = {5, 7, 7, 8, 8, 10};

    private int target = 8;

    @Test
    public void test() {
        int[] res = searchRange(nums, target);
        for (int num : res) {
            log.info(String.valueOf(num));
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] res = {-1, -1};
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target) {
                if (nums[mid - 1] < target) {
                    res[0] = mid;
                    break;
                }
                end = mid - 1;
            }
        }
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target) {
                if (nums[mid + 1] > target) {
                    res[1] = mid;
                    break;
                }
                start = mid + 1;
            }
        }
        return res;
    }

}
