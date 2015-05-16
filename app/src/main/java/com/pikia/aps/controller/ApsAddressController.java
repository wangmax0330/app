package com.pikia.aps.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pikia.app.domain.AppCityVo;
import com.pikia.aps.domain.ApsUserDomain;
import com.pikia.component.web.util.JsonUtils;
import com.pikia.componet.controller.ModelCrudController;

@Controller
public class ApsAddressController extends ModelCrudController {
//	@RequestMapping(value = "/city/list", method = { RequestMethod.POST,
//			RequestMethod.GET })
//	public void cityList(HttpServletRequest request,
//			HttpServletResponse response) {
		// try {
		// ApsUserDomain user = this.sessionService.getCurrentUser(request,
		// ApsUserDomain.class);
		// if (!user.isAdmin() && !user.isEditorAndApprover()
		// && !user.isPrize() && !user.isEditor()) {
		// ResponseUtils.writeGetJsonErrorMessage(response,
		// "您还没法访问，请联系管理员！", null);
		// return;
		// }
		// List<AppCityVo> cities = CityUtils.cities;
		// StringBuffer sb = new StringBuffer();
		// int idx = 0;
		// for (AppCityVo city : cities) {
		//
		// Map map = new HashMap();
		// map.put("id", city.getId());
		// map.put("name", city.getName());
		// if (idx > 0)
		// sb.append(",");
		// idx++;
		// sb.append(JsonUtils.JSON_Bean2String(map));
		//
		// }
		// ResponseUtils.writeMessage(response, "{\"isSuc\":\"1\",\"msg\":["
		// + sb + "]}");
		// } catch (Exception e) {
		// logger.error(e, e);
		// ResponseUtils.writeJsonErrorMessage(response, e.getMessage(), null);
		// }
//	}

}
