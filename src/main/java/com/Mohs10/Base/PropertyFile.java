package com.Mohs10.Base;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile
{
	public static String getValueForKey(String key) throws Throwable
	{
		Properties config = new Properties();
		config.load(new FileInputStream("C:\\Users\\Dell\\Desktop\\Deepika\\Grid\\Painite_2023\\PropertyFile\\Pro_File"));
		return config.getProperty(key);
	}
}
