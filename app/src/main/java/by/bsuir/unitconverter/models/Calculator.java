package by.bsuir.unitconverter.models;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    private static String firstArg = "";
    private static String firstArgSign = "";
    private static String secondArg = "";

    public static BigDecimal result = new BigDecimal("0");
    private static String operator = "";
    private static boolean isWaitingForSecondArg = false;

    private static boolean isPlusOrMin = false;
    private static boolean isOperationSign = false;


    public static String processExpr(String button_selected) {
        boolean isMulOrDiv = button_selected.equals("/") || button_selected.equals("*");
        isPlusOrMin = button_selected.equals("-") || button_selected.equals("+");
        isOperationSign = isMulOrDiv || isPlusOrMin;


        if (button_selected.equals("del")) {
            removeSymbol();
        } else if (button_selected.equals("c")) {
            clearSymbols();
            result = new BigDecimal("0");
        } else if (firstArg.equals("") || secondArg.equals("")) { //если как минимум один аргумент не задан,
            if (!button_selected.equals("=")) {
                parseStr(button_selected);
            }
        } else { // если все аргументы заданы
            if (button_selected.equals("=")) {
                calculateExpr();
                clearSymbols();
                firstArg = result.toString();
            } else if (isOperationSign) {
                calculateExpr();
                clearSymbols();
                firstArg = result.toString();
                parseStr(button_selected);
            } else {
                parseStr(button_selected);
            }
        }

        return firstArgSign + firstArg + operator + secondArg;
    }

    private static void parseStr(String button_selected) {


        if (isOperationSign) {
            if (!firstArg.equals("")) { // в этом случае это знак числа, а не оператор.
                operator = button_selected;
                isWaitingForSecondArg = true;
            } else if (isPlusOrMin) {
                firstArgSign = button_selected;
            }
        } else if (isWaitingForSecondArg) {
            if (!(button_selected.equals(".") && secondArg.contains("."))) {
                secondArg += button_selected;
                calculateExpr();
            }
        } else {
            if (!(button_selected.equals(".") && firstArg.contains("."))) {
                firstArg += button_selected;
                calculateExpr();
            }
        }
    }

    private static void calculateExpr() {
        if (firstArg.equals("") || firstArg.equals(".")) {
            result = new BigDecimal("0");
        } else if (secondArg.equals("") || secondArg.equals(".")) {
            result = new BigDecimal(firstArgSign + firstArg);
        } else {
            BigDecimal firstNum = new BigDecimal(firstArgSign + firstArg);
            BigDecimal secondNum = new BigDecimal(secondArg);

            switch (operator) {
                case "+": {
                    result = new BigDecimal(Converter.getStrippedDouble(firstNum.add(secondNum).doubleValue()));
                    break;
                }
                case "-": {
                    result = new BigDecimal(Converter.getStrippedDouble(firstNum.subtract(secondNum).doubleValue()));
                    break;
                }
                case "/": {
                    try {
                        result = new BigDecimal(Converter.getStrippedDouble(firstNum.divide(secondNum, 6, RoundingMode.HALF_UP).doubleValue()));
                    } catch (ArithmeticException a) {
                        result = new BigDecimal("0");
                    }
                    break;
                }
                case "*": {
                    result = new BigDecimal(Converter.getStrippedDouble(firstNum.multiply(secondNum).doubleValue()));
                    break;
                }
            }
        }
    }

    private static void removeSymbol() {
        if (!secondArg.equals("")) {
            secondArg = secondArg.substring(0, secondArg.length() - 1);
            calculateExpr();
        } else if (!operator.equals("")) {
            operator = "";
            isWaitingForSecondArg = false;
        } else if (!firstArg.equals("")) {
            firstArg = firstArg.substring(0, firstArg.length() - 1);
            calculateExpr();
        } else {
            firstArgSign = "";
            result = new BigDecimal("0");
        }
    }


    private static void clearSymbols() {
        firstArg = "";
        firstArgSign = "";
        secondArg = "";
        operator = "";
        isWaitingForSecondArg = false;
    }
}

