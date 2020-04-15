package cn.readsense.alg.java;

import java.util.Arrays;

/**
 * 数据结构：线性存储结构的顺序存储 逻辑相邻的两个元素在物理位置上也相邻，元素之间的逻辑关系不占用额外的空间来存储 优点：查询较快 缺点：插入删除较慢
 * 经典示例：ArrayList
 */
public class Les1LinearArray {

    public static void main(String[] args) {

        // 创建数组
        LinearArray linearArray = new LinearArray(10);

        // 新增数据
        System.out.println("新增5条数据");
        for (int i = 0; i < 5; i++) {
            linearArray.add(i);
            linearArray.toString();
        }

        System.out.println("在position2处插入一个值为11的数字");
        // 插入操作
        linearArray.insert(2, 11);
        linearArray.toString();

        System.out.println("将position3处更新为13");
        //更新操作
        linearArray.update(3, 13);
        linearArray.toString();

        System.out.println("删除position5");
        // 删除操作
        linearArray.delete(5);
        linearArray.toString();

    }

    static class LinearArray {
        private int[] data;
        private int size;
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
        int insert(int position, int a) {
            if (isFull()) {
                System.out.println("full");
                return -1;
            }
            if (position < 0 || position > last) {
                System.out.println("index is invid");
                return -1;
            }
            // 扩容
            last++;
            // 后移
            for (int i = last; i > position; i--) {
                data[i] = data[i - 1];
            }
            // 赋值
            data[position] = a;
            return position;
        }

        /**
         * 更新指定position位置值
         *
         * @param position
         * @param a
         */
        public int update(int position, int a) {
            if (position < 0 || position > last) {
                System.out.println("index is invid");
                return -1;
            }
            data[position] = a;
            return position;
        }

        /**
         * 删除指定index的元素，之后的元素向前移
         *
         * @param position
         */
        public int delete(int position) {
            if (position < 0 || position > last) {
                System.out.println("index is invid");
                return -1;
            }
            // 前移数据
            for (int i = position; i < last; i++) {
                data[i] = data[i + 1];
            }
            // 后值清空
            data[last] = 0;
            // 缩容
            last--;
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
