package lyh.web.order;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.student.Student;
import lyh.po.user.Member;
import lyh.services.student.StudentServices;

public class AddOrderAction extends BaseAction{
	private String money;
	private String bankcode;

	
	

	public String getBankcode() {
		return bankcode;
	}


	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


	@Override
	public String execute() throws Exception {
		Member member = (Member) super.session.get("member");
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("POST")){
			
		}
		
		StudentServices studentSer = new StudentServices();
		Student student = studentSer.getByUid(member.getUid());
		
		super.request.put("student", student);
		return "In";
	}

	
}
