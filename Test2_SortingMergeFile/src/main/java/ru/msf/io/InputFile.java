package ru.msf.io;

import java.io.*;

public class InputFile {
    private FileInputStream fileInputStream;
    private File folder;

    public InputFile(String fileInputStream) throws FileNotFoundException {
//        this.folder = new File("C:\\projects\\Tests\\Test2_SortingMergeFile" + fileInputStream);
        this.folder = new File("C:\\projects\\Tests\\Test2_SortingMergeFile\\src\\main\\java\\ru\\msf\\io\\" + fileInputStream);
        this.fileInputStream = new FileInputStream(folder);
    }

    public void ls() {
        if (folder.isDirectory()) {
           String[] dirContents = folder.list();
           for (int i = 0; i < dirContents.length; i++) {
               System.out.println(dirContents[i]);
           }
        }
//        for (File file : folder.listFiles()) {
//            System.out.println(file.getName());
//        }
    }
}
