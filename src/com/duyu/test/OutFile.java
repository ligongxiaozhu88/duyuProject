package com.duyu.test;

import java.io.File;
import java.io.FileOutputStream;

public class OutFile {

	public static void main(String args[]) {
		try {
			// 创建文件对象
			File file = new File("c:\\", "test");
			// 真正的创建文件
			file.createNewFile();

			// FileInputStream inputStream = new FileInputStream(file);
			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write("11".getBytes());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
