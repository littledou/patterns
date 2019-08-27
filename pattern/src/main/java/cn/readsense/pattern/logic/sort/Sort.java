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

    /**
     * 向有序数组中插入新的数据，初始有序数组的长度为1
     *
     * @param arr
     */
    public static void insertSort(int arr[]) {
        int temp;
        int length = arr.length;


//        for (int i = 0; i < length - 1; i++) {//选择指定index,跟他前一元素进行比较，谁大谁放后面
//
//            //从后往前比较，如果index小就交换，交换次数可能有点多
//            for (int j = i + 1; j > 0; j--) {//最多循环i-1次，插入指定index后，前i数就为有序了
//
//                if (arr[j] < arr[j - 1]) {
//                    temp = arr[j - 1];
//                    arr[j - 1] = arr[j];
//                    arr[j] = temp;
//                } else {
//                    break;
//                }
//            }
//        }


        for (int i = 1; i < length; i++) {//选择指定index,跟他前一元素进行比较，谁大谁放后面

            //从前往后比较，如果index小就交换，插入一次就结束了, 必须从小往大比较才能实现这种方式，如果逆序就要重新定义比对方向
            System.out.println("before: " + Arrays.toString(arr));
            for (int j = 0; j < i; j++) {

                if (arr[i] < arr[j]) {

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    break;
                }
            }

            System.out.println(Arrays.toString(arr));
        }


    }

    public static void main(String args[]) {

        int arr[] = new int[]{
                29, 65, 34, 97, 24, 56, 4, 32, 56, 78
        };

        insertSort(arr);
    }
}
