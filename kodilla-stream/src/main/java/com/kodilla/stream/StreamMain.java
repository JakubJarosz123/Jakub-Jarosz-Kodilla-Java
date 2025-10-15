package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Java programming", text -> "_" + text + "_");
        poemBeautifier.beautify("Java programming", text -> "ABC " + text + " ABC");
        poemBeautifier.beautify("Java programming", text -> text.toUpperCase());
        poemBeautifier.beautify("Java programming", text -> text.toLowerCase());
    }
}
