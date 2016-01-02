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
		String month = (String) parameters.get("month");
		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("count(1)");
		SelectBuilder.FROM("APS_BLOG");
		if (StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(endDate)) {
			SelectBuilder.WHERE("CREATE_TIME >= #{startDate} AND CREATE_TIME <= #{endDate} ");
		}
		if (StringUtils.isNotBlank(month)) {
			SelectBuilder.WHERE("CREATE_TIME >= '" + month+ "-01 00:00:00'" + " AND CREATE_TIME <= '" + month
					+ "-31 23:59:59'");
		}
		String tag = (String) parameters.get("tag");
		if (StringUtils.isNotBlank(tag)) {
			SelectBuilder.WHERE("TAGS LIKE '%" + tag + "%'");

		}
		SelectBuilder.WHERE("DELFLAG=0");
		String sql=SelectBuilder.SQL();
		return sql;
	}

	public String getBlogForWeb(Map<String, Object> parameters) {
		String month = (String) parameters.get("month");
		String tag = (String) parameters.get("tag");
		Integer startIndex = (Integer) parameters.get("startIndex");
		Integer pageSize = (Integer) parameters.get("pageSize");

		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("id");
		SelectBuilder.FROM("APS_BLOG");
		if (StringUtils.isNotBlank(month)) {
			SelectBuilder.WHERE("CREATE_TIME >= '" + month+ "-01 00:00:00'" + " AND CREATE_TIME <= '" + month
					+ "-31 23:59:59'");
		}
		if (StringUtils.isNotBlank(tag)) {
			SelectBuilder.WHERE("TAGS LIKE '%" + tag + "%'");

		}
		SelectBuilder.WHERE("DELFLAG=0");
		SelectBuilder.WHERE("PUBLISH_STATE=1");
		SelectBuilder.ORDER_BY("CREATE_TIME desc");
		String dql = SelectBuilder.SQL();
		dql = dql + " limit #{startIndex},#{pageSize}";
		return dql;
	}
}
