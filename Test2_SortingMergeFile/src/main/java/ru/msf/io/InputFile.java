package ru.msf.io;

import java.io.*;
import java.util.ArrayList;

public class InputFile {
    private FileInputStream fileInputStream;
    private File file;
    private final String pathToFile = "./src/resources/";
    private ArrayList<Integer> in = new ArrayList<>();

    public InputFile(String fileNameInput) throws FileNotFoundException {
        this.file = new File(pathToFile + fileNameInput);
        this.fileInputStream = new FileInputStream(file);
    }

    /**
     * Метод, позволяющий просмотреть содержимое директории resources.
     * @author Азарков Максим
     * @version 0.2
     * @deprecated
     */
    public void ls() {
        try {
            if (file.isDirectory()) {
               String[] dirContents = file.list();
               for (int i = 0; i < dirContents.length; i++) {
                   System.out.println(dirContents[i]);
               }
            }
            //  прочитаем содержимое директории (для теста)
            for (File file : new File(pathToFile).listFiles()) {
                System.out.println(file.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Метод, позволяющий прочитать содержимое файла.
     * @author Азарков Максим
     * @version 0.1
     * @return - массив данных, прочитанных из файла
     */
    public ArrayList<Integer> getFileContent() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                try {
                    in.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    in.add(0);  // временное решение
                    // можно формировать исключение, как для не правильного файла
                }
//                System.out.println(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return in;
    }
}
