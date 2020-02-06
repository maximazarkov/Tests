package ru.msf.merge;

public class Merge {


    public Merge() {

    }

    public static Integer[] merge(Integer[] in1, Integer[] in2, Integer[] in3) {


        Integer[] a1 = in1;
        Integer[] a2 = in2;
        Integer[] a3 = in3;
        Integer[] out = new Integer[a1.length + a2.length + a3.length];

        a1 = simpleMerge(a1, a2);
        out = simpleMerge(a1, a3);

        return out;
    }


    private static Integer[] simpleMerge(Integer[] arr1, Integer[] arr2) {
        Integer[] a1 = arr1;
        Integer[] a2 = arr2;
        Integer[] out = new Integer[a1.length + a2.length];

        int index1 = 0;
        int index2 = 0;

        for (int k = 0; k < out.length; k++) {

            if (index1 > a1.length-1) {
                int x = a2[index2];
                out[k] = x;
                index2++;
            }
            else if (index2 > a2.length-1) {
                int x = a1[index1];
                out[k] = x;
                index1++;
            }
            else if (a1[index1] < a2[index2]) {
                int x = a1[index1];
                out[k] = x;
                index1++;
            }
            else {
                int b = a2[index2];
                out[k] = b;
                index2++;
            }
        }
        return out;
    }


}
