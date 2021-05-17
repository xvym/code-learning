package cn.com.xvym.learning.leetcode.no088_mergearrays;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Xv
 * @Date: 2021/5/17 22:10
 * @Description:
 */
@Slf4j
public class No088Test {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] nums = new int[m + n];
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                nums[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        for(int l = 0; l < n + m ; l++) {
            nums1[l] = nums[l];
        }
    }

}
