package cn.readsense.alg.java;

/**
 * 线性表的链式存储：通过用指针链接起来的节点来存储数据，物理结构上可以不连续
 */
public class Les2LinkArray {


    public static void main(String[] args) {
        //创建一个单链表
        LinkArray linkArray = new LinkArray();

        for (int i = 0; i < 5; i++) {
            linkArray.add_head(i);
        }
        System.out.println("头部插入0，1，2，3，4：");
        linkArray.toString();

        for (int i = 0; i < 5; i++) {
            linkArray.add_tail(i + 5);
        }
        System.out.println("尾部插入5，6，7，8，9：");
        linkArray.toString();

        LinkArray.Node node = linkArray.search(5);
        System.out.println(String.format("第%d个节点的值为%d", 5, node.data));

        linkArray.addIndex(101, 3);
        System.out.println("在第3个节点处插入101：");
        linkArray.toString();

        linkArray.delete(2);
        System.out.println("删除第2个节点：");
        linkArray.toString();


        linkArray.reverse1();
        System.out.println("翻转单链表：");
        linkArray.toString();

        linkArray.reverse2();
        System.out.println("递归翻转单链表：");
        linkArray.toString();

    }


    static class LinkArray<T> {
        private Node head;

        class Node {
            T data;
            Node next;

            public Node(T data) {
                this.data = data;
            }
        }

        /**
         * 头部插入：每次增加数据在当前链表之前，成为新的头节点
         *
         * @param a
         */
        void add_head(T a) {
            Node newNode = new Node(a);
            newNode.next = head;
            head = newNode;
        }

        /**
         * 尾部插入: 每次增加数据增加在当前链表之后，头节点不变
         *
         * @param a
         */
        void add_tail(T a) {
            Node newNode = new Node(a);
            if (head != null) {
                Node temp = head;
                while (null != temp.next) {
                    temp = temp.next;
                }
                temp.next = newNode;
            } else {
                head = newNode;
            }
        }

        /**
         * 单链表的查找，在链表中查寻第k个元素
         *
         * @param k index
         * @return
         */
        Node search(int k) {
            if (k < 1) return null;
            Node temp = head;
            int i = 1;
            while (null != temp) {
                if (i == k) return temp;
                temp = temp.next;
                i++;
            }
            return null;
        }

        /**
         * 在指定位置插入
         *
         * @param a
         * @param k
         */
        int addIndex(T a, int k) {
            if (k == 0) {
                Node newNode = new Node(a);
                newNode.next = head;
                head = newNode;
            } else {
                Node temp = search(k - 1);
                if (null == temp) return -1;
                Node newNode = new Node(a);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            return 0;
        }


        /**
         * 单链表的删除：删除第k个元素
         *
         * @param k
         * @return
         */
        int delete(int k) {
            if (k == 0) {
                head = head.next;
            } else {
                Node temp = search(k - 1);
                if (null == temp) return -1;//未找到k的前一个节点
                if (null == temp.next) return -1;//未找到k节点
                Node needDelete = temp.next;
                temp.next = needDelete.next;
                needDelete = null;
            }
            return 0;
        }

        /**
         * 单链表翻转：遍历，头部插入
         */
        void reverse1() {
            Node newHead = null;

            while (head != null) {
                //解开链表的头节点
                Node temp = head.next;
                head.next = null;

                //将其放置新链表newHead之前
                head.next = newHead;
                newHead = head;

                //当前链表头结点后移
                head = temp;
            }
            head = newHead;
        }

        void reverse2Help(Node newHead) {
            if (head != null) {
                //解开剩余链表的头节点
                Node temp = head.next;
                head.next = null;

                //将其放置newHead之前
                head.next = newHead;
                newHead = head;

                //当前链表头结点后移
                head = temp;
                reverse2Help(newHead);
            }
        }

        void reverse2() {
            Node newHead = null;
            reverse2Help(newHead);
            head = newHead;
        }


        @Override
        public String toString() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();

            return super.toString();
        }
    }


}
