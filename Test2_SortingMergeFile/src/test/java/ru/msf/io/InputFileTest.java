package ru.msf.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class InputFileTest {


    @Test
    public void whenLsGetFileName() throws FileNotFoundException {
        new InputFile("in3.txt").ls();
    }

    @Test(expected = FileNotFoundException.class)
    public void whenLsNotGetFileName() throws FileNotFoundException {
        new InputFile("").ls();
    }

    @Test
    public void whenGetFileContent() throws FileNotFoundException {
        ArrayList<Integer> in = new ArrayList<>();
        InputFile inFile = new InputFile("in1.txt");
        in = inFile.getFileContent();
        assertThat(in.get(0), is(1));
    }
}