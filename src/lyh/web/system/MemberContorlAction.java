package lyh.web.system;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.user.Member;
import lyh.services.user.UserServices;

public class MemberContorlAction extends BaseAction{
	private String oldpasswd;
	private String newpasswd;
	private String username;
	
	public String getOldpasswd() {
		return oldpasswd;
	}

	public void setOldpasswd(String oldpasswd) {
		this.oldpasswd = oldpasswd;
	}



	public String getNewpasswd() {
		return newpasswd;
	}



	public void setNewpasswd(String newpasswd) {
		this.newpasswd = newpasswd;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String execute() throws Exception {
		Member member = (Member)super.session.get("member");
		String method = ServletActionContext.getRequest().getMethod();
		
		if("POST".equals(method)){
			UserServices userSer = new UserServices();
			int s = userSer.userLogin(this.username, this.oldpasswd);
			if(s>0){
				boolean bool = userSer.updatePassword(s, newpasswd);
				if(bool){
					super.request.put("msg", "修改成功");
				}else{
					super.request.put("msg", "修改失败");
				}
			}else{
				super.request.put("msg", "原密码错误");
			}
			
			return "Su";
		}
		
		super.request.put("member", member);
		return "In";
	}
	
}
