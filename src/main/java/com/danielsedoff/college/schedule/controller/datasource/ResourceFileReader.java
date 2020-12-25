package com.danielsedoff.college.schedule.controller.datasource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResourceFileReader {
    public String readFileToString(String fileName) throws IOException {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        try (BufferedReader bufReader = new BufferedReader(new FileReader(file));
                Stream<String> resourceContent = bufReader.lines()) {
            return resourceContent.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new IOException(String
                    .format("Issues while reading the data from file: %s", fileName), e);
        }
    }
}
