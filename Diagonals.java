/**
     * Inverts a diagonal matrix by flipping each number (1/x).
     * I'm assuming the matrix is invertible, so I'm not checking for zeroes.
     * @param a The 1D array representing the diagonal matrix.
     * @return A new array with the inverted numbers. If the input is null, it 
     * returns null. If it's an empty array, it just gives back an empty one.
     */
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
