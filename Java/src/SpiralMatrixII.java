/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * Accepted.
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{};
        }
        if (n == 1) {
            return new int[][]{{1}};
        }

        int[][] matrix = new int[n][n];
        int centerX = n % 2 == 0 ? (n - 1) / 2 : n / 2;
        int centerY = n % 2 == 0 ? (n - 1) / 2 : n / 2;
        int i = 0, j = 0, depth = 0, result = 1;
        while (i <= centerX && j <= centerY && depth <= centerX && depth <= centerY) {
            for (j = depth, i = depth; j < matrix[0].length - depth; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = result++;
                }
            }

            for (j--, i++; i < matrix.length - depth; i++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = result++;
                }
            }

            for (i--, j--; j >= depth; j--) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = result++;
                }
            }

            for (j++, i--; i > depth; i--) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = result++;
                }
            }

            depth++;
        }

        return matrix;
    }

}