package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling{

    public void readFile() throws IOException{
        ClassLoader loader = getClass().getClassLoader();
        File file = new File(loader.getResource("names.txt").getFile());
        Stream<String> filelines = Files.lines(Paths.get(file.getPath()));
        filelines.forEach(System.out::println);
    }
}
