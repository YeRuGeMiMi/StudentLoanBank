package lyh.web.system;

import java.util.List;

import lyh.base.BaseAction;
import lyh.po.user.Roles;
import lyh.services.user.UserServices;

public class PowerMagAction extends BaseAction{

	@Override
	public String execute() throws Exception {
		UserServices userSer = new UserServices();
		List<Roles> roles = userSer.getAllRoles();
		
		super.request.put("roles", roles);
		return "In";
	}

}
