package SwordOffer;

/**
 * _02_FindNumberIn2DArray
 */
public class _02_FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int x = matrix[0].length - 1;
        int y = 0;
        while (x >= 0 && y < matrix.length)
            if (matrix[y][x] == target) return true;
            else if (matrix[y][x] < target) y++;
            else x--;

        return false;
    }
}