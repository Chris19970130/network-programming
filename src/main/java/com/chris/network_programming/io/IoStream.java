package com.chris.network_programming.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IoStream {
	
	//通过FileOutPutStream将数据输出到data.txt，后续几个方法都利用data.txt进行测试
	public static void generateCharacters(OutputStream out) throws IOException {
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerline = 72;
		byte[] line = new byte[numberOfCharactersPerline + 2];
		
		int start = firstPrintableCharacter;
		
		for(int i=0;i<100;i++) {
			for(int j=start;j<start+numberOfCharactersPerline;j++) {
				line[j-start] = (byte)((j-firstPrintableCharacter)%numberOfCharactersPerline +firstPrintableCharacter);
			}
			line[72] = (byte)'\r';
			line[73] = (byte)'\n';
			out.write(line);
			start = (start+1-firstPrintableCharacter)%numberOfPrintableCharacters +firstPrintableCharacter;
		}
	}
	
	//read方法有三种，一种是一次读取一个字节返回0-256的一个int，以及另外两种从流中读取多个字节填充到一个制定的数组
	public static void readSingleCharacter(InputStream in) throws IOException {
		int b;
		while ((b=in.read())!=-1) {
			System.out.print((char)b);
		}
	}
	
	/* 
	 * 此方法byte字节尽管设置为10000，会尝试读取10000个字节，但实际只能读出的字节数是7400，
	 * 因此，比如在网络传输中,设置了字节数组长度为1000，但是实际到达的只有500个，其余500还在传输，这时只能读取到500个
	 * 如果希望所有数据都能读取到，需要重复读取，如下面的方法
	*/
	public static void readByteArray(InputStream in) throws IOException{
		byte[] input = new byte[10000];
		int bytesRead = in.read(input);
		System.out.println(bytesRead);
		for(int i=0;i<input.length;i++) {
			System.out.print((char)input[i]);
		}
	}
	
	/*
	 * 此方法重复向流进行读取，直到读取到所设置字节数组的长度或者读取到流的结尾
	 */
	public static void readByteArrayWithOffset(InputStream in) throws IOException{
		int bytesRead = 0;
		int bytesToRead = 7800;
		byte[] input = new byte[bytesToRead];
		
		while(bytesRead < bytesToRead) {
			int result = in.read(input,bytesRead,bytesToRead-bytesRead);
			if (result == -1) break;
			bytesRead += result;
		}
		
		System.out.println(bytesRead);
		for(int i=0;i<input.length;i++) {
			System.out.print((char)input[i]);
		}
	}
	
	/*
	 * 利用available方法确定当前可读的字节数，不想等待全部数据可用可以使用这个方法。
	 */
	public static void readAvailableByteArray(InputStream in) throws IOException{
		int available = in.available();
		byte[] input = new byte[available];
		int bytesRead = in.read(input);
		
		System.out.println(bytesRead);
		for(int i=0;i<input.length;i++) {
			System.out.print((char)input[i]);
		}
	}

}
