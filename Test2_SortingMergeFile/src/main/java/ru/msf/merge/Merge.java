package ru.msf.merge;

import java.util.ArrayList;

public class Merge {

    public Merge() {

    }

    /**
     * Метод возвращает массив данных, полученных из трех файлов и отсортированных по алгоритму сортировки слияния.
     * @param in1 - первый файл
     * @param in2 - второй файл
     * @param in3 - третий файл
     * @return - отсортированный, объединенный массив
     * @author Азарков Максим
     * @version 0.1
     * @deprecated
     */
    public static Integer[] merge(Integer[] in1, Integer[] in2, Integer[] in3) {


        Integer[] a1 = in1;
        Integer[] a2 = in2;
        Integer[] a3 = in3;
        Integer[] out = new Integer[a1.length + a2.length + a3.length];

        a1 = simpleMerge(a1, a2);
        out = simpleMerge(a1, a3);

        return out;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> in1, ArrayList<Integer> in2, ArrayList<Integer> in3) {

        ArrayList<Integer> a1 = in1;
        ArrayList<Integer> a2 = in2;
        ArrayList<Integer> a3 = in3;
        ArrayList<Integer> out;

        a1 = simpleMergeList(a1, a2);
        out = simpleMergeList(a1, a3);

        return out;
    }

    /**
     * Метод, выполняющий сливание двух массивов алгоритмом слияния
     * @param arr1 - первый массив
     * @param arr2 - второй массив
     * @return - резальтат работы алгоритма слияния в виде коллекции ArrayList<Integer>
     * @version 0.1
     */
    private static ArrayList<Integer> simpleMergeList(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> a1 = arr1;
        ArrayList<Integer> a2 = arr2;
        ArrayList<Integer> out = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        for (int k = 0; k < (a1.size() + a2.size()); k++) {

            if (index1 > a1.size() - 1) {
                out.add(a2.get(index2++));
            } else if (index2 > a2.size() - 1) {
                out.add(a1.get(index1++));
            } else if (a1.get(index1) < a2.get(index2)) {
                out.add(a1.get(index1++));
            } else {
                out.add(a2.get(index2++));
            }
        }
        return out;
    }

    /**
     * Метод, выполняющий сливание двух массивов алгоритмом слияния
     * @param arr1 - первый массив
     * @param arr2 - второй массив
     * @return - резальтат работы алгоритма слияния
     * @version 0.1
     * @deprecated
     */
    private static Integer[] simpleMerge(Integer[] arr1, Integer[] arr2) {
        Integer[] a1 = arr1;
        Integer[] a2 = arr2;
        Integer[] out = new Integer[a1.length + a2.length];

        int index1 = 0;
        int index2 = 0;

        for (int k = 0; k < out.length; k++) {

            if (index1 > a1.length - 1) {
                int x = a2[index2];
                out[k] = x;
                index2++;
            } else if (index2 > a2.length - 1) {
                int x = a1[index1];
                out[k] = x;
                index1++;
            } else if (a1[index1] < a2[index2]) {
                int x = a1[index1];
                out[k] = x;
                index1++;
            } else {
                int b = a2[index2];
                out[k] = b;
                index2++;
            }
        }
        return out;
    }


}
