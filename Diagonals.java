public static double[] sum(double[]a, double[]b) {
    if (a == null || b == null|| a.length != b.length) return null; //Checks if the matrices are the same length, and if they are null
    int n = a.length;
    double sumResult [] = new double [n]; 
    for (int i = 0; i<n; i++) { //Iterates from 0 to n-1
        sumResult[i] = a[i] + b[i]; //Adds the values in the main diagonal from parameters
    }
    return sumResult;
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
