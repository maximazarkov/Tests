package ru.msf.io;

import java.io.*;
import java.util.ArrayList;

public class InputFile {
    private String file;
    private FileReader fileIn = null;

    private ArrayList<Integer> in = new ArrayList<>();

    public InputFile(String fileNameInput, String fp) throws FileNotFoundException {
        this.file = fp + fileNameInput;
//        FileInputStream fileIn = new FileInputStream(file);
    }

    /**
     * Метод, позволяющий прочитать содержимое файла.
     * @author Азарков Максим
     * @version 0.1
     * @return - массив данных, прочитанных из файла
     */
    public ArrayList<Integer> getFileContent() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {

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
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return in;
    }
}
