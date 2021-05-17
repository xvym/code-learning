package cn.com.xvym.learning.leetcode.no415;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/5/17 22:15
 * @Description:
 */
@Slf4j
public class No415Test {

    private String nums1 = "101";

    private String nums2 = "232";

    @Test
    public void test() {
        log.info(addStrings(nums1, nums2));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int sum1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int sum2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = sum1 + sum2 + add;
            sb.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
