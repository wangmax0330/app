package com.pikia.aps.repository;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SelectBuilder;

public class ApsUserSqlProvider {
	public String getPagedModelIds(Map<String, Object> parameter) {
		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("U.ID");
		SelectBuilder.FROM("APS_USER U");
		SelectBuilder.WHERE(" U.DELFLAG !=1 ");
		SelectBuilder.ORDER_BY(" t.CREATE_TIME DESC");
		String sql = SelectBuilder.SQL();
		return sql + "  limit #{startIndex},#{pageSize}";
	}

	public String getTotalCount(Map<String, Object> parameters) {
		String name = (String) parameters.get("name");
		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("COUNT(U.ID)");
		SelectBuilder.FROM("APS_USER U");
		SelectBuilder.WHERE(" U.DELFLAG!=1 ");
		if (StringUtils.isNotBlank(name)) {
			// SelectBuilder.WHERE("");
		}
		return SelectBuilder.SQL();
	}
}
