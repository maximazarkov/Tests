package ru.msf.io;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class InputFileTest {

    @Test
    public void ls() throws FileNotFoundException {
        new InputFile("").ls();
    }
}