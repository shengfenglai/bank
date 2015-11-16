

package com.cx.bank.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author laishengfeng
 * @version bank 1.1
 * @TODO properties的工具类
 */

public class PropUtil {
	public static Properties getProp(String FileName) {
		Properties prop = new Properties();
		InputStream is = PropUtil.class.getClassLoader().getResourceAsStream(FileName);
		try {
			prop.load(is);
		} catch (IOException e) {
			prop = null;
		} catch(NullPointerException e){
			prop = null;
		}
		return prop;
	}
}
