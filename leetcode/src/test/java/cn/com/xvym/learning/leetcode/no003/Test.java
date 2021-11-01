//package cn.com.xvym.learning.leetcode.no003;
//
//import java.util.*;
//
///**
// * @Author: Xv
// * @Date: 2021/6/12 23:15
// * @Description:
// */
//public class Test {
//
//    @org.junit.Test
//    public void test() {
//        System.out.println(findRotation(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}));
//    }
//
//    public boolean findRotation(int[][] mat, int[][] target) {
////        if (mat == target) {
////            return true;
////        } else {
//            for (int i = 0; i < 4; i++) {
//                mat = rotate(mat);
//                Arrays.sort(Comparator.comparing());
//                if (Arrays.equals(mat, target)) {
//                    String s = "haha";
//                    s.length()
//                    Map<String, Integer> map = new HashMap<>();
//                    Character
//                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                        In
//                    }
//                    return true;
//                }
//            }
//            return false;
////        }
//    }
//
//    public int[][] rotate(int[][] matrix) {
//        int n = matrix.length;
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < (n + 1) / 2; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - j - 1][i];
//                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
//                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
//                matrix[j][n - i - 1] = temp;
//            }
//        }
//        return matrix;
//    }
//}
