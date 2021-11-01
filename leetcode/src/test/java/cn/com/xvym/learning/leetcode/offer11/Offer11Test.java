package cn.com.xvym.learning.leetcode.offer11;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/7/28 23:44
 * @Description:
 */
@Slf4j
public class Offer11Test {

    @Test
    public void test() {
        log.info(String.valueOf(minArray(new int[] {1,2,0,0,1})));
    }

    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        int res = Integer.MAX_VALUE;
        while (end > start) {
            int mid = (end - start) / 2 + start;
            if (numbers[end] > numbers[start]) {
                return Math.min(res, numbers[start]);
            } else if (numbers[mid] > numbers[end]) {
                res = Math.min(res, numbers[end]);
                start = mid + 1;
            } else if (numbers[start] > numbers[mid]) {
                res = Math.min(res, numbers[mid]);
                end = mid - 1;
            } else if (numbers[start] == numbers[mid]) {
                res = Math.min(res, numbers[start]);
                start++;
            } else if (numbers[end] == numbers[mid]) {
                res = Math.min(res, numbers[end]);
                end--;
            }
        }
        return res;
    }

}
