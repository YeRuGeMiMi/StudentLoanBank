package lyh.web.order;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.bank.Bank;
import lyh.po.student.Student;
import lyh.po.user.Member;
import lyh.services.apply.ApplyServices;
import lyh.services.bank.BankServices;
import lyh.services.student.StudentServices;

public class AddOrderAction extends BaseAction{
	private String money;
	private String bankcode;
	private String bank;

	

	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}

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
		//取得学生信息
		StudentServices studentSer = new StudentServices();
		Student student = studentSer.getByUid(member.getUid());
		
		if(method.equals("POST")){
			ApplyServices applySer = new ApplyServices();
			boolean bool = applySer.createApply(student, Integer.parseInt(bank), bankcode, Float.valueOf(money));
		}
		
		//取得银行列表
		BankServices bankSer = new BankServices();
		List<Bank> banks = bankSer.getAllBank();
		
		super.request.put("student", student);
		super.request.put("banks", banks);
		return "In";
	}

	
}
