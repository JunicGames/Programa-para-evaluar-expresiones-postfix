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

                if (stack.isEmpty())
                    throw new CalcException("Operandos insuficientes");

                int b = stack.pop();

                if (stack.isEmpty())
                    throw new CalcException("Operandos insuficientes");

                int a = stack.pop();
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

        if (stack.isEmpty())
            throw new CalcException("Expresion invalida");

        int result = stack.pop();

        if (!stack.isEmpty())
            throw new CalcException("Expresion invalida");

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