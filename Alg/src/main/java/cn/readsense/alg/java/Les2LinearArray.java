package cn.readsense.alg.java;

import java.util.Arrays;

/**
 * 数据结构：线性存储结构的顺序存储 逻辑相邻的两个元素在物理位置上也相邻，元素之间的逻辑关系不占用额外的空间来存储 优点：查询较快 缺点：插入删除较慢
 * 经典示例：ArrayList
 */
public class Les2LinearArray {

    public static void main(String[] args) {

        // 创建数组
        LinearArray linearArray = new LinearArray(10);

        // 新增数据
        for (int i = 0; i < 10; i++) {
            linearArray.add(i);
            linearArray.toString();
        }

        // 插入操作

        // 插入操作

    }

    static class LinearArray {
        private int[] data;
        private int size = 10;
        private int last = -1;

        public LinearArray(int size) {
            this.size = size;
            data = new int[size];
            last = -1;
        }

        boolean isFull() {
            return last >= size - 1;
        }

        int add(int a) {
            if (isFull()) {
                System.out.println("full");
                return -1;
            }
            data[++last] = a;
            return last;
        }

        /**
         * 在指定位置（position）插入数据a，position之后的数据都后移一位
         * 
         * @param a
         * @param position
         * @return
         */
        int insert(int a, int position) {
            if (isFull()) {
                System.out.println("full");
                return -1;
            }

            data[position] = a;
            last++;
            return position;
        }

        @Override
        public String toString() {
            String format = String.format("size: %d, last: %d, data: %s", size, last, Arrays.toString(data));
            System.out.println(format);
            return format;
        }
    }
}
