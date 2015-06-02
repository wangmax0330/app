package com.pikia.aps.controller;

import org.springframework.stereotype.Controller;

import com.pikia.component.controller.ModelCrudController;

@Controller
public class ApsAddressController extends ModelCrudController {
    // @RequestMapping(value = "/city/list", method = { RequestMethod.POST,
    // RequestMethod.GET })
    // public void cityList(HttpServletRequest request,
    // HttpServletResponse response) {
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
    // }

}
