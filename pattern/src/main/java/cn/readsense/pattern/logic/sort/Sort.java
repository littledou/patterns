package cn.readsense.pattern.logic.sort;

import java.util.Arrays;

public class Sort {

    /**
     * 两个相邻数相比较，较大数下沉，较小数上升
     * 交换次数比选择排序要多，但是优化后的冒泡排序遍历次数可能会比选择排序少
     * 也就是说，逆序复杂度最高，正续复杂度最低，但是选择排序无关正逆
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            boolean needExchange = false;
            for (int j = i + 1; j < length; j++) {

                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    needExchange = true;
                }
            }
            System.out.println(Arrays.toString(arr) + " needExchange:" + needExchange);
            if (!needExchange) break;
        }
        System.out.println("\n");

//        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。
//            for (int j = arr.length - 1; j > i; j--) {
//
//                if (arr[j] < arr[j - 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                }
//            }
//            System.out.println(Arrays.toString(arr));
//        }

    }

    /**
     * 选择出最小数放在最前面
     */
    public static void selectSort(int arr[]) {
        int temp;
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String args[]) {

        int arr[] = new int[]{
                29, 65, 34, 24, 56, 4, 32, 56, 78, 97
        };

//        bubbleSort(arr);

        selectSort(arr);
    }
}
