package ru.azee.phonewords.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by azee on 25.10.16.
 */
public class FileDictionaryProvider implements DictionaryProvider {

    private String filePath;

    public FileDictionaryProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> provide() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            list = br.lines().filter(line -> line.length() > 1).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
