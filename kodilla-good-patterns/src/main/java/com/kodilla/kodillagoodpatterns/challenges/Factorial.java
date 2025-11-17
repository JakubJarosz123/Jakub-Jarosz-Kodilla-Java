package com.kodilla.kodillagoodpatterns.challenges;

public class Factorial {

    public int calculateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int n = 5;

        int num = factorial.calculateFactorial(n);
        System.out.println(n + "! = " + num);
    }
}
