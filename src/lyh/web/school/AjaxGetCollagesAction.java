package lyh.web.school;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.services.school.SchoolServices;

public class AjaxGetCollagesAction extends BaseAction{
	private String school;
	private Map<String,String> result;
	
	
	public Map<String, String> getResult() {
		return result;
	}

	public void setResult(Map<String, String> result) {
		this.result = result;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}



	@Override
	public String execute() throws Exception {
		this.result = SchoolServices.ajaxCollages(Integer.parseInt(school));
		
		return "jsontree";
	}
	
	

}
