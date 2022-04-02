public class Converter {
    private static final double LENGTH_OF_STEP = 75.0 / 100;
    private static final double K_KAL_PER_STEP = 1 * 50.0 / 1000;

    double distance(int sum) {
        return sum * LENGTH_OF_STEP;
    }

    double getKKal(int sum) {
        return sum * K_KAL_PER_STEP;
    }
}
