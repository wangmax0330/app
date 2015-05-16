package com.pikia.aps.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.pikia.aps.domain.ApsUserDomain;
import com.pikia.componet.repository.ModelRepository;

public interface ApsUserRepository extends ModelRepository {
	@Select("SELECT * FROM APS_USER WHERE ID=#{uid} AND DELFLAG=0")
	@Results(value = {
			@Result(property = "nickName", column = "NICK_NAME", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "realName", column = "REAL_NAME", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "age", column = "AGE", javaType = Integer.class, jdbcType = JdbcType.TINYINT),
			@Result(property = "birthday", column = "BIRTHDAY", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "amount", column = "AMOUNT", javaType = Double.class, jdbcType = JdbcType.DOUBLE),
			@Result(property = "ip", column = "IP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "mobile", column = "MOBILE", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "password", column = "PASSWORD", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "email", column = "EMAIL", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "photo", column = "PHOTO", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "man", column = "IS_MAN", javaType = Boolean.class, jdbcType = JdbcType.BOOLEAN),
			@Result(property = "address", column = "ADDRESS", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "machineCode", column = "MACHINE_CODE", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "createTime", column = "CREATE_TIME", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP) })
	public ApsUserDomain get(@Param("uid") Long id);

	@Insert("INSERT INTO APS_USER(NICK_NAME,REAL_NAME,AGE,BIRTHDAY,AMOUNT,IP,MOBILE,PASSWORD,EMAIL,PHOTO,IS_MAN,ADDRESS,MACHINE_CODE,CREATE_TIME) "
			+ " values"
			+ "(#{nickName},#{realName},#{age},#{birtyday},#{amount},#{ip},#{mobile},#{password},#{email},#{photo},#{man},#{address},#{machineCode},#{createTime})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Object save(@Param("user") ApsUserDomain user);

	@Update("UPDATE APS_USER SET NICK_NAME=#{nickName},REAL_NAME=#{realName},AGE=#{age},BIRTHDAY=#{birthday},AMOUNT=#{amount},IP=#{ip},MOBILE=#{mobile},PASSWORD=#{password},EMAIL=#{email},PHOTO=#{photo},IS_MAN=#{man},ADDRESS=#{address},MACHINE_CODE=#{machineCode},CREATE_TIME=#{createTime}")
	public Object update(@Param("user") ApsUserDomain user);

	@Update("UPDATE APS_USER SET DELFLAG=1 WHERE ID=#{id}")
	public void delete(@Param("id") Long id);

	@SelectProvider(type = ApsUserSqlProvider.class, method = "getPagedModelIds")
	public List<Long> getPagedModelIds(@Param("startIndex") int startIndex,
			@Param("pageSize") int pageSize,
			@Param("sortField") String sortField,
			@Param("sortType") String sortType, @Param("name") Object name);

	@SelectProvider(type = ApsUserSqlProvider.class, method = "getTotalCount")
	public int getTotalCount(@Param("name") String name);

}
