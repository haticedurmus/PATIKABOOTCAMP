public class Calculator {
    long add(long num1, long num2) {
        return num1 + num2;
    }

    long substract(long num1, long num2) {
        return num1 - num2;
    }

    float divide(long num1, long num2) {
        float division = (float) num1 / num2;
        return division;

    }

    long multiply(long num1, long num2) {
        return num1 * num2;
    }

    long mod(long num1, long num2) {
        return num1 % num2;
    }

    long absoluteValue(long num1) {
        if (num1 >= 0) {
            return num1;

        } else {
            return num1 * -1;
        }
    }

    long exponential(long num1, long power) {
        long result = 1;
        for (int i = 1; i <= power; i++) {
            result *= num1;
        }
        return result;
    }

    float squareRoot(int num) {
        for (int i = 0; i <= num / 2; i++) {
            if (i * i == num) {
                return i;
            }
        }
        return -1;
    }

}
