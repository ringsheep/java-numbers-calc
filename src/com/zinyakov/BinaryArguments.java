package com.zinyakov;

import java.util.Arrays;
import java.util.Optional;

enum MathOperator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String text;

    MathOperator(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}

class BinaryArguments {

    static class Builder {

        private String a;
        private String b;
        private String operator;

        Builder(String a, String b, String operator) {
            this.a = a;
            this.b = b;
            this.operator = operator;
        }

        BinaryArguments build() throws Exception {
            return new BinaryArguments(Double.parseDouble(a), Double.parseDouble(b), operator(operator));
        }

        MathOperator operator(String operationSign) throws Exception {
            Optional<MathOperator> operator = Arrays.stream(MathOperator.values())
                    .filter(op -> operationSign.equals(op.toString()))
                    .findFirst();

            if (operator.isPresent()) {
                return operator.get();
            }

            throw new Exception("incorrect operation type. +-/* are supported");
        }

    }

    Double a;
    Double b;
    MathOperator operator;

    private BinaryArguments() {
    }

    private BinaryArguments(Double a, Double b, MathOperator operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

}
