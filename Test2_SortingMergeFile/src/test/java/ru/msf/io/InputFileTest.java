package ru.msf.io;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class InputFileTest {
    private String filePath;

    @Before
    public void before() {
        // получаем разделитель пути в текущей операционной системе
        String fs = System.getProperty("file.separator");
        filePath = "." + fs + "src" + fs + "main" + fs + "java" + fs + "resources" + fs;
    }

    @Test
    public void whenGetFileContent() throws IOException {
        ArrayList<Integer> in = new ArrayList<>();
        InputFile inFile = new InputFile("in1.txt", filePath);
        in = inFile.getFileContent();
        assertThat(in.get(0), is(1));
    }
}