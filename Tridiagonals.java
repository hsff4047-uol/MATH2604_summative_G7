import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Scanner;

class Tridiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size: ");
        int n = sc.nextInt();

    }

    public static double[][] exampleMatrix(int n) {
        double[][] a = new double[3][n];
        for (int i = 0; i < n; i++) {
            a[1][i] = -Math.pow(i + 1, 2); // Takes value in main diagonal and squares them and multiply by -1
            if (i < n - 1) {
                a[0][i] = 1.0; // Set values in the diagonal above to be 1
                a[2][i] = (i + 2); // set values in the diagonals belows to go from 2 to n
            }
        }
        System.out.println("n x n Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double value = 0; // set all values in matrix to zero
                if (i == j) {
                    value = a[1][i]; // Sets all values in main diagonal to the values in the matrix's "a" main
                                     // diagonal
                } else if (j == i + 1) {
                    value = a[0][i]; // Sets all values in the diagonal above to the values in the matrix's "a"
                                     // diagonal
                } else if (i == j + 1) {
                    value = a[2][j]; // Sets all values in the diagonal below to the values in the matrix's "a"
                                     // diagonal
                }
                System.out.print(value + "\t"); // Prints outs the matrix, with tabs
            }
            System.out.println();
        }
        return a; // Returns the tridiagonal matrix
    }
    public static boolean isValidTridiagonal(double[][] b) {
        if (b == null) return false;
        if (b.length != 3) return false;

        for (int i = 0; i < 3; i++) {
            if (b[i] == null) return false;
        }

        int n = b[1].length;
        if (n < 1) return false;
        if (b[0].length !=n || b[2].length !=n) return false;

        return true;
        
    }

    public static double[][] sum(double[][] a, double[][] b) {
        // make sures that main array exist and have 3 rows
        if (a == null || b == null || a.length != 3 || b.length != 3) {
            return null;
        }
        // check if any rows are missing
        if (a[0] == null || a[1] == null || a[2] == null ||
                b[0] == null || b[1] == null || b[2] == null) {
            return null;
        }
        int n = a[1].length;
        // Check if n is at least 1 and if all rows have same length
        if (n < 1 || a[0].length != n || a[2].length != n ||
                b[0].length != n || b[1].length != n || b[2].length != n) {
            return null;
        }
        double[][] result = new double[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static double[][] productWithDiagonal(double[] D, double[][] T) {
        if (D == null || !isValidTridiagonal(T) || D.length != T[1].length)
            return null; // Checks if D is empty, T is a valid tridiagonal and if the length of D and T
                         // are equal
        int n = T[1].length;
        double[][] resultD = new double[3][n];
        for (int j = 0; j < n; j++) { // Iterates from 0 to n-1
            resultD[0][j] = D[j] * T[0][j]; // Multiplys the Diagonal above the main by values Dj
            resultD[1][j] = D[j] * T[1][j]; // Multiplys the main Diagonal by the values Dj
            if (j < n - 1) {
                resultD[2][j] = D[j + 1] * T[2][j]; // Multiplys the Diagonal below the main by the value Dj+1
            }
        }
        return resultD;
    }
}
