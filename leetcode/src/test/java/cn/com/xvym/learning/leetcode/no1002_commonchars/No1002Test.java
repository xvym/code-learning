package cn.com.xvym.learning.leetcode.no1002_commonchars;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xv
 * @Date: 2021/5/17 22:06
 * @Description:
 */
@Slf4j
public class No1002Test {

    private String[] words = {"bella", "label", "roller"};

    @Test
    public void test() {
        commonChars(words).forEach(log::info);
    }

    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        String target = words[1];
        for (Character character : target.toCharArray()) {
            boolean containChar = true;
            for (int i = 0; i < words.length; i++) {
                String s = words[i];
                StringBuilder sb = new StringBuilder(s);
                int index = words[i].indexOf(character);
                if (index != -1) {
                    sb.deleteCharAt(index);
                    words[i] = sb.toString();
                } else {
                    containChar = false;
                    break;
                }
            }
            if (containChar) {
                res.add(character.toString());
            }
        }
        return res;
    }

}
