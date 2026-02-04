package app;

import stack.Stack;

public class CalcPostfix implements Calc {

    private final Stack<Integer> stack;

    public CalcPostfix(Stack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int Operate(String input) throws Exception {

        String[] tokens = input.split(" ");

        for (String token : tokens) {

            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            }
            else if (isOperator(token)) {

                int b;
                int a;

                try {
                    b = stack.pop();
                    a = stack.pop();
                } catch (Exception e) {
                    throw new CalcException("Operandos insuficientes");
                }

                int result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> {
                        if (b == 0)
                            throw new CalcException("Division entre cero");
                        yield a / b;
                    }
                    default -> throw new CalcException("Operador invalido");
                };

                stack.push(result);
            }
            else {
                throw new CalcException("Token invalido: " + token);
            }
        }

        int result;
        try {
            result = stack.pop();
        } catch (Exception e) {
            throw new CalcException("Expresion invalida");
        }

        try {
            stack.pop();
            throw new CalcException("Expresion invalida");
        } catch (CalcException e) {
            throw e;
        } catch (Exception e) {
        }

        return result;
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}