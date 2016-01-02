package com.pikia.blog.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.component.repository.ModelRepository;

public interface ApsBlogRepository extends ModelRepository {

	@Select("SELECT * FROM APS_BLOG WHERE ID=#{id}")
	@Results(value = {
			@Result(property = "author.id", column = "USER_ID", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "title", column = "TITLE", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "createTime", column = "CREATE_TIME", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "content", column = "CONTENT", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "lastModifyTime", column = "LAST_MODIFY_TIME", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "publishState", column = "PUBLISH_STATE", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "viewNum", column = "VIEW_NUM", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "version", column = "VERSION", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "modifyTimes", column = "MODIFY_TIMES", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "simpleContent", column = "SIMPLE_CONTENT", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "tags", column = "TAGS", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "versionId", column = "VERSION_ID", javaType = Long.class, jdbcType = JdbcType.BIGINT) })
	public ApsBlogDomain get(@Param("id") Long id);

	@Insert("INSERT INTO APS_BLOG(TAGS,SIMPLE_CONTENT,MODIFY_TIMES,USER_ID,TITLE,CREATE_TIME,CONTENT,LAST_MODIFY_TIME,PUBLISH_STATE,VERSION,VERSION_ID) values(#{tags},#{simpleContent},#{modifyTimes},#{author.id},#{title},#{createTime},#{content},#{lastModifyTime},#{publishState},#{version},#{versionId})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Object save(@Param("domain") ApsBlogDomain domain);

	@Update("UPDATE APS_BLOG SET TAGS=#{tags},SIMPLE_CONTENT=#{simpleContent},LAST_MODIFY_TIME=#{lastModifyTime},MODIFY_TIMES=#{modifyTimes}, USER_ID=#{author.id},TITLE=#{title},CREATE_TIME=#{createTime},CONTENT=#{content},LAST_MODIFY_TIME=#{lastModifyTime},PUBLISH_STATE=#{publishState},VERSION=#{version},VERSION_ID=#{versionId} where ID=#{id}")
	public Object update(@Param("domain") ApsBlogDomain domain);

	@SelectProvider(type = ApsBlogSqlProvider.class, method = "getPagedModelIds")
	public List<Long> getPagedModelIds(@Param("startIndex") int startIndex,
			@Param("pageSize") int pageSize, @Param("sortField") String sortField,
			@Param("sortType") String sortType, @Param("startDate") String startDate,
			@Param("endDate") String endDate);

	@SelectProvider(type = ApsBlogSqlProvider.class, method = "getTotalCount")
	public int getTotalCount(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("tag") String tag, @Param("month") String month);

	@SelectProvider(type = ApsBlogSqlProvider.class, method = "getBlogForWeb")
	List<Long> getBlogForWeb(@Param("month") String month, @Param("tag") String tag,
			@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

	@Select("SELECT DATE_FORMAT(CREATE_TIME, '%Y-%m') AS date,count(*) as num FROM	APS_BLOG GROUP BY date")
	public List<Map> getDateForWeb();
}
