package ru.msf.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OutputFile {
    private FileWriter fileOut = null;
    private String filePath;
    // получаем разделитель пути в текущей операционной системе
    String fs = System.getProperty("file.separator");
    private final String pathToFile = "." + fs + "src" + fs + "resources" + fs;
    private ArrayList<Integer> out = new ArrayList<>();

    public OutputFile(String fileNameInput)  throws IOException {
        this.filePath = pathToFile + fileNameInput;
    }

    public void saveFile() throws IOException {

        try {
            fileOut = new FileWriter(this.filePath);
            String text = "test for saving to file";
            fileOut.write(text);
        } finally {
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }

    public void saveFile(ArrayList<Integer> al) throws IOException {
        ArrayList<Integer> outData = al;
        Iterator it = outData.iterator();
        try {
            fileOut = new FileWriter(this.filePath);
            while (it.hasNext()) {
                fileOut.write(it.next().toString() + System.lineSeparator());
            }

        } finally {
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }
}
