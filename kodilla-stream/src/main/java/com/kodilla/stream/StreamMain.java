package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterable.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Java programming", text -> "_" + text + "_");
        poemBeautifier.beautify("Java programming", text -> "ABC " + text + " ABC");
        poemBeautifier.beautify("Java programming", text -> text.toUpperCase());
        poemBeautifier.beautify("Java programming", text -> text.toLowerCase());

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
