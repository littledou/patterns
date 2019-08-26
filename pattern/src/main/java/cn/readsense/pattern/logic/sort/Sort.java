package cn.readsense.pattern.logic.sort;

import java.util.Arrays;

public class Sort {

    /**
     * 两个相邻数相比较，较大数下沉，较小数上升
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        int length = arr.length;
        int count = 0;

        for (int i = 0; i < length; i++) {

            boolean needExchange = false;
            for (int j = i + 1; j < length; j++) {

                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    needExchange = true;
                }
                count++;

                System.out.println(Arrays.toString(arr) + " needExchange:" + needExchange);
            }
        }
    }

    public static void main(String args[]) {

        int arr[] = new int[]{
                29, 65, 34, 24, 56, 78, 97, 4, 32, 56
        };
        bubbleSort(arr);

    }
}
