import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertK2F(double kelvin) {
        return convertC2F(convertK2C(kelvin));
    }

    public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit));
        return Double.parseDouble(input.nextLine());
    }

    public static void getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        //return input.nextLine();
    }

    public static void main(String[] args) {
        while(true) {
            getUnitChoice();
            System.out.println("convert from: ");
            String from = input.nextLine();
            if (from.equals("Q") || from.equals("q")) {
                break;
            }
            System.out.println("convert to: ");
            String to = input.nextLine();
            if (to.equals("Q") || to.equals("q")) {
                break;
            }
        //    System.out.println("Temperature to be converted from: ");
        //    double fromValue = input.nextDouble();
            double fromValue = getTemp(from);
            double toValue = 0.0;

            switch (from) {
                case "K":
                case "k":
                    switch (to) {
                        case "F", "f" -> {
                            toValue = convertK2F(fromValue);
                            System.out.println("K to F");
                        }
                        case "C", "c" -> {
                            toValue = convertK2C(fromValue);
                            System.out.println("K to C");
                        }
                    }
                    break;

                case "C":
                case "c":
                    switch (to) {
                        case "F", "f" -> {
                            toValue = convertC2F(fromValue);
                            System.out.println("C to F");
                        }
                        case "K", "k" -> {
                            toValue = convertC2K(fromValue);
                            System.out.println("C to K");
                        }
                    }
                    break;
                case "F":
                case "f":
                    switch (to) {
                        case "C", "c" -> {
                            toValue = convertF2C(fromValue);
                            System.out.println("F to C");
                        }
                        case "K", "k" -> {
                            toValue = convertF2K(fromValue);
                            System.out.println("F to K");
                        }
                    }
                    break;

            }
            System.out.printf("Result %f %s is %f %s", fromValue, from, toValue, to);
        }
    }
}