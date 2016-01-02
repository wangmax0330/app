package com.pikia.blog.domain;

import com.pikia.component.base.BaseDomain;

public class ApsTagDomain extends BaseDomain {
	private static final long serialVersionUID = 6182687768105438982L;
	private String name;
	private String value;
	private int num;// 标签数

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
