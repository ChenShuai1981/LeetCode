package com.caselchen.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * https://segmentfault.com/a/1190000019577320
 *
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * <p>
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 假如m*n的矩阵，从(0,m-1)开始，向下移动n-1次到达最下面，再向左m-1次，向上n-2次，向右m-2次，
 * 接着就是：向下n-3，向左m-3，向上n-4，向右m-4。每次转向m或n都会自减1。
 * <p>
 * --- m --->
 * |
 * n
 * |
 * V
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return nums;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        int m = 0;
        int n = 0;
        int i = -1;
        int tmp = 0;

        while (row >= 0 && col >= 0) {
            switch (i++ % 4) {
                case 0: // 向下
                    for (tmp = 0; tmp < row; tmp++)
                        nums.add(matrix[++m][n]);
                    row -= 1;
                    break;
                case 1: // 向左
                    for (tmp = 0; tmp < col; tmp++)
                        nums.add(matrix[m][--n]);
                    col -= 1;
                    break;
                case 2: // 向上
                    for (tmp = 0; tmp < row; tmp++)
                        nums.add(matrix[--m][n]);
                    row -= 1;
                    break;
                case 3: // 向右
                    for (tmp = 0; tmp < col; tmp++)
                        nums.add(matrix[m][++n]);
                    col -= 1;
                    break;
                default:
                    for (tmp = 0; tmp <= col; tmp++)
                        nums.add(matrix[m][n++]);
                    tmp = 0;
                    n -= 1;
                    break;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> nums = sm.spiralOrder(matrix);
        System.out.println(nums);
    }
}
