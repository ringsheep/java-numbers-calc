package com.zinyakov;

public class Main {

    public static void main(String[] args) {
        try {
            BinaryArguments arguments = new BinaryArguments.Builder(args[0], args[2], args[1]).build();

            Double result = new Calculator().calculate(arguments);

            System.out.printf("the result is: %f", result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
