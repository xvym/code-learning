package cn.com.xvym.learning.leetcode.no912;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @Author: Xv
 * @Date: 2021/5/10 22:48
 * @Description:
 */
@Slf4j
public class QuickSortTest {

    private int[] nums = {4, 1, 9, 3, 7, 8, 5, 6, 2};

    @Test
    public void testSortArray() {
        quickSort(nums, 0, nums.length - 1);
        for (Integer num : nums) {
            log.info(String.valueOf(num));
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            // 通过随机数产生分界索引
            int pos = randomizedPartition(nums, left, right);
            // 因为pos已经在正确的位置上了，所以下面的两个区间排序不需要再包括pos
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    private int randomizedPartition(int[] nums, int left, int right) {
        // 在[left, right]的区间内随机选一个主元
        int i = new Random().nextInt(right - left + 1) + left;
        // 主元放到末尾，便于读取
        swap(nums, right, i);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
