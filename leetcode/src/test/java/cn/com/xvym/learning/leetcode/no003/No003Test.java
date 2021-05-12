package cn.com.xvym.learning.leetcode.no003;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xv
 * @Date: 2021/5/11 22:27
 * @Description:
 */
@Slf4j
public class No003Test {

    private String s = "abcabcbb";

    @Test
    public void test() {
        log.info(String.valueOf(lengthOfLongestSubstring(s)));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                // startIndex = map.get(s.charAt(i)) + 1; 错误，原因：形如baabc的情况就会导致判断错误
                // 正确代码如下：加上Math.max后，startIndex再碰到上述情况时，就可以直接跳转到正确的位置上
                startIndex = Math.max(map.get(s.charAt(i)) + 1, startIndex);
            }
            map.put(s.charAt(i), i);
            res = Math.max(i - startIndex + 1, res);
        }
        return res;
    }
}
