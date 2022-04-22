public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("28+3= " + calculator.add(28, 3));
        System.out.println("28-3= " + calculator.substract(28, 3));
        System.out.println("28/3= " + calculator.divide(28, 3));
        System.out.println("28*3= " + calculator.multiply(28, 3));
        System.out.println("28 mod3= " + calculator.mod(28, 3));
        System.out.println("28^3= " + calculator.exponential(28, 3));
        System.out.println("|-28|= " + calculator.absoluteValue(-28));
        System.out.println("karekok(36)= " + calculator.squareRoot(36));
    }
}
