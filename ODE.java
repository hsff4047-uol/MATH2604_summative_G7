import static java.lang.Math.*;

class ODE {

    /**
     * Sets up the matrix and solves the differential equation to find an approximation for f(0.5).
     * Assumes n > 0.
     * @param a The real constant 'a' used in the equation.
     * @param n How many grid points to use inside the interval.
     * @return The estimated value at exactly f(0.5). If n is an even number, it averages the two closest points. If the tridiagonal solver fails and gives back null, this just returns Double.NaN to handle the error.
     */
    public static double solve(double a, int n) {
        double h = 1.0 / (n + 1);
        double[][] M = new double[3][n];
        double[] rhs = new double[n]; // right hand side of the equation

        // Building the matrix m and defining vector
        for (int i = 0; i < n; i++) {
            double x = (i + 1) * h;
           
            M[0][i] = -1.0;
            M[1][i] = 2.0 + (h * h * cos(x));
            M[2][i] = -1.0;
           
            // v_i is a * x^2, so the RHS is -h^2 * a * x^2
            rhs[i] = -1.0 * (h * h) * a * (x * x);
        }

        // use the tridiagonals solver
        double[] w = Tridiagonals.linearSolve(M, rhs);

        if (w == null) {
            return Double.NaN;
        }

        // if n is odd its on the grid point
        if (n % 2 != 0) {
            int midIndex = (n - 1) / 2;
            return w[midIndex];
        }
        // if n is even take average of the 2 nearest gridpoints
        else {
            int leftIndex = (n / 2) - 1;
            int rightIndex = n / 2;
            return (w[leftIndex] + w[rightIndex]) / 2.0;
        }
    }
}
