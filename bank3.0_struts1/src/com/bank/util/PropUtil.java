package com.bank.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	public static Properties getProp(String FileName) {
		Properties prop = new Properties();
		InputStream is = PropUtil.class.getClassLoader().getResourceAsStream(FileName);
		try {
			prop.load(is);
		} catch (IOException e) {
			prop = null;
		}
		return prop;
	}
}
