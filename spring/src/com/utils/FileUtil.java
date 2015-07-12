package com.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	public static boolean saveImage(byte[] toSaveData, String target) {
		boolean result = true;
		InputStream inputStream = null;
		FileOutputStream os = null;
		try {
			 inputStream = new ByteArrayInputStream(toSaveData);
			File outFile = new File(target);
			 os = new FileOutputStream(outFile);
			byte[] temp = new byte[1024];
			int length = -1;

			while ((length = inputStream.read(temp)) != -1) {
				os.write(temp, 0, length);
			}
		} catch (Exception ex) {
			result = false;
		}finally {
			if(inputStream != null)
			{
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null)
			{
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
