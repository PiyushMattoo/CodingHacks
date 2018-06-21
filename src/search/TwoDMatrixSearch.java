/*
 https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
package search;

/**
 *
 * @author mattoop
 */
public class TwoDMatrixSearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) {
            return false;
        }
        int targetRow = 0;
        int targetColumn = matrix[0].length - 1;

        while (targetRow >= 0 && targetColumn >= 0 && targetRow < matrix.length && targetColumn < matrix[0].length) {
            if (matrix[targetRow][targetColumn] > target) {
                targetColumn = targetColumn - 1;
            } else if (matrix[targetRow][targetColumn] < target) {
                targetRow = targetRow + 1;
            } else if (matrix[targetRow][targetColumn] == target) {
                return true;
            }
        }
        return false;
    }

}
