package lyh.web.school;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;

public class AddCollageAction extends BaseAction{
	private String cocode;
	private String coname;
	
	

	public String getCocode() {
		return cocode;
	}



	public void setCocode(String cocode) {
		this.cocode = cocode;
	}



	public String getConame() {
		return coname;
	}



	public void setConame(String coname) {
		this.coname = coname;
	}



	@Override
	public String execute() throws Exception {
		Member member = (Member) super.session.get("member");
		
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("POST")){
			Map<String,String> map = new HashMap<String,String>();
			map.put("cocode", cocode);
			map.put("coname", coname);
			map.put("uid", String.valueOf(member.getUid()));
			
			int i = SchoolServices.saveCollage(map);
			if(i>0){
				return "Sucess";
			}
		}
		
		return "In";
	}
	
	

}
