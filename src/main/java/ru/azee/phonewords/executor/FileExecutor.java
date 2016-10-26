package ru.azee.phonewords.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by azee on 26.10.16.
 */
public class FileExecutor extends Executor {
    private String dataFilePath;

    public FileExecutor(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    @Override
    public void execute() {
        printValues(traversal.getValues(getData()));
    }

    private List<String> getData(){
        try (BufferedReader br = Files.newBufferedReader(Paths.get(dataFilePath))) {
            return br.lines().collect(toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }


}
