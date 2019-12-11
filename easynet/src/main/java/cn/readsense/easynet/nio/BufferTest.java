package cn.readsense.easynet.nio;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class BufferTest {


    public static void main(String[] args) throws SocketException {


        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();


        while(networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();

            System.out.println(networkInterface.toString());
        }

    }
}
