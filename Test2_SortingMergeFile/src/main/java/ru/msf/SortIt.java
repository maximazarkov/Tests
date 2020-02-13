package ru.msf;

import ru.msf.exception.NotSortedFileException;
import ru.msf.io.InputFile;
import ru.msf.io.OutputFile;

import java.io.IOException;
import java.util.ArrayList;

import static ru.msf.merge.Merge.merge;

public class SortIt {
    private String[] args;

    SortIt(String[] args) {
        this.args = args;
    }

    public static void main(String[] args) throws IOException, NotSortedFileException {
        String fs = System.getProperty("file.separator");
        String filePath = "c:" + fs + "projects" + fs + "tmp" + fs + "resources" + fs;
//    private static String filePath = "c:" + fs + "projects" + fs + "Test2_SortingMergeFile" + fs + "resources" + fs;


        if (args.length == 0) {
            System.out.println("Demo:");
            System.out.println("java SortIt -i -a out.txt in.txt (для целых чисел по возрастанию)");
            new SortIt(new String[]{"-i", "-a", "out1.txt", "in1.txt"}).init(filePath);
//            System.out.println("java SortIt -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)");
//            new SortIt().init(new String[]{"-s", "out2.txt", "in.txt"});
//            System.out.println("java SortIt -d -s out.txt in1.txt in2.txt (для строк по убыванию)");
//            new SortIt().init(new String[]{"-d", "-s", "out3.txt", "in.txt"});
            System.out.println("java SortIt -d -i out.txt in1.txt in2.txt (для целых чисел по убыванию)");
            new SortIt(new String[]{"-d", "-i", "out4.txt", "in1.txt", "in2.txt"}).init(filePath);
        } else {
            new SortIt(args).init(filePath);
        }

    }

    public void init(String pf) throws IOException, NotSortedFileException {
        String filePath = pf;

        int keyControlCount = checkKeyControlCount(args);
        int indexTypeData = checkTypeDataParam(args, keyControlCount);
        if (indexTypeData == -1) {
            printHelp();
            System.exit(1);
        }

        boolean descendingSort = checkDescending(args);
        boolean stringData = checkTypeData(args[indexTypeData]);

        String outFileName = args[keyControlCount++];

//        InputFile[] inFile = new InputFile[args.length - keyControlCount];
//        keyControlCount++;
        ArrayList<ArrayList<Integer>> inFileDataList = new ArrayList<>();
        for (int i = keyControlCount; i < args.length; i++) {
//            inFile[i] = new InputFile(args[i], filePath);
            inFileDataList.add(new InputFile(args[i], filePath).getFileContent());
        }

        OutputFile outFile = new OutputFile(outFileName, filePath);
        ArrayList<Integer> out = merge(inFileDataList, descendingSort);
        outFile.saveFile(out);
    }

    private int checkKeyControlCount(String[] args) {
        int result = 0;
        if (chechLengthArgs(args)) {
            for (int i = 0; i < 2; i++) {
                if (args[i].equals("-i") || args[i].equals("-s") || args[i].equals("-a") || args[i].equals("-d")) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean checkTypeData(String paramTypeData) {
        boolean result = true;
        if (paramTypeData.equals("-i")) {
            result = false;
        }
        return result;
    }

    private static int checkTypeDataParam(String[] args, int count) {
        int result = -1;
        if (chechLengthArgs(args)) {
            for (int i = 0; i < count; i++) {
                if (args[i].equals("-i") || args[i].equals("-s")) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    private static boolean checkDescending(String[] args) {
        boolean result = true;
        for (int i = 0; i < 2; i++) {
            if (args[i].equals("-d")) {
                result = false;
            }
        }
        return result;
    }

    private static boolean chechLengthArgs(String[] args) {
        boolean result = true;
        if (args.length < 3) {
            result = false;
        }
        return result;
    }

    private static void printHelp() {
        System.out.println(" java -jar SortIt [-a|-d] -i|-s outFileName inFileName1 [inFileName2 [inFileNameN]] ");
        System.out.println(" -a (по возрастанию) или -d (по убыванию) - режим сортировки. Параметр необязательный, по умолчанию сортируем по возрастанию");
        System.out.println("-s или -i - типы данных. -s - String, -i - Integer");
        System.out.println("outFileName - имя выходного файла, обязательное");
        System.out.println("inFileNameN – имена входных файлов, не менее одного");
        System.out.println("Примеры запуска программы:");
        System.out.println("java SortIt -i -a out.txt in.txt (для целых чисел по возрастанию)");
        System.out.println("java SortIt -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)");
        System.out.println("java SortIt -d -s out.txt in1.txt in2.txt (для строк по убыванию)");
    }

}
