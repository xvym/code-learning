package cn.com.xvym.learning.leetcode.no015_3sum;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xv
 * @Date: 2021/5/16 16:27
 * @Description:
 */
@Slf4j
public class No015Test {

    private int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};

    @Test
    public void test() {
        List<List<Integer>> res = threeSum(nums);
        log.info(String.valueOf(res.size()));
        for (List<Integer> group : res) {
            log.info("-----------");
            for (Integer num : group) {
                log.info(String.valueOf(num));
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 直接对nums排序，不要转为list再操作，速度会慢一个等级
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    temp.add(nums[i]);
                    res.add(temp);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                }
            }

        }
        return res;
    }
}
