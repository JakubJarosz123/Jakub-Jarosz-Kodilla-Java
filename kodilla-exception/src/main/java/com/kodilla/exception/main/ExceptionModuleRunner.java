package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.File;
import java.io.IOException;

public class ExceptionModuleRunner {
    public static void main(String[] args) throws FileReaderException {
        FileReader fileReader = new FileReader();
        fileReader.readFile("nie-ma-pliku.txt");
    }
}
