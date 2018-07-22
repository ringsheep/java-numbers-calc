package com.zinyakov;

final class Calculator<OperatorType> {

    interface Validator {
        void validateExpression() throws Exception;
    }

    OperatorType calculate(BinaryArguments<OperatorType> arguments,
                           Validator validator) throws Exception {
        validator.validateExpression();
        return arguments.operation.operate(arguments.a, arguments.b);
    }

}
