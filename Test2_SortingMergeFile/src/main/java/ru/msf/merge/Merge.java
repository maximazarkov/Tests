package ru.msf.merge;

import ru.msf.exception.NotSortedFileException;

import java.util.ArrayList;
import java.util.Iterator;

public class Merge {

    /**
     * Метод возвращает массив данных, полученных из трех файлов и отсортированных по алгоритму сортировки слияния по возрастанию (по умолчанию).
     * @param in1 - первый файл
     * @param in2 - второй файл
     * @param in3 - третий файл
     * @return - отсортированный, объединенный массив
     * @author Азарков Максим
     * @version 0.1
     * @since 0.3
     * @throws NotSortedFileException
     * @deprecated
     */
    public static ArrayList<Integer> merge(ArrayList<Integer> in1,
                                           ArrayList<Integer> in2,
                                           ArrayList<Integer> in3)
            throws NotSortedFileException {
        return merge(in1, in2, in3, true);
    }

    /**
     * Метод возвращает массив данных, полученных из трех файлов и отсортированных по алгоритму сортировки слияния по возрастанию (по умолчанию).
     * @param inList - список данных из всех файлов, которые нужно отсортировать
     * @return - отсортированный, объединенный массив
     * @author Азарков Максим
     * @since 0.4
     * @throws NotSortedFileException
     */
    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> inList)
            throws NotSortedFileException {
        return merge(inList,  true);
    }

    /**
     * Метод возвращает массив данных, полученных из трех файлов и отсортированных по алгоритму сортировки слияния либо по возрастанию, либо по убыванию.
     * @param inList - список данных из всех файлов, которые нужно отсортировать
     * @param direction - направление сортрировки слиянием. true - по возрастанию, false - по убыванию
     * @return - отсортированный, объединенный массив
     * @author Азарков Максим
     * @since 0.4
     * @throws NotSortedFileException - исключение формируется в случае ,если один из файлов не отсортирован
     */
    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> inList, boolean direction)
            throws NotSortedFileException {

        ArrayList<ArrayList<Integer>> arrayLists = inList;
        ArrayList<Integer> out = new ArrayList<>();

        int count = 0;

        if (arrayLists.size() > 1) {
            out = arrayLists.get(count++);
            while (count < arrayLists.size()) {
                out = simpleMergeAscendingOrder(out, arrayLists.get(count++));
            }
        }

            // true - по возрастанию (ascending order)
            // false - по убыванию (descending order)
        if (direction) {
            out = simpleMergeAscendingOrder(out, arrayLists.get(count));
        } else {
            out = simpleMergeDescendingOrder(out, arrayLists.get(count));
        }

//            count++;

        return out;
    }

    /**
     * Метод возвращает массив данных, полученных из трех файлов и отсортированных по алгоритму сортировки слияния либо по возрастанию, либо по убыванию.
     * @param in1 - первый файл
     * @param in2 - второй файл
     * @param in3 - третий файл
     * @param direction - направление сортрировки слиянием. true - по возрастанию, false - по убыванию
     * @return - отсортированный, объединенный массив
     * @author Азарков Максим
     * @version 0.2
     * @since 0.2
     * @throws NotSortedFileException - исключение формируется в случае ,если один из файлов не отсортирован
     * @deprecated
     */
    public static ArrayList<Integer> merge(ArrayList<Integer> in1,
                                           ArrayList<Integer> in2,
                                           ArrayList<Integer> in3,
                                           boolean direction)
            throws NotSortedFileException {

        ArrayList<Integer> a1 = in1;
        ArrayList<Integer> a2 = in2;
        ArrayList<Integer> a3 = in3;
        ArrayList<Integer> out;

        // true - по возрастанию (ascending order)
        // false - по убыванию (descending order)
        if (direction) {
            a1 = simpleMergeAscendingOrder(a1, a2);
            out = simpleMergeAscendingOrder(a1, a3);
        } else {
            // сначала прогоним сортировку по возрастанию
            a1 = simpleMergeAscendingOrder(a1, a2);
            // а на выходе сформируем итоговый массив по убыванию
            out = simpleMergeDescendingOrder(a1, a3);
        }

        return out;
    }

    private static ArrayList<Integer> simpleMergeDescendingOrder(ArrayList<Integer> arr1,
                                                                 ArrayList<Integer> arr2)
            throws NotSortedFileException {

        ArrayList<Integer> a1 = arr1;
        ArrayList<Integer> a2 = arr2;
        ArrayList<Integer> out = new ArrayList<>();

        int index1 = a1.size() - 1;
        int index2 = a2.size() - 1;
        int min1 = getMaxItem(a1);
        int min2 = getMaxItem(a2);
        int error = 0;

        for (int k = 0; k < (a1.size() + a2.size()); k++) {
            if ((index1 >= 0 && min1 < a1.get(index1))) {
//                throw new NotSortedFileException("The data in the file (Array a1) is not sorted. ");
                index1--;
                error++;
                continue;
            }
            if (index2 >= 0 && min2 < a2.get(index2)) {
//                throw new NotSortedFileException("The data in the file  (Array a2) is not sorted. ");
                index2--;
                error++;
                continue;
            }
            if (index1 < 0) {
                out.add(a2.get(index2--));
                min2 = out.get(k - error);
            } else if (index2 < 0) {
                out.add(a1.get(index1--));
                min1 = out.get(k - error);
            } else if (a1.get(index1) > a2.get(index2)) {
                out.add(a1.get(index1--));
                min1 = out.get(k - error);
            } else {
                out.add(a2.get(index2--));
                min2 = out.get(k - error);
            }
        }

        return out;
    }

    /**
     * Метод, выполняющий сливание двух массивов алгоритмом слияния по возрастанию
     * @param arr1 - первый массив
     * @param arr2 - второй массив
     * @return - резальтат работы алгоритма слияния в виде коллекции ArrayList<Integer>
     * @since 0.2
     */
    private static ArrayList<Integer> simpleMergeAscendingOrder(ArrayList<Integer> arr1, ArrayList<Integer> arr2) throws NotSortedFileException {
        ArrayList<Integer> a1 = arr1;
        ArrayList<Integer> a2 = arr2;
        ArrayList<Integer> out = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;
        int max1 = getMinItem(a1);
        int max2 = getMinItem(a2);
        int error = 0;

        for (int k = 0; k < (a1.size() + a2.size()); k++) {
            if (index1 < a1.size() && max1 > a1.get(index1)) {
//                throw new NotSortedFileException("The data in the file (Array a1) is not sorted. ");
                index1++;
                error++;
                continue;
            }
            if (index2 < a2.size() && max2 > a2.get(index2)) {
//                throw new NotSortedFileException("The data in the file  (Array a2) is not sorted. ");
                index2++;
                error++;
                continue;
            }
            if (index1 > a1.size() - 1) {
                out.add(a2.get(index2++));
                max2 = out.get(k - error);
            } else if (index2 > a2.size() - 1) {
                out.add(a1.get(index1++));
                max1 = out.get(k - error);
            } else if (a1.get(index1) < a2.get(index2)) {
                out.add(a1.get(index1++));
                max1 = out.get(k - error);
            } else {
                out.add(a2.get(index2++));
                max2 = out.get(k - error);
            }
        }
        return out;
    }

    private static int getMinItem(ArrayList<Integer> al) {
        int result = al.get(0);
        Iterator<Integer> it = al.iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (result > i) {
                result = i;
            }
        }
        return result;
    }

    private static int getMaxItem(ArrayList<Integer> al) {
        int result = 0;
        if (al.size() > 0) {
            result = al.get(0);
            Iterator<Integer> it = al.iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result < i) {
                    result = i;
                }
            }
        }
        return result;
    }
}
