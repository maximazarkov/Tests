package ru.msf;

import org.junit.Test;
import ru.msf.exception.NotSortedFileException;

import java.io.IOException;

public class SortItTest {

    @Test
    public void init() throws IOException, NotSortedFileException {
        String fs = System.getProperty("file.separator");
        String filePath = "." + fs + "src" + fs + "main" + fs + "java" + fs + "resources" + fs;

        System.out.println("Demo:");
        System.out.println("java SortIt -i -a out1.txt in1.txt (для целых чисел по возрастанию)");
        new SortIt(new String[]{"-i", "-a", "out1.txt", "in1.txt"}).init(filePath);

//            System.out.println("java SortIt -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)");
//            new SortIt().init(new String[]{"-s", "out2.txt", "in.txt"});

//            System.out.println("java SortIt -d -s out.txt in1.txt in2.txt (для строк по убыванию)");
//            new SortIt().init(new String[]{"-d", "-s", "out3.txt", "in.txt"});

        System.out.println("java SortIt -d -i out4.txt in1.txt in2.txt (для строк по убыванию)");
        new SortIt(new String[]{"-d", "-i", "out4.txt", "in1.txt", "in2.txt"}).init(filePath);

    }
}