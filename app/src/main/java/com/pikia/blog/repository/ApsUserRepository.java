package com.pikia.blog.repository;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.pikia.blog.domain.ApsUserDomain;
import com.pikia.component.repository.ModelRepository;

public interface ApsUserRepository extends ModelRepository {

	@Select("SELECT * FROM APS_USER WHERE ID=#{uid} and DELFLAG=0")
	@Results(value = {
			@Result(property = "birthday", column = "BIRTHDAY", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "userName", column = "USER_NAME", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "mobile", column = "MOBILE", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "PASSWORD", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "createTime", column = "CREATE_TIME", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "ip", column = "IP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "cityId", column = "CITY_ID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "email", column = "EMAIL", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "cityStr", column = "EMAIL", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "role", column = "ROLE", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "photo", column = "PHOTO", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "age", column = "AGE", javaType = Integer.class, jdbcType = JdbcType.INTEGER) })
	public ApsUserDomain get(@Param("uid") Long id);

	@Insert("INSERT INTO APS_USER(CITY_ID,DELFLAG,MOBILE,PASSWORD,ROLE,CITY_STR,BIRTHDAY,CREATE_DATE,EMAIL,USER_NAME,PHOTO)  values(#{cityId},#{delflag},#{mobile},#{password},#{role},#{cityStr},#{birthDay},#{createTime},#{email},#{userName},#{photo})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Object save(@Param("user") ApsUserDomain user);

	@Update("UPDATE APS_USER SET CITY_ID=#{cityId},DELFLAG=#{delflag},MOBILE=#{mobile},PASSWORD=#{password},ROLE=${role},CITY_STR=#{cityStr},BIRTHDAY=#{birthDay},CREATE_DATE=#{createTime},EMAIL=#{email},USER_NAME=#{userName},PHOTO=#{photo}, where ID=#{id}")
	public Object update(@Param("user") ApsUserDomain user);

}
