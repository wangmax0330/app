package com.pikia.system.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {
	private static Properties pro;
	private static SystemProperties sp = new SystemProperties();

	public static String getProperties(String key) {
		return pro.getProperty(key);
	}

	/**
	 * 创建一个新的实例 SystemProperties.
	 * 
	 */
	private SystemProperties() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("/config/config.properties");
		try {
			pro = new Properties();
			pro.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String str = System.getProperty("user.dir");
		System.out.println(str);
		String markImagePlace = SystemProperties
				.getProperties("com.pikia.component.web.util.ImageUtils.markImagePlace");

		try {
			System.out.println(markImagePlace);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
