package com.iyestin.java.yjutils;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		YFileWriter fw = new YFileWriter("test.txt",true);
		fw.write("hi").write(1).newLine().write("hi").writeln("123");
		fw.close();
	}
	
}
