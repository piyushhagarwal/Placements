package Arrays.Matrix;

class Transpose {
    public static void withoutExtraSpace(int matrix[][]) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static int[][] withExtraSpace(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[][] = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

}
