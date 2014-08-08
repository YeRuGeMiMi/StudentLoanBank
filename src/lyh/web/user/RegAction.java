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

	@Override
	public String execute() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("POST")){
			if(!RegexTools.regUserName(username)){
				super.request.put("message", "用户名格式有误！");
				return "In";
			}
			
			if(!password.equals(repassword)){
				super.request.put("message", "两次输入的密码不一致！");
				return "In";
			}
			
			if(!RegexTools.regUserName(password)){
				super.request.put("message", "用户名格式有误！");
				return "In";
			}
			
			
			
			if(!RegexTools.regEmail(email)){
				super.request.put("message", "邮箱格式有误！");
				return "In";
			}
			
			Map<String,String> keys = new HashMap<String, String>();
			keys.put("username", username);
			keys.put("password",password);
			keys.put("email", email);
			keys.put("type", type);
			
			
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

