/*
 https://leetcode.com/problems/spiral-matrix/description/
 */
package arrays;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author mattoop
 */
public class SpiralMatrix {

    public static void main(String[] str) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] inputMatrix = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] inputMatrixTwo = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println(spiralMatrix.spiralOrder(inputMatrixTwo));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrderList = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return spiralOrderList;
        }
        int columnPointer = 0;
        int rowPointer = 0;
        int lastColumn = matrix[0].length - 1;
        int lastRow = matrix.length - 1;

        while (rowPointer <= lastRow && columnPointer <= lastColumn) {
            //Go Right
            for (int indexOne = columnPointer; indexOne <= lastColumn; indexOne++) {
                spiralOrderList.add(matrix[rowPointer][indexOne]);
            }
            rowPointer++;

            if (rowPointer <= lastRow) {
                for (int indexTwo = rowPointer; indexTwo <= lastRow; indexTwo++) {
                    spiralOrderList.add(matrix[indexTwo][lastColumn]);
                }
                lastColumn--;
            } else {
                break;
            }

            if (columnPointer <= lastColumn) {
                for (int indexThree = lastColumn; indexThree >= columnPointer; indexThree--) {
                    spiralOrderList.add(matrix[lastRow][indexThree]);
                }
                lastRow--;
            } else {
                break;
            }

            for (int indexFour = lastRow; indexFour >= rowPointer; indexFour--) {
                spiralOrderList.add(matrix[indexFour][columnPointer]);
            }
            columnPointer++;
        }
        return spiralOrderList;
    }
}
