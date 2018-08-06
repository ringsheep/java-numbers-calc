package main.java.com.zinyakov.calc;

final class Calculator {

    Double calculate(BinaryArguments arguments) throws Exception {
        if (arguments.a > 999 || arguments.b > 999) {
            throw new Exception("operands must not be longer than 3 digits");
        }
        switch (arguments.operator) {
            case PLUS:
                return arguments.a + arguments.b;
            case MINUS:
                return arguments.a - arguments.b;
            case MULTIPLY:
                return arguments.a * arguments.b;
            case DIVIDE:
                return arguments.a / arguments.b;
        }
        throw new Exception("Unknown operator 😱");
    }

}
