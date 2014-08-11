package lyh.web.school;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.school.School;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;

public class SelfAction extends BaseAction{
	
	private String name;
	private String scode;
	private String email;
	private String address;
	private String officetel;
	private String fax;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getScode() {
		return scode;
	}


	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public String execute() throws Exception {
		Member member = (Member)super.session.get("member");
		
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("POST")){
			Map<String,Object> keys = new HashMap<String, Object>();
			
			keys.put("name", name);
			keys.put("scode", scode);
			keys.put("email", email);
			keys.put("address", address);
			keys.put("officetel", officetel);
			keys.put("fax", fax);
			keys.put("member", member);
			
			int i = SchoolServices.saveOneSchool(keys);
			
			if(!(i>0)){
				return "fail";
			}
		}
		
		int uid = member.getUid();
		School school = SchoolServices.getOneByUid(uid);
		
		if(school != null){
			super.request.put("school", school);
		}
		
		return "In";
	}

	
}
