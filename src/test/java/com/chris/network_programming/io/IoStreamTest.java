package com.chris.network_programming.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.chris.network_programming.io.IoStream;

import junit.framework.TestCase;

public class IoStreamTest extends TestCase{
	public void testGenerateCharacters() {
		//java7引入的写法，try块中声明的AutoCloseable的对象会自动调用close方法
		try (OutputStream out = new FileOutputStream("D:\\MyDrivers\\project\\ecplise\\network-programming\\data\\data.txt")){
			IoStream.generateCharacters(out);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
				
	}
	
	public void testReadSingleCharacter() {
		try(InputStream in = new FileInputStream("D:\\\\MyDrivers\\\\project\\\\ecplise\\\\network-programming\\\\data\\\\data.txt")){
			IoStream.readSingleCharacter(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testReadByteArray() {
		try(InputStream in = new FileInputStream("D:\\\\MyDrivers\\\\project\\\\ecplise\\\\network-programming\\\\data\\\\data.txt")){
			IoStream.readByteArray(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testReadByteArrayWithOffset() {
		try(InputStream in = new FileInputStream("D:\\\\MyDrivers\\\\project\\\\ecplise\\\\network-programming\\\\data\\\\data.txt")){
			IoStream.readByteArrayWithOffset(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testeadAvailableByteArray() {
		try(InputStream in = new FileInputStream("D:\\\\MyDrivers\\\\project\\\\ecplise\\\\network-programming\\\\data\\\\data.txt")){
			IoStream.readAvailableByteArray(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
