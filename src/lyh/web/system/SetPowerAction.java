package lyh.web.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.index.Menu;
import lyh.services.user.UserServices;

public class SetPowerAction extends BaseAction{
	private int roid;
	private String roids;
	
	public int getRoid() {
		return roid;
	}

	public void setRoid(int roid) {
		this.roid = roid;
	}
	
	public String getRoids() {
		return roids;
	}

	public void setRoids(String roids) {
		this.roids = roids;
	}

	@Override
	public String execute() throws Exception {
		
		UserServices userSer = new UserServices();
		if(roids != null){
			userSer.save(roid, roids);
		}
		Map<String,List<Menu>> result = userSer.getPowerByRole(this.roid);
		super.request.put("result", result);
		super.request.put("roid", this.roid);
		
		return "In";
	}
	
	
}
