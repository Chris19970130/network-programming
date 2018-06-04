package com.chris.network_programming.io;

import java.io.*;

import com.chris.network_programming.io.IoStream;

import junit.framework.TestCase;

public class IoStreamTest extends TestCase{
	public final static String DATA_DIR = System.getProperty("user.dir") + File.separator + "data";
	public void testGenerateCharacters() {
		//java7引入的写法，try块中声明的AutoCloseable的对象会自动调用close方法
		try (OutputStream out = new FileOutputStream(DATA_DIR + File.separator + "data.txt")){
			IoStream.generateCharacters(out);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
				
	}
	
	public void testReadSingleCharacter() {
		try(InputStream in = new FileInputStream(DATA_DIR + File.separator + "data.txt")){
			IoStream.readSingleCharacter(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testReadByteArray() {
		try(InputStream in = new FileInputStream(DATA_DIR + File.separator + "data.txt")){
			IoStream.readByteArray(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testReadByteArrayWithOffset() {
		try(InputStream in = new FileInputStream(DATA_DIR + File.separator + "data.txt")){
			IoStream.readByteArrayWithOffset(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testReadAvailableByteArray() {
		try(InputStream in = new FileInputStream(DATA_DIR + File.separator + "data.txt")){
			IoStream.readAvailableByteArray(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
