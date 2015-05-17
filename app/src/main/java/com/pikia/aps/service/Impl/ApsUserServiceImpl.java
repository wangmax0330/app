package com.pikia.aps.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pikia.aps.domain.ApsUserDomain;
import com.pikia.aps.repository.ApsUserRepository;
import com.pikia.aps.service.ApsUserService;
import com.pikia.component.web.util.JsonUtils;
import com.pikia.component.web.util.MathUtils;
import com.pikia.componet.pagination.PaginationQueryContext;
import com.pikia.componet.repository.ModelRepository;
import com.pikia.componet.repository.MyBatisRepository;
import com.pikia.componet.service.impl.ModelCrudServiceSupport;

@Service
public class ApsUserServiceImpl extends ModelCrudServiceSupport implements
		ApsUserService {
	@Resource
	private ApsUserRepository apsUserRepository;

	@Override
	public List getPagedModelIds(PaginationQueryContext queryContext) {
		List<Object> paramLs = new ArrayList<Object>();
		queryContext.setParams(paramLs.toArray());
		return this.queryForPaginationList(new MyBatisRepository() {
			@Override
			public List<Long> queryForPagination(int startIndex, int pageSize,
					String sortField, String sortType, Object... params) {
				return apsUserRepository.getPagedModelIds(startIndex, pageSize,
						sortField, null, null);
			}
		}, queryContext);
	}

	@Override
	public int getTotalCount(PaginationQueryContext queryContext) {
		return apsUserRepository.getTotalCount(null);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public Object getModel(Long id) {
		ApsUserDomain  userDomain=this.apsUserRepository.get(id);
		return userDomain;
	}

	@Override
	protected ModelRepository getModelRepository() {
		return this.apsUserRepository;
	}

	@Override
	public String getJsonList(List<ApsUserDomain> userList) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for (ApsUserDomain tmp : userList) {
			System.out.println(tmp);
			list.add(getJson(tmp));
		}
		return JsonUtils.JSON_List2String(list);
	}

	public Map<String, Object> getJson(ApsUserDomain tmp) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("id", tmp.getId());
		jsonMap.put("nickName", tmp.getNickName());
		jsonMap.put("mobile", tmp.getMobile());
		jsonMap.put("email", tmp.getEmail());
		if(StringUtils.isNotBlank(tmp.getMachineCode())){
			if (tmp.getMachineCode().length() > 30) {
				jsonMap.put("subMachineCode", tmp.getMachineCode().substring(0, 20)
						+ "...");
			}
		}
		jsonMap.put("machineCode", tmp.getMachineCode());
		
		jsonMap.put("appVersion", tmp.getAppVersion());
		jsonMap.put("city", tmp.getCity());
		jsonMap.put("amount", MathUtils.round(tmp.getAmount(), 1));
		if (StringUtils.isNotBlank(tmp.getPhoto())) {
			jsonMap.put("photo", tmp.getPhoto());
		}
		jsonMap.put("admin", tmp.isAdmin());
		jsonMap.put("ip", tmp.getIp());
		// 把Map中数据拼成字符串在前台显示
		return jsonMap;
	}
}