package com.iyestin.java.yjutils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class YFileWriter {

	public String filePath;
	
	public File file;
	
	public FileWriter fw;
	public BufferedWriter bw;
	
	public YFileWriter(String filePath) throws FileWriterInitException {
		this(filePath, false);
	}
	
	public YFileWriter(String filePath, boolean append) throws FileWriterInitException {
		super();
		this.filePath = filePath;
		file = new File(filePath);
		try {
			fw = new FileWriter(file, append);
		} catch (IOException e) {
			throw new FileWriterInitException(e);
		}
		bw = new BufferedWriter(fw);
	}
	
	public YFileWriter write(Object obj) throws IOException{
		bw.write(obj.toString());
		return this;
	}
	
	public YFileWriter write(String word) throws IOException{
		bw.write(word);
		return this;
	}
	
	public YFileWriter newLine() throws IOException{
		bw.write(System.lineSeparator());
		return this;
	}
	
	public YFileWriter newLine(String lineSeparator) throws IOException{
		bw.write(lineSeparator);
		return this;
	}
	
	public YFileWriter writeln(String line) throws IOException{
		bw.write(line);
		bw.write(System.lineSeparator());
		return this;
	}
	
	public YFileWriter writeln(String line, String lineSeparator) throws IOException{
		bw.write(line);
		bw.write(lineSeparator);
		return this;
	}
	
	public YFileWriter flush() throws IOException{
		fw.flush();
		return this;
	}
	
	public void close() throws IOException{
		flush();
		bw.close();
		fw.close();
	}
	
}
