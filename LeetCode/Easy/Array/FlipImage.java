/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
To flip an image horizontally means that each row of the image is reversed. 
For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. 
For example, inverting [0, 1, 1] results in [1, 0, 0].

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

*/
class FlipImage {
    public int[][] flipAndInvertImage(int[][] A) {
        //Flip horizontally
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - j - 1];
                A[i][A[i].length - 1 - j] = temp;
            }
        }

        //Invert 
        for(int[] row : A) {
            for(int i = 0; i < row.length; i++) {
                row[i] = (row[i] == 1) ? 0 : 1;
            }
        }

        return A; 
    }
}
