package lyh.web.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lyh.base.BaseAction;
import lyh.po.school.Collage;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;

public class CollageAction extends BaseAction{

	@Override
	public String execute() throws Exception {
		Member member = (Member)super.session.get("member");
		Map<String,Object> keys = new HashMap<String,Object>();
		keys.put("scid", SchoolServices.getOneByUid(member.getUid()).getScid());
		
		List<Collage> collages = SchoolServices.collageList(keys);
		
		super.request.put("collages", collages);
		
		return "In";
	}
	
	

}
