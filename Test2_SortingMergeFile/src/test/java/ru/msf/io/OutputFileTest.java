package ru.msf.io;

import org.junit.Test;
import ru.msf.exception.NotSortedFileException;

import java.io.IOException;
import java.util.ArrayList;

//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
import static ru.msf.merge.Merge.merge;

public class OutputFileTest {

    @Test
    public void saveFile() throws IOException {
        OutputFile opf = new OutputFile("out.txt");
        opf.saveFile();
    }

    @Test
    public void whenSaveDataToFile()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt");
        InputFile inFile2 = new InputFile("in2.txt");
        InputFile inFile3 = new InputFile("in3.txt");
        OutputFile outFile = new OutputFile("out.txt");
        ArrayList<Integer> in1 = inFile1.getFileContent();
        ArrayList<Integer> in2 = inFile2.getFileContent();
        ArrayList<Integer> in3 = inFile3.getFileContent();
        ArrayList<Integer> out = merge(in1, in2, in3, false);
        outFile.saveFile(out);
    }
}