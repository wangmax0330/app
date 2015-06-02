package com.pikia.aps.domain;

import java.util.Date;

import com.pikia.component.base.BaseDomain;

public class ApsUserDomain extends BaseDomain {

    private String nickName; // 昵称
    private String realName; // 真实名称
    private Integer age; // 年龄
    private Date birthday;
    private Double amount; // 积分
    private String ip; // IP地址
    private String mobile; // 手机号码
    private String password; // 密码
    private String email; // 电子邮箱
    private String photo; // 头像
    private Boolean man; //
    private Integer city; // 所在城市
    private String address; // 地址
    private String machineCode; // 机器码
    private Date createTime;
    private String appVersion;

    public ApsUserDomain() {
    }

    public ApsUserDomain(Long id) {
	super(id);
    }

    // 是否是管理员
    public boolean isAdmin() {
	if (this.role == 1)
	    return true;
	else
	    return false;
    }

    public String getAppVersion() {
	return appVersion;
    }

    public void setAppVersion(String appVersion) {
	this.appVersion = appVersion;
    }

    public Date getCreateTime() {
	return createTime;
    }

    public void setCreateTime(Date createTime) {
	this.createTime = createTime;
    }

    private Integer role = 0; // 用户权限: 0 app用户 1 网页用户 2管理员

    public String getNickName() {
	return nickName;
    }

    public void setNickName(String nickName) {
	this.nickName = nickName;
    }

    public String getRealName() {
	return realName;
    }

    public void setRealName(String realName) {
	this.realName = realName;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    public Double getAmount() {
	return amount;
    }

    public void setAmount(Double amount) {
	this.amount = amount;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhoto() {
	return photo;
    }

    public void setPhoto(String photo) {
	this.photo = photo;
    }

    public Boolean getMan() {
	return man;
    }

    public void setMan(Boolean man) {
	this.man = man;
    }

    public Integer getCity() {
	return city;
    }

    public void setCity(Integer city) {
	this.city = city;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public Integer getRole() {
	return role;
    }

    public void setRole(Integer role) {
	this.role = role;
    }

    public String getMachineCode() {
	return machineCode;
    }

    public void setMachineCode(String machineCode) {
	this.machineCode = machineCode;
    }

}
