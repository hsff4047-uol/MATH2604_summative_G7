 import static java.lang.Math.*;
    import java.util.Scanner;
    
    class Tridiagonals
    {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter matrix size: ");
                int n = sc.nextInt();
                exampleMatrix(n);
                double[][] T = exampleMatrix(n) ;
                System.out.println("Is the matrix valid: " + isValidTridiagonal(T));

    }
    public static double[][] exampleMatrix(int n) {
        double[][] a = new double[3][n];
        for (int i = 0; i < n; i++) {
            a[1][i] = -Math.pow(i + 1, 2); 
            if (i < n - 1) {
                a[0][i] = 1.0; 
                a[2][i] = (i + 2); 
            }
        }
        System.out.println("n x n Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double value = 0; //set all values in matrix to zero
                if (i == j) {
                    value = a[1][i];  // Sets all values in main diagonal to the values in the matrix's "a" main diagonal     
                } else if (j == i + 1) {
                    value = a[0][i];  //Sets all values in the diagonal above to the values in the matrix's "a" diagonal     
                } else if (i == j + 1) {
                    value = a[2][j]; //Sets all values in the diagonal below to the values in the matrix's "a" diagonal
                }
                System.out.print(value + "\t"); //Prints outs the matrix, with tabs
            }
            System.out.println();
        }
        return a; //Returns the tridiagonal matrix 
    }
    public static boolean isValidTridiagonal(double[][] a) {
        if (a == null || a.length != 3) return false; //Checks if matrix is null or doesnt have size length of 3, if so, return false tridiagonal matrix
        if (a[0] == null || a[1] == null || a[2] == null) return false; //Checks if each row contains data
        int n  = a[1].length;
        if (n < 1) return false; //Checks if the diagonal contains at least 1 element
        return a[0].length == n && a[2].length == n; //Checks if the diagonal below and above the main diagonal contains the same number of elements as the main diagonal
    }
}
