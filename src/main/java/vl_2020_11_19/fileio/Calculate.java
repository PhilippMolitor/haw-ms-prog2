package vl_2020_11_19.fileio;

public class Calculate {
    public static void main(String[] args) {
        // run some divisions
        double a = 5;

        for (double i = -3; i <= 3; i += 1) {
            try {
                double result = divide(a, i);
                System.out.printf("%f / %f = %f\n", a, i, result);
            } catch (DivisionThroughZeroException ex) {
                System.out.printf("Caught division through zero for \"%f / %f\": %s\n", a, i, ex.getMessage());
            }
        }
    }

    private static double divide(double a, double b) throws DivisionThroughZeroException {
        if (Double.compare(b, 0) == 0) {
            throw new DivisionThroughZeroException("division through 0 is not allowed.");
        }
        return a / b;
    }
}
