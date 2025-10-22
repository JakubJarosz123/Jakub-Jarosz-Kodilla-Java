package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() {
        ClassLoader loader = getClass().getClassLoader();
        File file = new File(loader.getResource("names.txt").getFile());

        try (Stream<String> filelines = Files.lines(Paths.get(file.getPath()))){
            filelines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("I'll be here, always!");
        }

        System.out.println(file.getPath());
    }
}