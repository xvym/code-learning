package cn.com.xvym.learning.leetcode.no912;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/5/9 23:05
 * @Description:
 */
@Slf4j
public class HeapSortTest {

    private int[] nums = {4, 1, 9, 3, 7, 8, 5, 6, 2};

    @Test
    public void testSortArray() {
        heapSort(nums);
        for (Integer num : nums) {
            log.info(String.valueOf(num));
        }
    }

    private void heapSort(int[] nums) {
        // 从最后一个非叶子节点开始向前遍历进行大顶堆化。
        // 由完全二叉树的性质可得length/2为最后一个叶子节点所在的位置
        for (int i = nums.length / 2; i >= 0; i--) {
            adjustMaxHeap(nums, i, nums.length);
        }

        int length = nums.length;
        // 交换堆顶和当前末尾的节点，重置大顶堆
        for (int i = length - 1; i > 0; i--) {
            swap(nums, 0, i);
            length--;
            adjustMaxHeap(nums, 0, length);
        }
    }

    private void adjustMaxHeap(int[] nums, int currentIndex, int length) {
        // 默认堆顶节点设置为最大节点
        int largestIndex = currentIndex;
        // 计算子节点的下标
        int lChild = currentIndex * 2 + 1;
        int rChild = currentIndex * 2 + 2;
        // 若存在左子节点且左节点的值大，则更新最大值索引
        if (lChild < length && nums[lChild] > nums[largestIndex]) {
            largestIndex = lChild;
        }
        // 右子节点同理
        if (rChild < length && nums[rChild] > nums[largestIndex]) {
            largestIndex = rChild;
        }
        // 如果最大值索引不是当前节点，则需要进行节点交换
        if (largestIndex != currentIndex) {
            swap(nums, currentIndex, largestIndex);
            // 因为交换后子节点的值发生了变化（变小了），所以要对以子节点为顶的堆进行最大堆化
            adjustMaxHeap(nums, largestIndex, length);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}