package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 15:48
*/

public class SimpleCalculator {
    private double firstNumber, secondNumber;

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber( double firstNumber ) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber( double secondNumber ) {
        this.secondNumber = secondNumber;
    }

    public double getAdditionResult() {
        return firstNumber + secondNumber;
    }
    public double getSubtractionResult() {
        return firstNumber - secondNumber;
    }
    public double getMultiplicationResult() {
        return firstNumber * secondNumber;
    }
    public double getDivisionResult() {
        if (secondNumber == 0) return 0;
        return firstNumber / secondNumber;
    }
}
