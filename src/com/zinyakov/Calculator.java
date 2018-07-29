package com.zinyakov;

final class Calculator {

    interface Validator {
        void validateExpression() throws Exception;
    }

    Double calculate(BinaryArguments arguments,
                           Validator validator) throws Exception {
        validator.validateExpression();
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
