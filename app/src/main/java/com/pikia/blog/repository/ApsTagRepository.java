package com.pikia.blog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.blog.domain.ApsTagDomain;
import com.pikia.component.repository.ModelRepository;

public interface ApsTagRepository extends ModelRepository {

	@Select("SELECT * FROM APS_BLOG_TAG WHERE ID=#{id}")
	@Results(value = {
			@Result(property = "delflag", column = "DELFLAG", javaType = Boolean.class, jdbcType = JdbcType.BOOLEAN),
			@Result(property = "name", column = "NAME", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "num", column = "NUM", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "value", column = "VALUE", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	public ApsTagDomain get(@Param("id") Long id);

	@Insert("INSERT INTO APS_BLOG_TAG(NAME,VALUE) VALUES(#{name},#{value})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Object save(@Param("domain") ApsTagDomain domain);

	@Update("UPDATE APS_BLOG_TAG SET DELFLAG=#{delflag},NAME=#{name},VALUE=#{value},NUM=#{num} where ID=#{id}")
	public Object update(@Param("domain") ApsTagDomain domain);
	
	@Select("SELECT ID FROM APS_BLOG_TAG WHERE NAME LIKE #{name} and DELFLAG=0 ")
	public List<Long> getAbstractTagByName(@Param("name") String name);
	
	@Select("SELECT ID FROM APS_BLOG_TAG WHERE NAME = #{name} and DELFLAG=0 ")
	public List<Long> getTagByName(@Param("name") String name);
	
	@Select("SELECT ID FROM APS_BLOG_TAG WHERE DELFLAG=0 ")
	public List<Long> getAllTags();

	@Select("SELECT ID,NAME,VALUE FROM APS_BLOG_TAG WHERE VALUE LIKE #{value} and  DELFLAG=0")
	public List<Map> getTagByValueInMap(@Param("value") String value);

	@Select("SELECT DISTINCT VALUE,NUM  FROM APS_BLOG_TAG where DELFLAG=0 ORDER BY NUM DESC")
	public List<Map> getTagForWeb();

	/**
	 * 获取最新的标签,用于计算新插入的标签ID值
	 * 
	 * @return
	 */
	@Select("select * from APS_BLOG_TAG ORDER BY NAME DESC LIMIT 1")
	public Map getTheNewestTagFromDatabase();

	@Update("update APS_BLOG_TAG set DELFLAG=1 where ID=#{id}")
	public void delete(@Param("id") Long paramLong);
	@Update("update APS_BLOG_TAG set DELFLAG=1 where NAME=#{tagName}")
	public void deleteByName(@Param("tagName") String tagName);
	
	
}
