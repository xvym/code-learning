package cn.com.xvym.learning.leetcode.no912;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @Author: Xv
 * @Date: 2021/5/6 23:01
 * @Description:
 */
@Slf4j
public class No912Test {

    private static final Random RANDOM = new Random();

    int[] tmp;

    private int[] nums = {5, 2, 3, 1};

    @Test
    public void testSortArray() {
        sortArray(nums);
        for (Integer num : nums) {
            log.info(String.valueOf(num));
        }
    }

    public int[] sortArray(int[] nums) {
        int length = nums.length;

//        // case1 选择排序，两层循环，选择最小（最大）的数插到数组最前面。超时。
//        for (int i = 0; i < length; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < length; j++) {
//                if (nums[j] < nums[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            int temp = nums[i];
//            nums[i] = nums[minIndex];
//            nums[minIndex] = temp;
//        }

//         // case2 插入排序，两层循环，将当前遍历到的值放到有序数组的正确位置。超时。
//         for (int i = 0; i < length; i++) {
//             int temp = nums[i];
//             int j = i - 1;
//             while (j >= 0 && nums[j + 1] < nums[j]) {
//                 nums[j + 1] = nums[j];
//                 nums[j] = temp;
//                 j--;
//             }
//         }

//        // case3 归并排序
        tmp = new int[length];
        mergeSort(nums, 0, length - 1);

        // case4 基本快速排序
        // 快速排序 1：基本快速排序
//        randomizedQuickSort(nums, 0, nums.length - 1);
        return nums;

    }

    public void randomizedQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuickSort(nums, l, pos - 1);
            randomizedQuickSort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int r, int i) {
        int temp = nums[r];
        nums[r] = nums[i];
        nums[i] = temp;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        // 开始对当前的两个有序区间进行合并
        int i = start;
        int j = mid + 1;
        int cur = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[cur++] = nums[i++];
            } else {
                tmp[cur++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cur++] = nums[i++];
        }
        while (j <= end) {
            tmp[cur++] = nums[j++];
        }
        // 将归并后的数组放回到原来的位置上
        cur = 0;
        while (start <= end) {
            nums[start++] = tmp[cur++];
        }
    }
}