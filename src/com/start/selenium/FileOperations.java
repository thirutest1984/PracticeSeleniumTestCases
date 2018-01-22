package com.start.selenium;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperations {

	public static void main(String[] args) throws Exception {
		
		String testFile = "D:\\temp.txt";
		File fc = new File(testFile);
		fc.createNewFile();
		
		FileWriter fw = new FileWriter(testFile);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("This is the first line.");
		bw.newLine();
		bw.write("Here is the second line.");
		bw.write("Continue writing.");
		bw.newLine();
		bw.write("");
		bw.newLine();
		bw.write("Third line.");
		bw.close();
		
		FileReader fr = new FileReader(testFile);
		BufferedReader br = new BufferedReader(fr);
		String content = "";
		
		while((content=br.readLine())!=null) {
			System.out.println(content);
		}
		br.close();

	}

}
