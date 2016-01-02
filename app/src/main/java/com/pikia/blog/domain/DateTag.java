package com.pikia.blog.domain;

import java.util.Date;

public class DateTag {
	private String createTime;
	private int num;

	public DateTag(String cretaTime, Long num) {
		this.createTime = cretaTime;
		this.num = num.intValue();
	}

	

	public String getCreateTime() {
		return createTime;
	}



	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
