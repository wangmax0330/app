package com.pikia.aps.service;

import java.util.List;

import com.pikia.aps.domain.ApsUserDomain;
import com.pikia.componet.service.ModelCrudService;

public interface ApsUserService extends ModelCrudService {
	public Object getModel(Long id);

	public String getJsonList(List<ApsUserDomain> managers);
}
