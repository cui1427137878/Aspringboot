package com.pd.common.utils;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.util.ResourceUtils;

public class FileUtil {
	public static String readFile(String fileName)
	{
		try {
			File file= ResourceUtils.getFile("classpath:"+fileName);
			FileInputStream fisFileInputStream=new FileInputStream(file);
			int length=fisFileInputStream.available();
			byte[] data=new byte[length];
			fisFileInputStream.read(data);
			String string=new String(data);
			return string;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

}
