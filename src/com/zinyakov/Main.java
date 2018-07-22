package com.zinyakov;

public class Main {

    public static void main(String[] args) {
        try {
            BinaryArguments<Integer> arguments = new BinaryArguments.IntegerBuilder(args).build();

            Integer result = new Calculator<Integer>().calculate(arguments, () -> {
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
