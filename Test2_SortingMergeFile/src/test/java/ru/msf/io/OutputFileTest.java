package ru.msf.io;

import org.junit.Before;
import org.junit.Test;
import ru.msf.exception.NotSortedFileException;

import java.io.IOException;
import java.util.ArrayList;

//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
import static ru.msf.merge.Merge.merge;

public class OutputFileTest {

    String filePath;

    @Before
    public void before() {
        String fs = System.getProperty("file.separator");
        filePath = "." + fs + "src" + fs + "main" + fs + "java" + fs + "resources" + fs;
    }

    @Test
    public void saveFile() throws IOException {

        OutputFile opf = new OutputFile("out.txt", filePath);
        opf.saveFile();
    }

    @Test
    public void whenSaveDataToFile()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt", filePath);
        InputFile inFile2 = new InputFile("in2.txt", filePath);
        InputFile inFile3 = new InputFile("in3.txt", filePath);
        OutputFile outFile = new OutputFile("out.txt", filePath);
        ArrayList<Integer> in1 = inFile1.getFileContent();
        ArrayList<Integer> in2 = inFile2.getFileContent();
        ArrayList<Integer> in3 = inFile3.getFileContent();
        ArrayList<Integer> out = merge(in1, in2, in3, false);
        outFile.saveFile(out);
    }
}