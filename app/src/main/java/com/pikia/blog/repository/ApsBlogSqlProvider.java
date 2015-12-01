package com.pikia.blog.repository;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SelectBuilder;

public class ApsBlogSqlProvider {
	public String getPagedModelIds(Map<String, Object> parameters) {

		String startDate = (String) parameters.get("startDate");
		String endDate = (String) parameters.get("endDate");

		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("ID");
		SelectBuilder.FROM("APS_BLOG");
		if (StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(endDate)) {
			SelectBuilder.WHERE("CREATE_TIME >= #{startDate} AND CREATE_TIME <= #{endDate} ");
		}
		SelectBuilder.WHERE("DELFLAG=0");
		String dql = SelectBuilder.SQL();
		return dql + " limit #{startIndex},#{pageSize}";
	}

	public String getTotalCount(Map<String, Object> parameters) {
		String startDate = (String) parameters.get("startDate");
		String endDate = (String) parameters.get("endDate");

		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("count(1)");
		SelectBuilder.FROM("APS_BLOG");
		if (StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(endDate)) {
			SelectBuilder.WHERE("CREATE_TIME >= #{startDate} AND CREATE_TIME <= #{endDate} ");
		}
		SelectBuilder.WHERE("DELFLAG=0");
		return SelectBuilder.SQL();
	}

}
