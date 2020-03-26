package cn.readsense.rscamera.alg;

public class Les1Search {

    public static void main(String[] args) {

        int[] list = {1,3,5,7,9};
        System.out.println("binary_search 5: "+binary_search(list, 5));
        System.out.println("binary_search 4: "+binary_search(list, 4));
    }

    /**
     * 二分查找算法
     *
     * @param list 已知从小到达有序数组
     * @param item 需要查找的数据
     */
    static int binary_search(int[] list, int item) {
        int low_position = 0;
        int high_position = list.length - 1;
        while (low_position <= high_position) {
            int mid = (low_position + high_position) / 2;
            int guess = list[mid];
            if (guess == item) return mid;
            else if (guess > item) {
                high_position = mid - 1;
            } else {
                low_position = mid + 1;
            }
        }
        return -1;
    }




}
