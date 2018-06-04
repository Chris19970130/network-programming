package com.chris.network_programming.address;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * author: 徐晨坤
 */
public class InetAddressTest extends TestCase {
    /**
     * 测试InetAddress的常用方法
     * InetAddress中包含一个主机名和一个IP地址
     */
    public void testInetAddressApi() throws IOException {
        //根据主机名获取InetAddress对象
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        //根据主机名获取全部的InetAddress对象
        InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress addr:addresses){
            System.out.println(addr);
        }
        //根据ip地址获取InetAddress,如果没有ip地址没有主机名，getHostName会返回IP地址
        address = InetAddress.getByName("61.135.169.121");
        System.out.println(address.getHostName());
        //查找本机地址，尝试请求DNS服务器得到一个真正的主机名和IP地址，失败则返回主机名如“localhost”和“127.0.01”
        //失败情况包括没有连接到Internet、系统没有固定IP或域名
        address = InetAddress.getLocalHost();
        System.out.println(address);

        //以上几种方法都需要和DNS服务器进行连接创建InetAddress，getByAddress方法可以不与DNS交互创建InetAddress，但是不保证主机存在
        byte[] addressBytes = {61,(byte) 135,(byte) 169,121};
        address = InetAddress.getByAddress(addressBytes);
        System.out.println(address);
        address = InetAddress.getByAddress("www.baidu.com",addressBytes);
        System.out.println(address);
    }
}
