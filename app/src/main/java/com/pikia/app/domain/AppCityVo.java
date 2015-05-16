package com.pikia.app.domain;

import java.util.List;

import net.sf.ezmorph.bean.MorphDynaBean;

public class AppCityVo {
	private Integer id;
	private String name;
	private List<MorphDynaBean>  district;
	private Integer spt;
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
	public List<MorphDynaBean> getDistrict() {
		return district;
	}
	public void setDistrict(List<MorphDynaBean> district) {
		this.district = district;
	}
	public Integer getSpt() {
		return spt;
	}
	public void setSpt(Integer spt) {
		this.spt = spt;
	}
	
}
