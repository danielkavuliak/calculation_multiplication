package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Nespravny pocet argumentov. Program sa skonci.");
            System.exit(1);
        }

        ArithmeticFormula formula = new ArithmeticFormula(args[0], args[1]);

        if (formula.containsLetters()) {
            System.out.println("Nezadali ste cislo. Program sa skonci.");
            System.exit(1);
        }

        ArrayList<Integer> answer = formula.multiplication();

        for (int i = answer.size() - 1; i >= 0; i--)
            System.out.print(answer.get(i));
        System.out.println();
    }
}
