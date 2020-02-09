package ru.msf.merge;

import org.junit.Test;
import ru.msf.io.InputFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static ru.msf.merge.Merge.merge;

public class MergeTest {

    @Test
    public void whenMerge3ArrayThenOneMergedArray() {
        Integer[] in1 = new Integer[] {1, 4, 9};
        Integer[] in2 = new Integer[] {1, 8, 27};
        Integer[] in3 = new Integer[] {1, 2, 3};
        Integer[] result = new Integer[in1.length + in2.length + in3.length];
        result = merge(in1, in2, in3);
        Integer[] expected = new Integer[] {1, 1, 1, 2, 3, 4, 8, 9, 27};
        assertThat(result, is(expected));
        }

    @Test
    public void whenMerge3ArrayListThenOneMergedArrayList() throws FileNotFoundException {
        InputFile inFile1 = new InputFile("in1.txt");
        InputFile inFile2 = new InputFile("in2.txt");
        InputFile inFile3 = new InputFile("in3.txt");
        ArrayList<Integer> in1 = inFile1.getFileContent();
        ArrayList<Integer> in2 = inFile2.getFileContent();
        ArrayList<Integer> in3 = inFile3.getFileContent();
        ArrayList<Integer> out = merge(in1, in2, in3);
        int result = out.get(8);
        int expected = 27;
        assertThat(result, is(expected));
        result = out.get(3);
        expected = 2;
        assertThat(result, is(expected));
    }
}