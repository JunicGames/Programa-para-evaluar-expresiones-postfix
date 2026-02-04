package app;

import stack.Stack;
import stack.StackVector;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new StackVector<>();

        Calc calc = new CalcPostfix(stack);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese expresion postfix: ");
        String input = scanner.nextLine();

        try {
            int result = calc.Operate(input);
            System.out.println("Resultado: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}