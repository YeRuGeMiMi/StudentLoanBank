package lyh.web.studnet;

import java.util.List;

import lyh.base.BaseAction;
import lyh.po.school.School;
import lyh.services.school.SchoolServices;

public class SelfAction extends BaseAction{

	@Override
	public String execute() throws Exception {
		
		List<School> schools = SchoolServices.getAllSchools();
		
		super.request.put("schools", schools);
		return "In";
	}
	
	

}
