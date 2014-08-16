package lyh.web.school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.school.Collage;
import lyh.po.school.School;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;

public class AddProfessionAction extends BaseAction{
	private String procode;
	private int collage;
	private String proname;
	private int year;
	
	

	public String getProcode() {
		return procode;
	}



	public void setProcode(String procode) {
		this.procode = procode;
	}



	public int getCollage() {
		return collage;
	}



	public void setCollage(int collage) {
		this.collage = collage;
	}



	public String getProname() {
		return proname;
	}



	public void setProname(String proname) {
		this.proname = proname;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	@Override
	public String execute() throws Exception { 
		Member member = (Member) super.session.get("member");
		String method = ServletActionContext.getRequest().getMethod();
		
		if(method.equals("POST")){
			Map<String,Object> keys = new HashMap<String,Object>();
			keys.put("procode", procode);
			keys.put("proname", proname);
			keys.put("collage", collage);
			keys.put("year", year);
			
			int i = SchoolServices.saveProfession(keys);
			
			if(i>0){
				return "Sucess";
			}
		}
		
		School school = SchoolServices.getOneByUid(member.getUid());
		super.request.put("collages", new ArrayList<Collage>(school.getCollages()));
		
		return "In";
	}
	
	

}
