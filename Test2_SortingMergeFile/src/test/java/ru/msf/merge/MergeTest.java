package ru.msf.merge;

import org.junit.Test;
import ru.msf.exception.NotSortedFileException;
import ru.msf.io.InputFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static ru.msf.merge.Merge.merge;

public class MergeTest {

    @Test
    public void whenMerge3ArrayListThenOneMergedArrayList()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt");
        InputFile inFile2 = new InputFile("in2.txt");
        InputFile inFile3 = new InputFile("in3.txt");
        ArrayList<Integer> in1 = inFile1.getFileContent();
        ArrayList<Integer> in2 = inFile2.getFileContent();
        ArrayList<Integer> in3 = inFile3.getFileContent();
        ArrayList<Integer> out = merge(in1, in2, in3);
        int result = out.get(0);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMerge3ArrayListDescendingThenOneMergedArrayList()
            throws IOException, NotSortedFileException {

        InputFile inFile1 = new InputFile("in1.txt");
        InputFile inFile2 = new InputFile("in2.txt");
        InputFile inFile3 = new InputFile("in3.txt");
        ArrayList<Integer> in1 = inFile1.getFileContent();
        ArrayList<Integer> in2 = inFile2.getFileContent();
        ArrayList<Integer> in3 = inFile3.getFileContent();
        ArrayList<Integer> out = merge(in1, in2, in3, false);
        int result = out.get(0);
        int expected = 27;
        assertThat(result, is(expected));
    }
}