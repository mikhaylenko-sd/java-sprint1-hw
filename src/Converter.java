public class Converter {
    double lengthOfStep = 75.0 / 100;
    double kkalPerStep = 1 * 50.0 / 1000;

    double distance(int sum) {
        return sum * lengthOfStep;
    }

    double getKkal(int sum) {
        return sum * kkalPerStep;
    }
}
