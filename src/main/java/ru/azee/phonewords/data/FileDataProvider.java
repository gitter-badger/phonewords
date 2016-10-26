package ru.azee.phonewords.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by azee on 25.10.16.
 */
public class FileDataProvider implements DataProvider {
    private String path;

    public FileDataProvider(String path) {
        this.path = path;
    }

    @Override
    public List<String> provide() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            return br.lines().collect(toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
