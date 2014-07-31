package lyh.web.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import util.RegexTools;

import lyh.base.BaseAction;
import lyh.services.user.UserServices;

/**
 * 注册
 * @author lyh
 *
 */
public class RegAction extends BaseAction{
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String type;
	private String name;
	private String selfcode;
	private String address;
	private String school;
	private String collage;
	private String years;
	
	
	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	public String getRepassword() {
		return repassword;
	}




	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSelfcode() {
		return selfcode;
	}




	public void setSelfcode(String selfcode) {
		this.selfcode = selfcode;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getSchool() {
		return school;
	}




	public void setSchool(String school) {
		this.school = school;
	}




	public String getCollage() {
		return collage;
	}




	public void setCollage(String collage) {
		this.collage = collage;
	}




	public String getYears() {
		return years;
	}




	public void setYears(String years) {
		this.years = years;
	}




	@Override
	public String execute() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("POST")){
			if(!RegexTools.regUserName(username)){
				super.request.setAttribute("message", "用户名格式有误！");
				return "In";
			}
			
			if(!password.equals(repassword)){
				super.request.setAttribute("message", "两次输入的密码不一致！");
				return "In";
			}
			
			if(!RegexTools.regUserName(password)){
				super.request.setAttribute("message", "用户名格式有误！");
				return "In";
			}
			
			if(!RegexTools.regSelfCode(selfcode)){
				super.request.setAttribute("message", "身份证号格式有误！");
				return "In";
			}
			
			if(!RegexTools.regEmail(email)){
				super.request.setAttribute("message", "邮箱格式有误！");
				return "In";
			}
			
			Map<String,String> keys = new HashMap<String, String>();
			keys.put("username", username);
			keys.put("password",password);
			keys.put("email", email);
			keys.put("type", type);
			keys.put("name", name);
			keys.put("selfcode", selfcode);
			keys.put("address", address);
			keys.put("collage", collage);
			keys.put("school", school);
			keys.put("years", years);
			
			UserServices ser = new UserServices();
			boolean bool = ser.regSave(keys);
			
			if(bool){
				return "sucess";
			}else{
				return "fail";
			}
			
		}
		
		return "In";
	}

	
	
	
	
}

