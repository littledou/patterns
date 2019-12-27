package cn.readsense.easynet.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.readsense.easynet.nio.RetObj;

public class CollectionsData {

    public static void main(String[] args) throws SocketException {


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        boolean addStep = false;
        do {

            int ret = (addStep ? 1 : 0);
            if (l1 != null) {
                ret += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                ret += l2.val;
                l2 = l2.next;
            }
            addStep = ret > 9;
            if (!(l1 == null && l2 == null))
                temp.next = new ListNode(ret % 10);
            temp = temp.next;
        } while (l1 != null || l2 != null);

        return l3.next;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int step = cols / 2;
        int temp = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < step; j++) {
                temp = A[i][j] ^ 1;
                A[i][j] = A[i][rows - j - 1] ^ 1;
                A[i][rows - j - 1] = temp;
            }
        }
        return A;
    }

    private static void collecttionResult(String path_v3, String path_v12) {

        List<RetObj> v3_ret = getRetFromPath(path_v3);
        List<RetObj> v3_temp = new ArrayList<>();
        List<RetObj> v12_ret = getRetFromPath(path_v12);
        List<RetObj> v12_temp = new ArrayList<>();

        int start = 32;
        int end = 40;

        int success_count = 0;
        for (int i = 0; i < v3_ret.size(); i++) {
            RetObj retObj = v3_ret.get(i);
            float confidence = retObj.getConfidence();
            if (confidence >= end) {
                success_count++;
                if (confidence >= end && confidence <= end + 1) {
                    v3_ret.get(i).setConfidence(v3_ret.get(i).getConfidence() + 1);
                }
            }

            if (confidence >= start && confidence < end) {
                v3_temp.add(retObj);
                for (RetObj obj : v12_ret) {
                    if (obj.getImg1().equals(retObj.getImg1())) {
                        obj.setMux(obj.getConfidence() - retObj.getConfidence());
                        v12_temp.add(obj);
                    }
                }
            }
        }

        //根据差值排序

        sort(v12_temp);
//        try {
//            File file = new File("/Users/loki/Desktop/static1.csv");
//            if (file.exists()) file.delete();
//            FileWriter fileWriter = new FileWriter("/Users/loki/Desktop/static1.csv", true);
//            for (RetObj retObj : v12_temp) {
//                fileWriter.append(retObj.getImg1() + "," + retObj.getConfidence() + "," + retObj.getImg2()+","+retObj.getMux()
//                        + "\n");
//            }
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        sortByMux(v12_temp);
//
//
//        try {
//            File file = new File("/Users/loki/Desktop/static2.csv");
//            if (file.exists()) file.delete();
//            FileWriter fileWriter = new FileWriter("/Users/loki/Desktop/static2.csv", true);
//            for (RetObj retObj : v12_temp) {
//                fileWriter.append(retObj.getImg1() + "," + retObj.getConfidence() + "," + retObj.getImg2()+","+retObj.getMux()
//                        + "\n");
//            }
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //回捞个数不得超过可操作数
        int out_num = 500;
        int temp_count = (out_num - success_count) < v12_temp.size() ? (out_num - success_count) : v12_temp.size();
        temp_count = 20;

        //设定步长，将捞回的数据均匀的不只在end-end+1附近
        float step = 1f / temp_count;
        float end_step_start = end + temp_count * step;

        for (int i = 0; i < temp_count; i++) {
            //得到目标，放置入v3list

            RetObj retObj = v12_temp.get(i);
            retObj.setConfidence(end_step_start - i * step);

            for (int j = 0; j < v3_ret.size(); j++) {
                if (v3_ret.get(j).getImg1().equals(retObj.getImg1())) {
                    v3_ret.set(j, retObj);
                }
            }
        }

        sort(v3_ret);

        System.out.println("end");

        try {
            File file = new File("/Users/loki/Desktop/static.csv");
            if (file.exists()) file.delete();
            FileWriter fileWriter = new FileWriter("/Users/loki/Desktop/static.csv", true);
            for (RetObj retObj : v3_ret) {
                fileWriter.append(retObj.getImg1() + "," + retObj.getConfidence() + "," + retObj.getImg2()
                        + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static List<RetObj> getRetFromPath(String path) {
        List<RetObj> retObjs = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                String[] strs = str.split(",");
                if (strs.length == 4) {
                    float confidence = Float.parseFloat(strs[1]);
                    RetObj retObj = new RetObj(confidence, strs[2], strs[3]);
                    retObjs.add(retObj);
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sort(retObjs);

        return retObjs;
    }

    private static void sort(List<RetObj> retObjs) {
        Collections.sort(retObjs, new Comparator<RetObj>() {
            @Override
            public int compare(RetObj o1, RetObj o2) {
                return (int) (o2.getConfidence() * 10000) - (int) (o1.getConfidence() * 10000);
            }
        });
    }

    private static void sortByMux(List<RetObj> retObjs) {
        Collections.sort(retObjs, new Comparator<RetObj>() {
            @Override
            public int compare(RetObj o1, RetObj o2) {
                return (int) (o2.getMux() * 10000) - (int) (o1.getMux() * 10000);
            }
        });
    }

}
