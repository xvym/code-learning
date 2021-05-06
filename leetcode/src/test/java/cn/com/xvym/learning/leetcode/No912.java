package cn.com.xvym.learning.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/5/6 23:01
 * @Description:
 */
@Slf4j
public class No912 {

    private int[] tmp;

    private final int[] nums = {5, 2, 3, 1};

    @Test
    public void sortArrayTest() {
        sortArray(nums);
        for (int num : nums) {
            log.info(String.valueOf(num));
        }
    }

    public int[] sortArray(int[] nums) {
        int length = nums.length;

        // // case1 选择排序，两层循环，选择最小（最大）的数插到数组最前面。超时。
        // for (int i = 0; i < length; i++) {
        //     int minIndex = i;
        //     for (int j = i + 1; j < length; j++) {
        //         if (nums[j] < nums[minIndex]) {
        //             minIndex = j;
        //         }
        //     }
        //     int temp = nums[i];
        //     nums[i] = nums[minIndex];
        //     nums[minIndex] = temp;
        // }

        // // case2 插入排序，两层循环，将当前遍历到的值放到有序数组的正确位置。超时。
        // for (int i = 0; i < length; i++) {
        //     int temp = nums[i];
        //     int j = i - 1;
        //     while (j >= 0 && nums[j + 1] < nums[j]) {
        //         nums[j + 1] = nums[j];
        //         nums[j] = temp;
        //         j--;
        //     }
        // }

        // case3 归并排序
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int i = start;
        int j = mid + 1;
        int cur = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[cur] = nums[i];
                i++;
                cur++;
            } else {
                tmp[cur] = nums[j];
                j++;
                cur++;
            }
        }
        while (i <= mid) {
            tmp[cur] = nums[i];
            i++;
            cur++;
        }
        while (j <= end) {
            tmp[cur] = nums[j];
            j++;
            cur++;
        }
        if (end - start + 1 >= 0) {
            System.arraycopy(tmp, 0, nums, start, end - start + 1);
        }
    }
}
