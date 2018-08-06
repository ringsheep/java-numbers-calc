package com.zinyakov.calc

import spock.lang.Specification

class CalculatorTest extends Specification {

    def calc = new Calculator()

    def "a + b = result"() {
        expect:
        calc.calculate(new BinaryArguments(a, b, MathOperator.PLUS)) == result

        where:
        a | b || result
        3 | 7 || 10
        5 | 4 || 9
        9 | 9 || 18
        0 | 0 || 0
    }

    def "a - b = result"() {
        expect:
        calc.calculate(new BinaryArguments(a, b, MathOperator.MINUS)) == result

        where:
        a | b || result
        3 | 7 || -4
        5 | 4 || 1
        9 | 9 || 0
        0 | 0 || 0
    }

    def "a * b = result"() {
        expect:
        calc.calculate(new BinaryArguments(a, b, MathOperator.MULTIPLY)) == result

        where:
        a | b || result
        3 | 7 || 21
        5 | 4 || 20
        9 | 9 || 81
        0 | 0 || 0
    }

    def "a / b = result"() {
        expect:
        calc.calculate(new BinaryArguments(a, b, MathOperator.DIVIDE)) == result

        where:
        a | b  || result
        3 | 10 || 0.3
        5 | 4  || 1.25
        9 | 9  || 1
        // TODO: Как проверить что Infinity?
//        5 | 0  || null
    }

    // TODO: Как проверить что кидает Exception при a || b > 999 ?

}
