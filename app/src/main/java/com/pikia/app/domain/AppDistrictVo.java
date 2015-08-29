package com.pikia.app.domain;

import java.util.List;

public class AppDistrictVo {
    private Integer id;
    private String name;
    private List<AppBusinessVo> business;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<AppBusinessVo> getBusiness() {
	return business;
    }

    public void setBusiness(List<AppBusinessVo> business) {
	this.business = business;
    }

}
