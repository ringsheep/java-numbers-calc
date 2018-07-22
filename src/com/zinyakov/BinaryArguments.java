package com.zinyakov;

class BinaryArguments<OperatorType>{

    interface BinaryOperable<OperatorType> {
        OperatorType operate(OperatorType a, OperatorType b);
    }

    static class IntegerBuilder {

        private String[] args;

        IntegerBuilder(String[] args) {
            this.args = args;
        }

        BinaryArguments<Integer> build() throws Exception {
            Integer a = Integer.parseInt(args[0]);
            BinaryOperable<Integer> operation = operation(args[1]);
            Integer b = Integer.parseInt(args[2]);
            return new BinaryArguments<>(a, b, operation);
        }

        BinaryOperable<Integer> operation(String operationSign) throws Exception {
            switch (operationSign) {
                case "+":
                    return (a, b) -> a + b;
                case "-":
                    return (a, b) -> a - b;
                case "*":
                    return (a, b) -> a * b;
                case "/":
                    return (a, b) -> a / b;
            }
            throw new Exception("incorrect operation type. +-/* are supported");
        }

    }

    OperatorType a;
    OperatorType b;
    BinaryOperable<OperatorType> operation;

    private BinaryArguments() {
    }

    private BinaryArguments(OperatorType a, OperatorType b, BinaryOperable<OperatorType> operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

}
