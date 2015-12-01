package com.pikia.blog.repository;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SelectBuilder;

public class ApsUserSqlProvider {
	public String getPagedModelIds(Map<String, Object> parameters) {

		String title = (String) parameters.get("title");
		Integer couponType = (Integer) parameters.get("couponType");
		String prizeNameStr = (String) parameters.get("prizeNameStr");
		String sortField = (String) parameters.get("sortField");

		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("S.ID");
		SelectBuilder.FROM("SPREAD_COUPON S");
		if (StringUtils.isNotBlank(title)) {
			SelectBuilder.WHERE("S.TITLE LIKE #{title}");
		}
		if (couponType != null) {
			SelectBuilder.WHERE("S.COUPON_TYPE=#{couponType}");
		}
		if (StringUtils.isNotBlank(prizeNameStr)) {
			SelectBuilder.WHERE("S.PRIZE_NAME_STR LIKE #{prizeNameStr}");
		}

		SelectBuilder.WHERE("S.DELFLAG=0");
		if (StringUtils.isNotBlank(sortField)) {
			SelectBuilder.ORDER_BY("#{sortField} #{sortType}");
		} else {
			SelectBuilder.ORDER_BY("S.ID DESC");
		}
		String dql = SelectBuilder.SQL();
		return dql + " limit #{startIndex},#{pageSize}";
	}

	public String getTotalCount(Map<String, Object> parameters) {
		String title = (String) parameters.get("title");
		Integer couponType = (Integer) parameters.get("couponType");
		String prizeNameStr = (String) parameters.get("prizeNameStr");

		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("count(S.ID)");
		SelectBuilder.FROM("SPREAD_COUPON S");
		if (StringUtils.isNotBlank(title)) {
			SelectBuilder.WHERE("S.TITLE LIKE #{title} ");
		}
		if (couponType != null) {
			SelectBuilder.WHERE("S.COUPON_TYPE=#{couponType}");
		}
		if (StringUtils.isNotBlank(prizeNameStr)) {
			SelectBuilder.WHERE("S.PRIZE_NAME_STR LIKE #{prizeNameStr}");
		}
		SelectBuilder.WHERE("S.DELFLAG=0");
		return SelectBuilder.SQL();
	}

}
