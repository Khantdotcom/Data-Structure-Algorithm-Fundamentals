class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        #sum[i][j] = sum[i-1,j] above + sum[i,j-1] left - sum[i-1,j-1] diagonal + matrix[i][j]
        xor_matrix = [[0 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        ##Improvement -> Padding Trick so that I don't need to check for out-of-bounds row+1, col+1 trick
        all_results = []
        rows = len(matrix)
        cols = len(matrix[0])
        for row in range(rows):
            for col in range(cols):
                xor_matrix[row][col] = matrix[row][col]
                if row != 0:
                    xor_matrix[row][col] ^= xor_matrix[row-1][col]
                if col != 0:
                    xor_matrix[row][col] ^= xor_matrix[row][col-1]
                if row != 0 and col != 0:
                    xor_matrix[row][col] ^= xor_matrix[row-1][col-1]
                all_results.append(xor_matrix[row][col])
        all_results.sort(reverse=True)
        return all_results[k-1]
    
#     ##
#     ##1738. Find Kth Largest XOR Coordinate Value
# Solved
# Medium
# Topics
# premium lock icon
# Companies
# Hint
# You are given a 2D matrix of size m x n, consisting of non-negative integers. You are also given an integer k.

# The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).

# Find the kth largest value (1-indexed) of all the coordinates of matrix.

 

# Example 1:

# Input: matrix = [[5,2],[1,6]], k = 1
# Output: 7
# Explanation: The value of coordinate (0,1) is 5 XOR 2 = 7, which is the largest value.
# Example 2:

# Input: matrix = [[5,2],[1,6]], k = 2
# Output: 5
# Explanation: The value of coordinate (0,0) is 5 = 5, which is the 2nd largest value.
# Example 3:

# Input: matrix = [[5,2],[1,6]], k = 3
# Output: 4
# Explanation: The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd largest value.
 

# Constraints:

# m == matrix.length
# n == matrix[i].length
# 1 <= m, n <= 1000
# 0 <= matrix[i][j] <= 106
# 1 <= k <= m * n