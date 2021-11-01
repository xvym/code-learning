package cn.com.xvym.learning.leetcode.sward038;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xv
 * @Date: 2021/6/22 23:21
 * @Description:
 */
public class Sward038Test {

    @Test
    public void test() {
        permutation("aac");
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);
        int[] used = new int[s.length()];
        Arrays.fill(used, 0);
        List<String> resList = new ArrayList<>();
        String curString = "";
        backtrace(s, used, curString, resList);
        return resList.toArray(new String[0]);
    }

    public void backtrace(String s, int[] used, String curString, List<String> resList) {
        if (curString.length() == s.length()) {
            resList.add(curString);
        }
        int[] charSet = new int[26];
        Arrays.fill(charSet, 0);
        for (int i = 0; i < s.length(); i++) {
            if (charSet[s.charAt(i) - 'a'] == 0) {
                if (used[i] != 1) {
                    charSet[s.charAt(i) - 'a'] = 1;
                    used[i] = 1;
                    String temp = curString;
                    curString += String.valueOf(s.charAt(i));
                    backtrace(s, used, curString, resList);
                    used[i] = 0;
                    curString = temp;
                }
            }
        }
    }
}
