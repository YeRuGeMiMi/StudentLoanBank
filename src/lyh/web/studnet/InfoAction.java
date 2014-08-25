package lyh.web.studnet;

import lyh.base.BaseAction;
import lyh.po.user.Member;

public class InfoAction extends BaseAction {

	@Override
	public String execute() throws Exception {
		Member member = (Member)super.session.get("member");
		
		
		return "In";
	}
	
	

}
