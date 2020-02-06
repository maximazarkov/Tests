package ru.msf.merge;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static ru.msf.merge.Merge.merge;

public class MergeTest {

    @Test
    public void whenMerge3ArrayThenOneMergedArray() {
        Integer[] in1 = new Integer[] {1, 4, 9};
        Integer[] in2 = new Integer[] {1, 8, 27};
        Integer[] in3 = new Integer[] {1, 2, 3};
        Integer[] result = new Integer[in1.length + in2.length + in3.length];
        result = merge(in1, in2, in3);
        Integer[] expected = new Integer[] {1, 1, 1, 2, 3, 4, 8, 9, 27};
        assertThat(result, is(expected));
        }
}