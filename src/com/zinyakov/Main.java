package com.zinyakov;

public class Main {

    public static void main(String[] args) {
        try {
            BinaryArguments arguments = new BinaryArguments.Builder(args[0], args[2], args[1]).build();

            Double result = new Calculator().calculate(arguments, () -> {
                if (arguments.a > 999 || arguments.b > 999) {
                    throw new Exception("operands must not be longer than 3 digits");
                }
            });

            System.out.println("the result is: " + result);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
