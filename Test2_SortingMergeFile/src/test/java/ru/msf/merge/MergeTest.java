package ru.msf.merge;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.msf.exception.NotSortedFileException;
import ru.msf.io.InputFile;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static ru.msf.merge.Merge.merge;

public class MergeTest {
    private String filePath;

    @Before
    public void before() {
        // получаем разделитель пути в текущей операционной системе
        String fs = System.getProperty("file.separator");
        filePath = "." + fs + "src" + fs + "main" + fs + "java" + fs + "resources" + fs;
    }

    @Test
    public void whenMerge3ArrayArrayListThenOneMergedArrayList()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt", filePath);
        InputFile inFile2 = new InputFile("in2.txt", filePath);
        InputFile inFile3 = new InputFile("in3.txt", filePath);
        ArrayList<ArrayList<Integer>> inData = new ArrayList<>();
        inData.add(inFile1.getFileContent());
        inData.add(inFile2.getFileContent());
        inData.add(inFile3.getFileContent());
        ArrayList<Integer> out = merge(inData);
        int result = out.get(0);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMerge3ArrayArrayListDescendingThenOneMergedArrayList()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt", filePath);
        InputFile inFile2 = new InputFile("in2.txt", filePath);
        InputFile inFile3 = new InputFile("in3.txt", filePath);
        ArrayList<ArrayList<Integer>> inData = new ArrayList<>();
        inData.add(inFile1.getFileContent());
        inData.add(inFile2.getFileContent());
        inData.add(inFile3.getFileContent());
        // direction:
        // true - по возрастанию (ascending order)
        // false - по убыванию (descending order)
        ArrayList<Integer> out = merge(inData, false);
        int result = out.get(0);
        int expected = 27;
        assertThat(result, is(expected));
    }

    @Test
    @Ignore
    public void whenMerge3ArrayListThenOneMergedArrayList()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt", filePath);
        InputFile inFile2 = new InputFile("in2.txt", filePath);
        InputFile inFile3 = new InputFile("in3.txt", filePath);
        ArrayList<Integer> in1 = inFile1.getFileContent();
        ArrayList<Integer> in2 = inFile2.getFileContent();
        ArrayList<Integer> in3 = inFile3.getFileContent();
        ArrayList<Integer> out = merge(in1, in2, in3);
        int result = out.get(0);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    @Ignore
    public void whenMerge3ArrayListDescendingThenOneMergedArrayList()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt", filePath);
        InputFile inFile2 = new InputFile("in2.txt", filePath);
        InputFile inFile3 = new InputFile("in3.txt", filePath);
        ArrayList<Integer> in1 = inFile1.getFileContent();
        ArrayList<Integer> in2 = inFile2.getFileContent();
        ArrayList<Integer> in3 = inFile3.getFileContent();
        ArrayList<Integer> out = merge(in1, in2, in3, false);
        int result = out.get(0);
        int expected = 27;
        assertThat(result, is(expected));
    }
}