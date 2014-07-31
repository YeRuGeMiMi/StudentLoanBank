package lyh.web.user;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.user.Member;
import lyh.services.user.UserServices;

/**
 * 登入
 * @author lyh
 *
 */
public class LoginAction extends BaseAction {
	
	//用户名
	private String username;
	//密码
	private String password;
	
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
	
	@Override
	public String execute() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("POST")){
			UserServices services = new UserServices();
			int s = services.userLogin(this.username, this.password);
			if(s > 0){
				Member member= services.getById(s);
				super.session.put("member",member );
				return "sucess";
			}
		}
		
		return "In";
	}
	
}

