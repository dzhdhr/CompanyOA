package Cisco;
import java.util.*;
public class Spiral {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (result.size() < rows * columns) {
            // Traverse from left to right.
            for (int row = up; row <= down; row++) {
                result.add(matrix[row][left]);
            }
            for (int col = left+1; col <= right; col++) {
                result.add(matrix[down][col]);
            }
            // Traverse downwards.
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row >= up; row--) {
                    result.add(matrix[row][right]);
                }
            }
            // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col > left; col--) {
                    result.add(matrix[up][col]);
                }
            }
            // Make sure we are now on a different column.

            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}
