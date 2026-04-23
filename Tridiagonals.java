import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Scanner;

    
    class Tridiagonals
    {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter matrix size: ");
                int n = sc.nextInt();
                exampleMatrix(n);
                double[][] T = exampleMatrix(n) ;
                double[][] TT = exampleMatrix(n);
                System.out.println("Is the matrix valid: " + isValidTridiagonal(T));
                System.out.println(Arrays.deepToString(sum(T,TT)));
                double[] D = {10.0,20.0,30.0};
                double[][] results = productWithDiagonal(D, TT);
                System.out.println(Arrays.deepToString(results));


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


     public static double[][] sum(double[][] a, double [][] b) {
        if (!isValidTridiagonal(a) || !isValidTridiagonal(b)) return null; //Checks if tridiagonals are valid
        int n = a[0].length; //sets n to be length of tridiagonal a
        double[][] resultC = new double[3][n];
        for (int i = 0; i < 3; i++) { //Iterates from 0 to 2, represents the three diagonals
            for (int j = 0; j < n; j++) { //Iterates from 0 to n-1, represents length of diagonal
                if(i ==0 && j == n-1) continue; //Skip the last element in the first row
                if(i ==2 && j == 0) continue; //Skip the first element in the third row
                resultC [i][j] = a[i][j] + b[i][j];  //Adds the values from a and b together
               }
        }
        return resultC;
    }


     public static double[][] productWithDiagonal(double[] D, double[][] T) {
        if (D == null || !isValidTridiagonal(T) || D.length != T[1].length) return null; //Checks if D is empty, T is a valid tridiagonal and if the length of D and T are equal
        int n = T[1].length;
        double [][] resultD = new double[3][n];
        for (int j = 0; j<n; j++) {  //Iterates from 0 to n-1
            resultD[0][j] = D[j] * T[0][j]; // Multiplys the Diagonal above the main by values Dj
            resultD[1][j] = D[j] * T[1][j]; //Multiplys the main Diagonal by the values Dj
            if (j< n-1) {
                resultD[2][j] = D[j+1] * T[2][j]; //Multiplys the Diagonal below the main by the value Dj+1
            }
        }
        return resultD;
    }
}
