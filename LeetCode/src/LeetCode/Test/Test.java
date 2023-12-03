package LeetCode.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Test {

    private static int indexOf(int num, int[] arr) {
        //找到排序值的索引位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }


}
