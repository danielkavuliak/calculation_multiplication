package com.company;

import java.util.ArrayList;

/**
 * Class ArithmeticFormula represents relation between two numbers and performs multiplication between two numbers.
 *
 * @author Daniel Kavuliak
 */
public class ArithmeticFormula {
    private char number1[];
    private char number2[];

    /**
     * Constructs object, converts String objects to char arrays and initialize object.
     *
     * @param number1 first number from command line
     * @param number2 second number from command line
     */
    public ArithmeticFormula(String number1, String number2) {
        this.number1 = number1.toCharArray();
        this.number2 = number2.toCharArray();
    }

    /**
     * Checks both numbers for letters.
     *
     * @return true if letter is found
     */
    public boolean containsLetters() {
        for (char c : number1)
            if (c < '0' || c > '9')
                return true;

        for (char c : number2)
            if (c < '0' || c > '9')
                return true;

        return false;
    }

    /**
     * Reverses both numbers.
     */
    private void reverseArray() {
        char tmp;

        for (int i = 0; i < number1.length/2; i++) {
            tmp = number1[i];
            number1[i] = number1[number1.length - 1 - i];
            number1[number1.length - 1 - i] = tmp;
        }

        for (int i = 0; i < number2.length/2; i++) {
            tmp = number2[i];
            number2[i] = number2[number2.length - 1 - i];
            number2[number2.length - 1 - i] = tmp;
        }
    }

    /**
     * Converts character representation of number to actual number.
     */
    private void convertCharToInteger() {
        for (int i = 0; i < number1.length; i++)
            number1[i] -= 48;

        for (int i = 0; i < number2.length; i++)
            number2[i] -= 48;
    }

    /**
     * Performs multiplication between two numbers.
     *
     * @return reversed array list of answer
     */
    public ArrayList<Integer> multiplication() {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        reverseArray();
        convertCharToInteger();

        for (int i = 0; i < number1.length + number2.length; i++)
            answer.add(0);

        for (int i = 0; i < number2.length; i++) {
            for (int j = 0; j < number1.length; j++) {
                answer.set(i + j, answer.get(i + j) + (number1[j] * number2[i]) % 10);

                if (answer.get(i + j) >= 10) {
                    answer.set(i + j + 1, answer.get(i + j + 1) + answer.get(i + j) / 10);
                    answer.set(i + j, answer.get(i + j) % 10);
                }

                answer.set(i + j + 1, answer.get(i + j + 1) + (number1[j] * number2[i]) / 10);
            }
        }

        for (int i = answer.size() - 1; i > 0; i--) {
            if (answer.get(i) != 0)
                break;
            answer.remove(i);
        }

        return answer;
    }
}
