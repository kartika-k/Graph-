// public class dumy {
    
// }
class Solution {
    public int maxIncreasingCells(int[][] mat) {
        // Get the dimensions of the matrix
        int m = mat.length, n = mat[0].length;

        // TreeMap to store cells with the same value
        Map<Integer, List<int[]>> A = new TreeMap<>();

        // Populate TreeMap with cell coordinates based on cell values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                if (!A.containsKey(val)) {
                    A.put(val, new ArrayList<int[]>());
                }
                A.get(val).add(new int[] {i, j});
            }
        }

        // 2D array to store the length of the increasing subsequence ending at each cell
        int[][] dp = new int[m][n];

        // Array to store the maximum length of increasing subsequence for rows and columns
        int[] res = new int[n + m];

        // Process cells in TreeMap in ascending order of values
        for (int a : A.keySet()) {
            // Update dp array with the length of increasing subsequence
            for (int[] pos : A.get(a)) {
                int i = pos[0], j = pos[1];
                dp[i][j] = Math.max(res[i], res[m + j]) + 1;
            }

            // Update the res array with the maximum length for rows and columns
            for (int[] pos : A.get(a)) {
                int i = pos[0], j = pos[1];
                res[m + j] = Math.max(res[m + j], dp[i][j]);
                res[i] = Math.max(res[i], dp[i][j]);
            }
        }

        // Find the overall maximum length of increasing subsequence
        int ans = 0;
        for (int a : res) {
            ans = Math.max(ans, a);
        }

        // Return the result
        return ans;
    }
}
