package lyh.web.school;

import java.util.Map;

import lyh.base.BaseAction;
import lyh.services.school.SchoolServices;

public class AjaxGetProfessionsAction extends BaseAction{
	private String coid;
	private Map<String,String> result;
	
	public String getCoid() {
		return coid;
	}

	public void setCoid(String coid) {
		this.coid = coid;
	}



	public Map<String, String> getresult() {
		return result;
	}

	public void setresult(Map<String, String> result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		this.result = SchoolServices.ajaxProfessions(Integer.parseInt(this.coid));
		return "jsontree";
	}

}
