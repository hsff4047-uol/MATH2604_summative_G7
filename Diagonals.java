import static java.lang.Math.*;

class Diagonals
{
/**This returns a representation of a diagonal 5x5 matrix. 
 *@return the array below containing the diagonal values*/

public static double[] exampleMatrix() {
    return new double[] {10, 8, 5, -10, 7};
}

public static double[] sum(double[]a, double[]b) {
    if (a == null || b == null|| a.length != b.length) return null; //Checks if the matrices are the same length, and if they are null
    int n = a.length;
    double sumResult [] = new double [n]; 
    for (int i = 0; i<n; i++) { //Iterates from 0 to n-1
        sumResult[i] = a[i] + b[i]; //Adds the values in the main diagonal from parameters
    }
    return sumResult;
}

public static double[] product(double[]a, double[]b) {
    if (a == null || b == null|| a.length != b.length) return null; //Checks if the matrices are the same length, and if they are null
    int n = a.length;
    double productResult[] = new double [n]; 
    for (int i = 0; i<n; i++) { //Iterates from 0 to n-1
        productResult[i] = a[i] * b[i]; //Multiplys the values in the main diagonal from parameters
    }
    return productResult;
}

public static double[] inverse(double[] a) {
    if (a == null) {
         return null;
    }
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = 1.0 / a[i];
        }
        return result;
    }


}


