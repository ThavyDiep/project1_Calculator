import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueCalculation = true;
        int operation = getOperation(input);

        while (continueCalculation) {
            if (operation == 5) {
                System.out.println("Thank you for using the calculator!");
                break;
            }
            double num1 = getNumbers(input, "Enter your first number: ");
            double num2 = getNumbers(input, "Enter your second number: ");
            double result = calculateResult(num1, num2, operation);

            displayResult(num1, num2, operation, result);


            System.out.println("Do you want to change operation? (yes/no): ");
            String changeOperation = input.next().toLowerCase();
            if (changeOperation.equals("yes")) {
                operation = getOperation(input);
            }
        }
        input.close();
    }

    public static void displayCalculatorMenu() {
        System.out.println("Calculator Menu:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
        System.out.println("Please select one operation above: ");

    }

    public static int getOperation(Scanner input) {
        displayCalculatorMenu();
        return input.nextInt();
    }

    public static double getNumbers(Scanner input, String message) {
        System.out.print(message);
        return input.nextDouble();
    }

    public static double calculateResult(double num1, double num2, int operator) {
        switch (operator) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 != 0) {
                    return num1 / num2;

                } else {
                    System.out.println("The result is undefined (division by zero). ");
                    return Double.NaN;
                }
            default:
                System.out.println("Invalid input! Please select the operation again!");
                return Double.NaN;
        }
    }
    public static void displayResult(double num1, double num2, int operation, double result ){
        String operatorSymbol = "";
        switch (operation) {
            case 1:
                operatorSymbol = "+";
                break;
            case 2:
                operatorSymbol = "-";
                break;
            case 3:
                operatorSymbol = "*";
                break;
            case 4:
                operatorSymbol = "/";
                break;
        }
        if (!Double.isNaN(result)) {
            System.out.println("The result of " + num1 + " " + operatorSymbol + " " + num2 + " is " + String.format("%.2f", result));

        }
    }
}

