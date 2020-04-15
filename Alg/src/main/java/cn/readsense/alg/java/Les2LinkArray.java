package cn.readsense.alg.java;

/**
 * 线性表的链式存储：通过用指针链接起来的节点来存储数据，物理结构上可以不连续
 */
public class Les2LinkArray {


    public static void main(String[] args) {
        //创建一个单链表
        LinkArray linkArray = new LinkArray();

    }


    static class LinkArray<T> {
        class Node {
            T data;
            Node next;

            public Node(T data) {
                this.data = data;
            }
        }

        Node head;

        /**
         * 头部插入
         *
         * @param a
         */
        void add_headInsert(T a) {
            Node newNode = new Node(a);
            newNode.next = head;
            head = newNode;
        }

        /**
         * 尾部插入
         *
         * @param a
         */
        void add_tailInsert(T a) {
            Node newNode = new Node(a);
            Node temp = head;
            while (null != temp) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }
}
