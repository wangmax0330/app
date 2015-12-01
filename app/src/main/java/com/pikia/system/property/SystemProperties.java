package com.pikia.system.property;

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
		pro = new Properties();
		try {
			pro.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
